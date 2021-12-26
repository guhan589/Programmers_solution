package com.programmers.level1;

public class SoundPlus {
    public static void main(String[] args) {
        /*int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};*/
        int[] absolutes = {1, 2, 3};
        boolean[] signs = {false, false, true};
        int solution = solution(absolutes, signs);
        System.out.println("solution = " + solution);

    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {

            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}
