package com.programmers.level3;

import java.util.PriorityQueue;
/**
 * 이중우선순위 큐 level3 (미완성)
 * */
public class QuadrantPriorityQueue {
    public static void main(String[] args) {
//        String[] opertation = {"I 16", "D 1"};
        String[] opertation = {"I 7","I 5","I -5","D -1"};
        int[] solution = solution(opertation);
        for (int i : solution)
            System.out.println("i = " + i);

    }

    static int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (String operation : operations) {
//            System.out.println("operation = " + operation);
//            System.out.println("operation.length = " + operation.length());
            String[] split = operation.split(" ");
            int num = Integer.parseInt(split[1]);
            if (split[0].equals("I")) {//queue add
                queue.add(num);
            }else{//queue poll
//                System.out.println("queue.stream().min().get() = " + queue.stream().min(Integer.).get());
            }
        }

        for (Integer integer : queue) {
            System.out.println("integer = " + integer);
        }

        return answer;
    }

}
