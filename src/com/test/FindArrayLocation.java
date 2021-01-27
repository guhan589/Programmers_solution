package com.test;

public class FindArrayLocation {
    public static void main(String[] args) {
        int m = 6, n = 7, k = 12;
        int[][] arr = new int[m][n];
        int[][] allocateArray = makeArray(m, n, arr);
        for (int i = 0; i < m; i++) {//열
            for (int j = 0; j < n; j++) {//행
                System.out.print(allocateArray[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //m: 6 by n: 7
    static int[][] makeArray(int m, int n, int[][] arr) {
        int[][] array = arr;
        int num = 1;
        int i = 0;

        for (i = 0; i < n; i++) {//열
            for (int j = i; j < m; j++) {//행
                if(j == m){

                }
                if(array[j][i]==0){
                    array[j][i] = num++;
                }else
                    continue;
            }
        }

        return array;
    }


}
