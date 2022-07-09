package com.programmers.level2;

public class FindSosuInK {

    public static void main(String[] args){
        int n = 437674;
        int k = 3;
        /*int n = 110011;
        int k = 10;*/


        int solution = solution(n, k);
        System.out.println("solution = " + solution);

    }

    public static int solution(int n, int k) {
        int answer = -1;

        String cal = cal(n, k);
        System.out.println("cal = " + cal);
        return answer;
    }

    public static String cal(int n, int k) {
        String answer = "";
        while ((n / k) != 0) {
            answer = String.valueOf(n % k) + answer;
            n = n / k;
        }
        return answer;
    }

}
