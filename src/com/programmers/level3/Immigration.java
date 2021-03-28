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

//        int left = 1, min, right = Arrays.stream(times).max().getAsInt() * n;

        return answer;
    }

    class node{
        int left;
        int mid;
        int right;

        public node(int left, int mid, int right) {
            this.left = left;
            this.mid = mid;
            this.right = right;
        }

        public int getLeft() {

            return left;
        }

        public int getMid() {
            return mid;
        }

        public int getRight() {
            return right;
        }
    }
}
