package com.programmers.level3;

public class Misbehave {

    /**
     * 난이도 3
     * 문제명: 불량사용자
     * */
    public static void main(String[] args) {

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};
        int solution = solution(user_id, banned_id);
        System.out.println("solution = " + solution);

    }
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        for (String s : banned_id) {
            String temp = s.replaceAll("[*]", "");

            System.out.println("temp = " + temp);
        }

        return answer;
    }
}
