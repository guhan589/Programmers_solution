package com.programmers.level1;

import java.util.ArrayList;

public class LottoLevel {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] solution = solution(lottos, win_nums);
        for (int i : solution) {
            System.out.println("i = " + i);
        }

    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2]; // 최저 level, 최고 level
        int zero_cnt = 0;
        int cnt = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero_cnt ++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    cnt++;
                    break;
                }
            }

        }

        cnt += zero_cnt;
        switch (cnt) {
            case 6:
                answer[0] = 1;
                answer[1] = 1 + zero_cnt;
                break;
            case 5:
                answer[0] = 2;
                answer[1] = 2 + zero_cnt;
                break;
            case 4:
                answer[0] = 3;
                answer[1] = 3 + zero_cnt;
                break;
            case 3:
                answer[0] = 4;
                answer[1] = 4+ zero_cnt;
                break;
            case 2:
                answer[0] = 5;
                answer[1] = 5 + zero_cnt;
                break;
            default:
                answer[0] = 6;
                answer[1] = 6 + zero_cnt;
                break;
        }

        if(answer[1] >6)
            answer[1] = 6;
        return answer;

    }
}
