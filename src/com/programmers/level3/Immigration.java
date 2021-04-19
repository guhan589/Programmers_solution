package com.programmers.level3;

import java.util.Arrays;

/**
 * 입국심사 level3 (미완성)
 * */
public class Immigration {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        long solution = solution(n, times);

        System.out.println("solution = " + solution);

    }
    static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);//심사시간을 오름차순으로 정렬

        long start, end, mid, sum = 0;
        start = 1;
        end = (long) n * times[times.length - 1];

        answer = end;
        while (start <= end) {
            mid = (start + end) / 2;

            sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            if (n > sum) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
