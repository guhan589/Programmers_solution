package javastandard;


/**
 * 자바의 정석 739
 * chapter 12 쓰레드
 * */
public class ThreadEx8 {
    public static void main(String[] args) {
        Thread thread1 = new ThreadEx8_1();
        Thread thread2 = new ThreadEx8_2();

        thread1.setPriority(7);
        System.out.println("thread1.getPriority() = " + thread1.getPriority());
        System.out.println("thread2.getPriority() = " + thread2.getPriority());
        thread1.start();
        thread2.start();


    }
}

class ThreadEx8_1 extends Thread{

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.print("\n");
            for (int j = 0; j < 10000000; j++) {
                System.out.print(i);
                System.out.print(j);
            }

        }
    }

}

class ThreadEx8_2 extends Thread{

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.print("\n");
            for (int j = 0; j < 10000000; j++) {
                System.out.print(i);
                System.out.print(j);
            }

        }
    }

}

