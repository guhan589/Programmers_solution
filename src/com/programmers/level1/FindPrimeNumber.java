package com.programmers.level1;

public class FindPrimeNumber {
    /**
     * level: 1
     * 문제명: 소수찾기 */


    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {1, 2, 7, 6, 4};
        int solution = solution(nums);
        System.out.println("solution = " + solution);
    }

    static public int solution(int[] nums) {
        int answer = 0;
//        nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
//        nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.

        //3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if(isPrime(num))
                        answer++;

                }
            }
        }
        return answer;
    }

    static boolean isPrime(int num) {

        try {
            for (int i = 2; i < num; i++) { // 1과 자기자신을 제외한 나머지 값에 나누어지면 소수X
                if (num % i == 0) {
                    return false;
                }
            }
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("isPrime 연산 Error");

        }

        return true;
    }
}
