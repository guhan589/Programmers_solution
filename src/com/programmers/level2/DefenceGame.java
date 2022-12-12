package com.programmers.level2;

import java.util.Arrays;
import java.util.Collections;

public class DefenceGame {
    public static void main(String[] args) {
        int n = 7, k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        int solution = solution(n, k, enemy);
        System.out.println("solution = " + solution);

    }
    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;

        if (k == enemy.length)
            return k;



        for (int i : enemy) {
            System.out.println("i = " + i);
        }
        return answer;
    }

}
