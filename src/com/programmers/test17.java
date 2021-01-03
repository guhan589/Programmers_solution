package com.programmers;
/*가장 큰 정사각형 찾기*/
public class test17 {
    public static void main(String[] args){

        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        //int[][] board = {{0,0,1,1},{1,1,1,1}};

        int result = solution(board);
        System.out.println("result===>"+result);

    }

    public static int solution(int [][]board)
    {
        int answer = 0;

        int[][] arr = new int[board.length+1][board[0].length+1];

        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j <board[0].length ; j++) {
                if(board[i][j]==1)
                    arr[i+1][j+1] = 1;
                else
                    arr[i+1][j+1] = 0;
            }

        }

        for(int i = 1; i < arr.length; i++){//행
            for(int j = 1 ; j<arr[i].length;j++){//열
                if(arr[i][j]==1) {
                    int temp1 = Math.min(arr[i][j - 1], arr[i - 1][j]);
                    temp1 = Math.min(temp1, arr[i - 1][j - 1]);
                    arr[i][j] = temp1 + 1;

                    answer = Math.max(answer, arr[i][j]);
                }
            }

        }

        return answer*answer;
    }
}
