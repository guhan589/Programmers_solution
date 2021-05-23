package javastandard;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinEx1 {
    static final ForkJoinPool pool = new ForkJoinPool(); //쓰레드 풀 생성
    public static void main(String[] args) {
        long from = 1, to = 100_000_000L;
        SumTask task = new SumTask(from, to);

        long start = System.currentTimeMillis();
        long result = pool.invoke(task);
        System.out.println("Elasped time(6core): " + (System.currentTimeMillis() - start));
        System.out.printf("sum of %d~%d = %d%n", from, to, result);
        System.out.println();

        result = 0L;
        start = System.currentTimeMillis();
        for (long i = from; i < to; i++) {
            result += i;
        }
        System.out.println("Elapsed time (1core):" + (System.currentTimeMillis() - start));
        System.out.printf("sum of %d~%d = %d%n", from, to, result);
    }

}

class SumTask extends RecursiveTask<Long> {

    long from, to;

    public SumTask(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        long size = to - from + 1;
        if(size <= 5)
            return sum();
        long half = (from + to) / 2;
        SumTask leffSum = new SumTask(from, half);
        SumTask rightSum = new SumTask(half, to);

        leffSum.fork();
        return rightSum.compute() + leffSum.join();

    }

    long sum() {
        long temp = 0L;
        for (long i = from; i < to; i++) {
            temp += 1;
        }
        return temp;
    }

}
