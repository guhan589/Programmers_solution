package com.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class PairArray {
    public static void main(String[] args) {

        String[][] board = {{"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}};
        int h = 1, w = 1;

        int solution = solution(board, h, w);

        System.out.println("solution = " + solution);
    }

    public static int solution(String[][] board, int w, int h) {
        int answer = 0, tempX = 0, tempY = 0;
        int n = board.length;

        String mainColor = board[w][h];//메인컬러
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};


        for (int[] direction : directions) {
            tempX = w - direction[0];
            tempY = h - direction[1];


            if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n) {
                if(mainColor.equals(board[tempX][tempY])) {
                    answer++;
                }
            }

        }



        return answer;
    }


}
