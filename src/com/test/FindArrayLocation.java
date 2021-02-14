package com.test;

public class FindArrayLocation {
    static int num = 1;
    static int m = 6;
    static int n = 7;
    public static void main(String[] args) {
        int m = 6, n = 7, k = 12;
        int[][] arr = new int[m][n];
        int[][] allocateArray = makeArray(m, n, arr);
        System.out.println("dasdsadad");
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

        reParsing(0, 0, array);

       /* for (i = 0; i < n; i++) {//열
            for (int j = i; j < m; j++) {//행

                if(array[j][i]==0){
                    array[j][i] = num++;
                }else
                    continue;
            }
        }*/

        return array;
    }

    static void reParsing(int i , int j, int[][] arr){
//m=6 n =7

        int x = i; //행의 값을 저장
        int y = j; //열의 값을 저장
        System.out.println("i = " + i + " j=" + j);
        System.out.println("x = " + x + " y=" + y + "\n\n");

        if(i<m){ //행

            if (arr[i][j] == 0) {
                System.out.println("1111111-1");
                arr[i++][j] = num++;
                reParsing(i, j, arr);
            }else{
                System.out.println("1111111-2");
                reParsing(x-1, ++j, arr);
            }

        }else{
            System.out.println("1111111-3");
            reParsing(x-1, ++j, arr);
        }

        if (j < n) { //열

            if (arr[i][j] == 0) {
                System.out.println("22222222-1");
                arr[i][j++] = num++;
                reParsing(i, j, arr);
            }else{
                System.out.println("22222222-2");
                reParsing(++i, y-1, arr);
            }
        }else{
            System.out.println("22222222-3");
            reParsing(++i, y-1, arr);
        }
    }


}
