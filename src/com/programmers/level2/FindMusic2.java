package com.programmers.level2;

import java.util.ArrayList;
import java.util.List;


/**
 * 방금그곡 level2 (미완성)
 * */
public class FindMusic2 {
    public static String[] upperbasic = {"C#", "D#", "E#", "F#", "G#", "A#"};
    public static String[] lowerbasic = {"c", "d", "e", "f", "g", "a"};

    public static void main(String[] args) {

        /**
         * 테스트케이스 1
         * */
        /*String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};*/
        /**
         * 테스트케이스 2
         * */
        String m = "CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        /**
         * 테스트케이스 3
         * */
        /*String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};*/

        String solution = solution(m, musicinfos);
        System.out.println("solution = " + solution);


        /**
         * 해결할 점
         *
         * 반올림 문자를 lowerCase 메소드를 통해서 변환하였고 그 반대로 변환하는 과정을 가져야함x
         * **/
    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int i, j;

        /*System.out.println("m = " + m);*/
        m = removeChores(m);
        /*System.out.println("m 변경후= " + m);
        System.out.println("musicinfos = " + musicinfos[0]);
        System.out.println("musicinfos = " + musicinfos[1]);*/

        
        
        for (i = 0; i < musicinfos.length; i++) {
            System.out.println("=========start"+i+"============");
            System.out.println("m = " + m);
            String[] split = musicinfos[i].split(",");

            int runningtime = getConvertTime(split[0], split[1]); //실제 실행시간
            String removeChores = removeChores(split[3]);// 반올림 코드삭제

            if (runningtime < removeChores.length())
                continue;
            else{
                split[3] = setChores(removeChores, runningtime); //가사길이가 재생시간에 맞게 수정
                System.out.println("split = " + split[3]);
                System.out.println("split = " + split[3].length()); 
                
                
            }




            System.out.println("=========end"+i+"============\n\n");
        }

        return answer;
    }

    static String removeChores(String chores) {
        //가사에 포함되는 올림표를 모두 삭제
        String temp = chores;
        for (int i = 0; i < upperbasic.length; i++) {
            temp = temp.replaceAll(upperbasic[i], lowerbasic[i]);//올림표 치환
        }

        return temp.toLowerCase();
        //변환한 가사를 소문자로 치환하여 반환
    }

    static String setChores(String chores, int time) {
        StringBuilder builder = new StringBuilder();

        int argx = time / chores.length();
        int temp = time % chores.length();


        if (argx > 0)
            for (int i = 0; i < argx; i++)
                builder.append(chores);

        builder.append(chores.substring(0, temp));

        return builder.toString();
    }

    static String setChores(String chores, int len, int time) {

        //재셍시간에 맞게 가사의 길이를 변환
        StringBuilder builder = new StringBuilder();

        int argx = time / len; //몫

        int temp = time % len; //나머지

        System.out.println("argx = " + argx);
        System.out.println("temp = " + temp);
        if (argx > 0) {
            for (int i = 0; i < argx; i++) {
                builder.append(chores);
            }
            builder.append(chores.substring(0, temp));//남은 시간 초에 해당하는 가사를 덧붙임
        } else {
            builder.append(chores);
            for (int i = 0; i < temp; i++) {
                if (chores.charAt(i) == '#') {
                    builder.append("#");
                    ++temp;
                } else {
                    builder.append(chores.charAt(i));
                }
            }

        }

        System.out.println("builder.toString() = " + builder.toString());
        System.out.println("builder.toString().length() = " + builder.toString().length());

        return builder.toString();
    }
    static int getConvertTime(String start, String end) {
        //종료 시간 - 시작 시간 을 게산하는 메소드
        int answer = 0;
        String[] start_split = start.split(":");
        String[] end_split = end.split(":");

        int hour = Integer.parseInt(end_split[0]) - Integer.parseInt(start_split[0]);
        int min = Integer.parseInt(end_split[1]) - Integer.parseInt(start_split[1]);

        return hour * 60 + min;

    }

}
