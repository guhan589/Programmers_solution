package com.programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Morespicy {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        int solution = solution(scoville, k);

        System.out.println("solution = " + solution);

    }
    static int solution(int[] scoville, int K) {
        int answer = 0;
        int count = 0;

        //맵기 정도를 오름차순으로 정렬
        Arrays.sort(scoville);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int spicy : scoville) {
            queue.offer(spicy);
        }
        while (queue.peek() < K) {
            if (queue.size() == 1) {
                answer = -1;
                return answer;
            }

            int num1 = queue.poll();//오름차순 첫번쨰 값
            int num2 = queue.poll();//오름차순 두번쨰 값

            queue.offer(num1 + (num2 * 2));
            answer++;

        }
        return answer;
    }
}
