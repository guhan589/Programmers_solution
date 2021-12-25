package com.programmers.level1;

public class AliquotCountPlus {
/*약수의 개수의 덧셈*/
    public static void main(String[] args) {
//        int left = 13, right =17;
        int left = 24, right = 27;

        int solution = solution(left, right);
        System.out.println("solution = " + solution);
    }

    public static int solution(int left, int rigiht) {
        int answer = 0;
        int cnt = 0 ;
        for (int i = left; i < rigiht + 1; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }

            if (cnt % 2 == 0) {//짝수
                answer += i;
            } else {//홀수
                answer -= i;
            }
            cnt = 0;
        }
        return answer;
    }
}
