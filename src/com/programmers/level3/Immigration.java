package com.programmers.level3;

import java.util.Arrays;

/**
 * 입국심사 level3 (완성)
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
        end = (long) n * times[times.length - 1]; // 최대 심사시간

//        answer = end; //최악의 상황을 고려

        int count = 1;
        while (start <= end) {
            System.out.println("====" + count + "====");
            ++count;
            mid = (start + end) / 2; //중간 값
            System.out.println("mid = " + mid);
            sum = 0;
            for (int i = 0; i < times.length; i++) {
                // 반복문을 통해 각 심사자들의 소요시간에 따른 몇명의 사람들이 심사가 가능한지를 sum변수에 저장
                sum += mid / times[i];
            }
            System.out.println("sum = " + sum);
            if (n > sum) { // 심사해야할 사람이 심사가능한 수보다 많을 경우
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
            System.out.println("start = " + start);
            System.out.println("end = " + end);
        }
        return answer;
    }
}
