package com.programmers.level2;

public class NumberBlock {

    /**
     * 문제명: 숫자블록
     * 난이도: level2
     * */
    public static void main(String[] args) {
        long begin = 1, end = 10;
        int[] solution = solution(begin, end);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
    public static int[] solution(long begin, long end) {
        int[] answer = {};
        answer = new int[(int) ((end-begin)+1)];

        for (long i = begin; i <= end; i++) {
           /* System.out.print("i = " + i);
            System.out.print("  i/2 = " + i / 2);
            System.out.println("  i%2 = " + i % 2);*/
            if((i / 2) > 1 && i % 2 ==0){ //짝수로 나누어 떨어질 경우
                answer[(int) i -1] = (int)i / 2;
//                System.out.println("i1 = " + i);
            }else if((i / 3 > 1) && (i % 3 ==0)){
                answer[(int) i -1] = (int)i / 3;
//                System.out.println("i2 = " + i);
            }else{
                if(i == 1)
                    answer[(int) i -1] = 0;
                else
                    answer[(int) i -1] = 1;
            }

        }

        return answer;
    }
}
