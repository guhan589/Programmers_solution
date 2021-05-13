package javastandard.kstec;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
        int[] prices = {3, 2, 4, 8, 7};
//        int[] prices = {1,1,1,1,1,1};
        int solution = solution(prices);
        System.out.println("solution = " + solution);

    }

    public static int solution(int[] prices) {

        /**
         * prices.length = n일
         * 최대이익 return
         * */
        int answer = 0;

//        Arrays.sort(prices);
        int max = prices[0];
        int min = prices[0];

        Arrays.parallelSort(prices);

        min = prices[0];
        max = prices[prices.length - 1];

        int gap = prices[prices.length - 1] - prices[0];
        if (gap > 0) {
            return gap;
        } else {
            return 0;


        }

    }
}
