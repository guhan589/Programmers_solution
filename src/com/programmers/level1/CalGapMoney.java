package com.programmers.level1;

public class CalGapMoney {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        long solution = solution(price, money, count);
        System.out.println("solution = " + solution);

    }

    public static long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += price*i;
        }
        long gap = sum-money;
        if(gap<=0)
            return 0;
        else
            return gap;

    }


}
