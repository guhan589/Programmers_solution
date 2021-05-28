package com.programmers.kstec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test4 {

    public static void main(String[] args) {
        int[] arrA = {7, 8, 10};
        int[] arrB = {10, 7, 8};
        boolean solution = solution(arrA, arrB);
        System.out.println("solution = " + solution);

    }

    public static boolean solution(int[] arrA, int[] arrB) {
        boolean answer = false;
        int temp;
        for (int i = 0; i < arrA.length; i++) {
            temp = arrA[0];

            for (int j = 0; j < arrA.length - 1; j++) {
                arrA[j] = arrA[j + 1];
            }
            arrA[arrA.length - 1] = temp;

            if (Arrays.equals(arrA, arrB)) {
                answer = true;
                break;
            }
        }
        return answer;
    }

    static boolean check(List<Integer> list, int[] arr) {
        boolean state = true;
        if (list.size() != arr.length) { //두 배열의 비교대상이 다를 경우
            return false;
        }else{

        }
        return state;
    }
}
/**
 *
 *  int temp = arrA[arrA.length - 1];//arrA 배열의 마지막 값을 temp로 선언
 *         List<Integer> list = new ArrayList<>();
 *         for (int i : arrA) {//arrA의 배열의 모든 원소를 list에 추가
 *             list.add(i);
 *         }
 *         for (int i = 0; i < arrA.length; i++) {
 *             list.add(0, temp);
 *             list.remove(arrA.length);
 *
 *             if (check((list), arrB)) {
 *                 break;
 *             } else {
 *                 answer = false;
 *             }
 *             //한번 순환 후에 마지막값을 temp에 저장
 *             temp = list.get(arrA.length - 1);
 *
 *         }
 * */