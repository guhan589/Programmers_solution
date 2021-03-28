package com.programmers.level3;

public class GotoSchool {

    /**
     * 등굣길 level3 (완성)
     *
     * */
    private static Long value = 1000000007L;
    public static void main(String[] args) {


        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        int result = solution(m, n, puddles);
        System.out.println("result = " + result);


    }

    //1,000,000,007 % : return result
    static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] visitstate = new int[n + 1][m + 1];

        //우물이 있는 곳을 -1로 초기화
        for (int[] ints : puddles)
            visitstate[ints[1]][ints[0]] = -1;



        visitstate[1][1] = 1; //시작위치 초기화

        for (int i = 1; i < visitstate.length; i++) {
            for (int j = 1; j < visitstate[i].length; j++) {
                if(visitstate[i][j] == -1)
                    visitstate[i][j] = 0;
                else{
                    if (i == 1)
                        visitstate[i][j] += visitstate[i][j - 1];
                    else
                        visitstate[i][j] = (visitstate[i - 1][j] + visitstate[i][j - 1]) %1000000007;

                }
                if (j == visitstate[i].length - 1) {
                    answer = visitstate[i][j];
                }
            }


        }






        /*for (int[] ints : visitstate) {
            for (int anInt : ints) {
                System.out.print(anInt+"  ");
            }
            System.out.println("");
        }*/

        return answer;
    }
}
