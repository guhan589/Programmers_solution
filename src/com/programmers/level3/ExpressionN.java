package com.programmers.level3;

public class ExpressionN {

    /**
     * N으로 표현 level3 (완성)
     */

    private static int limit = 8;
    private static int target;
    private static int n;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        int result = solution(N, number);
        System.out.println("result ==>" + result);
    }

    public static int solution(int N, int number) {
        n = N; //5
        target = number;// 12

        dfs(0, 0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    static void dfs(int count, int prevision) {
        if (count > 8) {
            answer = -1;
            return;
        }

        if (prevision == target) {//원하던 값이랑 맞을 경우 횟수 반환
            answer = Math.min(count, answer);
            return;
        }

        int temp_N = n;
        for (int i = 0; i < limit - count; i++) {
            int temp_count = count + i + 1;
            dfs(temp_count, prevision - temp_N);
            dfs(temp_count, prevision + temp_N);
            dfs(temp_count, prevision * temp_N);
            dfs(temp_count, prevision / temp_N);

            temp_N = temp_N * 10 + n;
        }

    }
}
