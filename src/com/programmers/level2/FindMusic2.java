package com.programmers.level2;

import java.util.ArrayList;


/**
 * 방금그곡 level2 (미완성)
 * */
public class FindMusic2 {
    public static String[] upperbasic = {"C#", "D#", "E#", "F#", "G#", "A#"};
    public static String[] lowerbasic = {"c", "d", "e", "f", "g", "a"};

    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String solution = solution(m, musicinfos);
        System.out.println("solution = " + solution);

    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        ArrayList<String> list = new ArrayList<>();

        /*String[] startInfo = musicinfos[0].split(",");
        String[] endInfo = musicinfos[1].split(",");*/


        for (int i = 0; i < musicinfos.length; i++) {
            String[] split = musicinfos[i].split(",");

            // split ==> "12:00,12:14,HELLO,CDEFGAB"
            //0: 시작 시각, 1: 끝난 시각, 2 : 음악명, 3: 음악 가사

            
            int time = convertTime(split[0], split[1]);
            System.out.println("time = " + time);
            split[3] = converChores(split[3]); //가사 변환

            if (split[3].length() < time) { //가사의 길이가 재생시간보다 짧으면 converChroes 함수를 호출하여 재생시간에 맞게 가사 생성
                split[3] = converChores(split[3], time);
            }
            
        }

        return answer;
    }

    static String converChores(String chores) { //가사에 포함되는 올림표를 모두 삭제
        String temp = chores;
        for (int i = 0; i < upperbasic.length; i++) {
            temp.replaceAll(upperbasic[i], lowerbasic[i]);
        }

        return temp;
    }
    
    
    static String converChores(String chores, int time) { //재셍시간에 맞게 가사의 길이를 변환
        StringBuilder builder = new StringBuilder();

        int argx = time / chores.length(); //몫
        int temp = time % chores.length(); //나머지
        System.out.println("argx = " + argx);
        System.out.println("temp = " + temp);
        if (argx > 0) {
            for (int i = 0; i < argx; i++) {
                builder.append(chores);
            }
            builder.append(chores.substring(0,temp));
        }else{
            builder.append(chores).append(chores.substring(0, temp));
        }

        System.out.println("builder = " + builder.toString());
        System.out.println("builder.toString().length() = " + builder.toString().length());

        return builder.toString();
    }
    static int convertTime(String start, String end) {
        int answer = 0;
        String[] start_split = start.split(":");
        String[] end_split = end.split(":");

        int hour = Integer.parseInt(end_split[0]) - Integer.parseInt(start_split[0]);
        int min = Integer.parseInt(end_split[1]) - Integer.parseInt(start_split[1]);

        return hour * 60 + min;

    }

}
