package com.programmers.level2;

public class ArrayEdgeRotation2 {

    /**
     * 배열 틀 회전하기 완성(level2)
     * */
    enum status {
        LEFT,RIGHT,DOWN, UP,
    }


    static int x1, x2,tempX, tempY, y1, y2;
    static int[] result;
    static int index = 0;
    public static void main(String[] args) {

        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

        int[] solution = solution(rows, columns, queries);

    }
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = makeArray(rows, columns);
        result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            tempX = x1 = queries[i][0] - 1;
            tempY = y1 = queries[i][1] - 1;
            x2 = queries[i][2] - 1;
            y2 = queries[i][3] - 1;
            int temp = 0;

            temp = arr[x1][y1];
            arr = moveArray(status.RIGHT, arr, temp, temp);

//            showArray(arr);
        }


        return result;
    }


    static int[][] moveArray(status e, int[][] arr, int temp, int min) {
        int[][] answer = {};
        int tempValue;

        switch (e) {
            case RIGHT:

                if (y1 == y2) {//끝에 도달할 경우 down으로 이동
                    moveArray(status.DOWN, arr, temp, min);
                } else {
                    tempValue = arr[x1][++y1];
                    arr[x1][y1] = temp;
                    moveArray(status.RIGHT, arr, tempValue,getMinValue(min,tempValue));
                }
                break;

            case LEFT:
                if (y1 == tempY) {//맨 첫 열에 도달한 경우
                    moveArray(status.UP, arr, temp, min);
                } else {
                    tempValue = arr[x1][--y1];
                    arr[x1][y1] = temp;
                    moveArray(status.LEFT, arr, tempValue,getMinValue(min,tempValue));
                }
                break;


            case DOWN:
                if (x1 == x2) {//마지막 행에 도달할 경우
                    moveArray(status.LEFT, arr, temp,min);
                } else {
                    tempValue = arr[++x1][y1];
                    arr[x1][y1] = temp;
                    moveArray(status.DOWN, arr, tempValue, getMinValue(min, tempValue));
                }
                break;


            case UP:
                if (tempX == x1) {
                    result[index++] = min;
                    return arr;
                } else {
                    tempValue = arr[--x1][y1];
                    arr[x1][y1] = temp;
                    moveArray(status.UP, arr, tempValue, getMinValue(min, tempValue));
                }
                break;

        }
        return arr;
    }
    static int getMinValue(int num1, int num2) {
        return Math.min(num1, num2);
    }
//    static void showArray(int[][] arr) {
//
//        for (int[] ints : arr) {
//            for (int anInt : ints) {
//                System.out.print(anInt+"  ");
//            }
//            System.out.println();
//        }
//    }
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
