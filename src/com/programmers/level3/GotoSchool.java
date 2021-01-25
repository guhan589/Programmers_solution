package com.programmers.level3;

public class GotoSchool {
    private static Long value = 1000000007L;
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        Long result = solution(m, n, puddles);
        System.out.println("result = " + result);
    }

    //1,000,000,007 % : return result
    public static Long solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int [][] locaton = new int[n][m];

        for (int[] p : puddles)
            locaton[p[0]-1][p[1]-1] = -1; //물이 존재하는 지역


        locaton[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (locaton[i][j] == -1) {
                    locaton[i][j] = 0;
                    continue;
                }

                if (i != 0)
                    locaton[i][j] += locaton[i-1][j] % value;

                if (j != 0)
                    locaton[i][j] += locaton[i][j-1] % value;

            }

        }
        return locaton[n - 1][m - 1] % value;
    }

}
