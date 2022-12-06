package com.programmers.level1;

public class Weapon {

    public static void main(String[] args) {
        int number = 5, limit = 3, power = 2;
        int solution = solution(number, limit, power);
        System.out.println("solution = " + solution);
    }
    public static int solution(int number, int limit, int power) {
        int answer = 0;

        answer = 2;

        for (int i = 2; i <= number; i++) {
            calDiv(i)
        }
        return answer;
    }

    public static int calDiv(int num) {
        int agx = 0;
        int answer = 0;
        if (num % 2 == 0) {//짝수
            agx = num / 2;
            if (agx == 1)
                return 0;

        }else{
            if (num / 3 == 0) {
                agx = num / 3;
            }else
                return 1;
        }
        for (int i = 2; i <= agx; i++) {

        }
        return 0;
    }


}
