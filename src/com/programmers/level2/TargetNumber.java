package com.programmers.level2;

public class TargetNumber {
    
    /**
     * 타겟변환 level2 (완성)
     * */
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int result = solution(numbers, target);
        System.out.println("result =>" + result);

    }
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = bfs(numbers, target, numbers[0], 1) + bfs(numbers, target, -numbers[0], 1);

        return answer;
    }

    public static int bfs(int[] numbers, int target, int sum, int i) {

        System.out.println("numbers: " + numbers + ", target:" + target + " sum:" + sum + " i:" + i);
        if(i == numbers.length) {
            if(sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int result = 0;
        result += bfs(numbers, target, sum+numbers[i], i+1);
        result += bfs(numbers, target, sum-numbers[i], i+1);
        return result;
    }
}
