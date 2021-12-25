package com.programmers.level1;

import java.util.Arrays;

public class Budget {
    /*Level 1 예산 */
    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int budget = 9;

        /*int[] d = {2,2,3,3};
        int budget = 10;*/
        int solution = solution(d, budget);
        System.out.println("solution = " + solution);
    }
    public static int solution(int[] d, int budget) {
        int answer = 0;
        int result = 0;
        Arrays.sort(d); // 오름차순 정렬

        for (int i = 0; i < d.length; i++) {
            result += d[i];
            if (result > budget) {
                answer = i;
                break;

            }

        }

        if (result <= budget) {
            answer = d.length;
        }

        return answer;
    }
}
