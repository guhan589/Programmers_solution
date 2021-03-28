package com.programmers.level3;

public class Integertriangle {
    /**
     * 정수삼각형 level3 (완성)
     *
     * */
    public static void main(String[] args) {
        int[][] trigngle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int solution = solution(trigngle);
        System.out.println("solution = " + solution);

    }
    static int solution(int[][] triangle) {
        int answer = 0;
        int[][] arr = new int[triangle.length][triangle.length];
        arr[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) { //각 행의 첫과 끝 즉 시작점의 대각선에 위치한 값에 대한 합
            arr[i][0] = arr[i - 1][0] + triangle[i][0];
            arr[i][i] = arr[i - 1][i - 1] + triangle[i][i];
        }
/*
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.println("anInt = " + anInt);
            }
            System.out.println("==============");
        }
*/


        for (int i = 2; i < triangle.length; i++) {// 중간에 배열에 대한 값
            for (int j = 1; j < i; j++) {
                arr[i][j] = Math.max(arr[i - 1][j - 1], arr[i - 1][j]) + triangle[i][j];
            }
        }


        for (int i = 0; i < arr.length; i++) { // 최대값 뽑기
            answer = Math.max(answer, arr[arr.length - 1][i]);
        }



        return answer;
    }
}
