package com.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class SquareN {
    public static void main(String[] args) {
        int n = 3;
        int left = 2 ;
        int right = 5;
        int[] solution = solution(n, left, right);
        for (int i : solution) {
            System.out.println("i = " + i);
        }


    }

    public static int[] solution(int n, long left, long right)
    {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();


        for (long i = left; i <= right; i++) {
            list.add((int)Math.max(i / n, i % n) + 1);
        }

        answer = new int[list.size()];
        int i= 0 ;
        for (int aInt : list) {
            answer[i++] = aInt;
        }

        return answer;
    }
}

