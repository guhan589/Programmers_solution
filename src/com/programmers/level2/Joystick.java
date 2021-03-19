package com.programmers.level2;

public class Joystick {

    /**
     * 조이스틱 level2 완성성
    *
     * **/
    public static void main(String[] args) {
//        String name = "JEROEN";
        String name = "JAAZ";
        int result = solution(name);
        System.out.println("result = " + result);
    }

    public static int solution(String name) {
        int answer = 0;

        /**
         * 조이스틱을 움직여서 가질 수 있는 가장 큰 이동 값은, 차례로 움직여 name.length()까지 가는 것이다.
         * 그 값을 min이라고 초기화 해두고 int min_length = len-1;
         * 이 문제의 키포인트는 연속된 A의 등장에 따라 최소 움직임이 달라진다는 것이다!
         * 따라서 min_length와 비교해주어야 하는 값은,
         * 내 위치에서 첫위치로 돌아간 후 (i+i)
         * A가 연속으로 나오는 지점의 다음 (nextvalue)을 끝(len)에서 계산해 주는 것이다 -> len-next
         * 따라서 min(min_move, i+i+ (len-nextvalue));
         * */

        int min_length = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {//문자열 길이 만큼 반복문
            System.out.println("Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1) = " + Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1));
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            //문자의 최소 이동 거리

            System.out.println("answer = " + answer);
            int nextvalue = i + 1; //다음 문자 위치

            while (nextvalue < name.length() && name.charAt(nextvalue) == 'A')
                nextvalue++;
            min_length = Math.min(min_length, i + name.length() - nextvalue + i);
        }

        answer += min_length;
        return answer;
    }
}
