package com.programmers.level1;


public class DartGame {
    public static void main(String[] args) {
        String dartResult = "1S2D*3T";
        int solution = solution(dartResult);
        System.out.println("solution = " + solution);

    }
    static int solution(String dartResult) {
        int answer = 0;
        char[] ch = dartResult.toCharArray();

        /*System.out.println("(int)'#' = " + (int)'#');
        System.out.println("(int)'#' = " + (int)'#');*/

        /**
         * (제약조건)
         * 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
         * 아차상(#) 당첨 시 해당 점수는 마이너스된다.
         *
         * */
        int number = 0;

        for (int i = 0; i < ch.length; i++) {
            int num = (int) ch[i];
            if (num >= 0 && num <= 9) {
                number = num;
            } else if (num == 35) {

            } else {
                int value = mulitValue(number, ch[i]);
            }
        }
        return answer;
    }

    static int mulitValue(int num, char ch) {
        int answer = 0;

        return answer;
    }
}
