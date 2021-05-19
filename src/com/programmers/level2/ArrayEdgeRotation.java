package com.programmers.level2;

/**
 * 행렬 테두리 회전하기
 * */
public class ArrayEdgeRotation {
    static int[][] arr;
    static boolean type = true;
    static int x1, x2, y1, y2;
    static int temp;
    public static void main(String[] args) {

        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] solution = solution(rows, columns, queries);

    }
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        arr = makeArray(rows, columns);

        for (int i = 0; i < queries.length - 1; i++) {
            x1 = queries[i][0] - 1;
            y1 = queries[i][1] - 1;
            x2 = queries[i][2] - 1;
            y2 = queries[i][3] - 1;
            temp = arr[x1][y1];
            moveArray(x1, y1, x2, y2);
        }



        return answer;
    }

    static void moveArray(int sR, int sC, int eR, int eC) {
        //첫 시작 type = true
//        System.out.print("sR = " + sR + " ");
//        System.out.print("sC = " + sC + " ");
//        System.out.print("eR = " + eR + " ");
//        System.out.print("eC = " + eC + " ");
//        System.out.println("type = " + type);
//        System.out.println();

        if (sR == eR && sC == eC)
            type = false;
        //2,2,5,4
        if (type) { //정방향
            if (sR < x2 && sC < y2) { //시작 점에서 오른쪽 끝으로 이동
//                System.out.println("right");
//                System.out.println(arr[sR][++sC]);
                changeValue(false, sR, ++sC, sR, sC+1);
                moveArray(sR, sC, eR, eC);
            } else if (sR < x2 && sC == y2) {//오른쪽 맨 끝 열에서 아래로 이동
//                System.out.println("down");
//                System.out.println(arr[++sR][sC]);
                changeValue(false, ++sR, sC, eR+1, eC);
                moveArray(sR, sC, eR, eC);
            }
        } else {//역방향
            if (sR == x2 && sC > y1) { //마지막 행열에서 왼쪽으로 이동
//                System.out.println("left");
//                System.out.println(arr[sR][--sC]);
                changeValue(false, sR, --sC, eR, eC-1);
                moveArray(sR, sC, eR, eC);
            } else if (x1 < sR && sC == y1) {//하단에서 상단으로 이동
//                System.out.println("up");
//                System.out.println("sR = " + sR);
//                System.out.println("sC = " + sC);
//
//                System.out.println(arr[--sR][sC]);
//                System.out.println(" =========== ");
                changeValue(false, --sR, sC, sR-1, eC);
                moveArray(sR, sC, eR, eC);
            }
        }


    }

    static void changeValue(boolean type, int x1, int y1, int x2, int y2) {
        if(type)
            arr[x1][y1] = temp;
        else
            arr[x2][y2] = arr[x1][y1];
    }
    static int[][] moveArray(int[][] arr, int sR, int sC, int eR, int eC) {
        /**
         * sR:행 시작위치
         * sC:열 시작위치
         * eS:행 끝나는 위치
         * eC:열 끝나는 위치
         * */
        //2,2,5,4
        //1,1 1,2 1,3
        //2,1     2,3
        //3,1     3,3
        //4,1 4,2 4,3
        int[][] array = arr;
        int i = --sR;

        for (; i < eR; i++) {
            for (int j = sC-1; j < eC; j++) {

            }
            System.out.println();

        }
        return arr;
    }


    static int[][] makeArray(int rows, int columns) {
        int number = 1;
        int[][] arr = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = number++;
            }
        }
        return arr;
    }
    
}
