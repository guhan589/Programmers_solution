package com.programmers.kstec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test6 {
    public static void main(String[] args) {
//        int[] prices = {3, 2, 4, 8, 7};
        int[] prices = {3, 4, 1, 5, 4};
//        int solution = solution(prices);
//        int solution2 = solution2(prices);
        int solution3 = solution3(prices);
//        System.out.println("solution2 = " + solution2);
//        System.out.println("solution = " + solution);
        System.out.println("solution3 = " + solution3);
    }
    public static int solution(int[] prices) {
        int answer = -1;
        int purchase;

//        Arrays.sort(prices);
        List<Integer> list = Arrays.stream(prices).boxed().collect(Collectors.toList());
        for (Integer integer : list) {
            System.out.println("integer = " + integer);
        }

        for (int i = 0; i < prices.length - 1; i++) {
            purchase = prices[i]; //물건 구매 가격

        }
        return answer;
    }
    public static int solution2(int[] prices) {
        int answer = -1;
        int price = -1; //최대 이익값
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) { // gap발생
                    int temp = prices[j] - prices[i]; //temp-> 금액차이
                    if (temp > price) {
                        price = temp;
                    }
                }
            }
        }

        return answer;
    }
    static int solution3(int[] prices) {
        int answer = -1;

        int min = prices[0];
        int gap = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                int temp_gap = prices[i] - min;
                if (temp_gap > gap) {
                    gap = prices[i] - min;
                    min = Math.min(min, prices[i]);
                }

            } else {
                min = prices[i];
            }
        }
        answer = gap;

        return answer;
    }
}
