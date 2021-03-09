package com.programmers.level2;


import java.util.ArrayList;

/**
 * Level 2 방문길이
 * 다시풀것
 * */
public class VisitLength {
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        int result = solution(dirs);
        System.out.println("result = " + result);

    }

    static int solution(String dirs) {
        int answer = 0;


        /*ArrayList<String> list = new ArrayList<>();
        list.add("dasdad");
        System.out.println("list.stream().findAny() = " + list.stream().findFirst());*/

        char[] ch = dirs.toCharArray();
        int x1 = 5, x2 = 5, y1 = 5, y2 = 5;

        for (char c : ch) {
            x1 = x2;
            y1 = y2;


            switch (c) {
                case 'L':

                    break;

                case 'R':


                    break;

                case 'U':


                    break;
                case 'D':


                    break;
            }
        }


        return answer;
    }
}
