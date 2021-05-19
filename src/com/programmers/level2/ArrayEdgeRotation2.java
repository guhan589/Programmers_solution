package com.programmers.level2;

public class ArrayEdgeRotation2 {
    enum status {
        LEFT,RIGHT,DOWN, UP,
    }

//    static int temp;
    static int gap_X, gap_Y;
    static int x1, x2,tempX, tempY, y1, y2;
    public static void main(String[] args) {

        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

        int[] solution = solution(rows, columns, queries);

    }
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        int[][] arr = makeArray(rows, columns);
//        showArray(arr);

        for (int i = 0; i < queries.length; i++) {
            tempX = x1 = queries[i][0] - 1;
            tempY = y1 = queries[i][1] - 1;
            x2 = queries[i][2] - 1;
            y2 = queries[i][3] - 1;
            int temp = 0;
            System.out.println("tempX = " + tempX);
            System.out.println("tempY = " + tempY);
            if(i==0)//temp 값 초기화
                 temp = arr[x1][y1];

//            gap_X = x2 - x1;
//            gap_Y = y2 - y1;
//            System.out.println("x1 = " + x1);
//            System.out.println("y1 = " + y1);
//            System.out.println("x2 = " + x2);
//            System.out.println("y2 = " + y2);
//            System.out.println("gap_X = " + gap_X);
//            System.out.println("gap_Y = " + gap_Y);
            System.out.println(" start  ");
            arr = moveArray(status.RIGHT, arr, temp);
            showArray(arr);
        }
        return answer;
    }

    static int[][] moveArray(status e, int[][] arr, int temp) {
        int[][] answer = {};
        int tmepValue;
        System.out.println("x1 = " + x1);
        System.out.println("y1 = " + y1);
        System.out.println("x2 = " + x2);
        System.out.println("y2 = " + y2);
        System.out.println("temp = " + temp);
        System.out.println("==============");
        switch (e) {
            case RIGHT:
                if (y1 == y2) {//끝에 도달할 경우 down으로 이동
                    tmepValue = arr[x1][y1];
                    moveArray(status.DOWN, arr, tmepValue);
                } else {
                    tmepValue = arr[x1][++y1];
                    arr[x1][y1] = temp;
                    moveArray(status.RIGHT, arr, tmepValue);
                }
                break;
                
            case LEFT:
                if (y1 == tempY) {//맨 첫 열에 도달한 경우
                    System.out.println("왼쪽 도달");
                    tmepValue = arr[x1][y1];
                    moveArray(status.UP, arr, tmepValue);
                } else {
                    tmepValue = arr[x1][--y1];
                    arr[x1][y1] = temp;
                    moveArray(status.LEFT, arr, tmepValue);
                }
                break;


            case DOWN:
                if (x1 == x2) {//마지막 행에 도달할 경우
                    tmepValue = arr[x1][y1];
                    moveArray(status.LEFT, arr, tmepValue);
                } else {
                    tmepValue = arr[++x1][y1];
                    arr[x1][y1] = temp;
                    moveArray(status.DOWN, arr, tmepValue);
                }
                break;


            case UP:
                if (tempX == x1) {
                    return arr;
                } else {
                    tmepValue = arr[--x1][y1];
                    arr[x1][y1] = temp;
                    moveArray(status.UP, arr, tmepValue);
                }
                break;

        }
        return arr;
    }

    static void showArray(int[][] arr) {

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+"  ");
            }
            System.out.println();
        }
    }
    static int[][] makeArray(int rows, int columns){ //배열 생성
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
