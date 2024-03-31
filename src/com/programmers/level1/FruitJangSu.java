package com.programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class FruitJangSu {
    public static void main(String[] args) {
        int k = 3, m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};
//        int k = 4, m = 3;
//        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        int solution = solution(k, m, score);
        System.out.println("solution = " + solution);
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        for (int i = score.length - 1; i >= 0; i = i - m) {
            if(i-m<-1){//인덱스 초과
                break;
            }else{
                for (int j = i; j > i - m; j--) {

                }
            }
        }
        return answer;
    }
}
