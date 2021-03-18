package com.programmers.level2;

import java.util.ArrayList;
import java.util.List;


/**
 * 방금그곡 level2 (미완성)
 * */
public class FindMusic3 {
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
        /*String m = "CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};*/

        /**
         * 테스트케이스 3
         * */
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String solution = solution(m, musicinfos);
        System.out.println("solution = " + solution);


        /**
         * 해결할 점
         *
         * 반올림 문자를 lowerCase 메소드를 통해서 변환하였고 그 반대로 변환하는 과정을 가져야함x
         * **/
    }

    public static String solution(String m, String[] musicinfos) {
        StringBuilder builder = new StringBuilder();
        String answer = "(None)";
        int i, j;

        String argx = removeChores(m).toLowerCase();//주어진 가사를 소문자로 변환
        List<Integer> mlist = getLocation(m);
        for (Integer integer : mlist) {
            System.out.println("mlist = " + integer);
        }
        for (i = 0; i < musicinfos.length; i++) {
            String[] split = musicinfos[i].split(","); // 각 일차원 배열에 값을 ,을 기준으로 split함
            System.out.println("시작시각 = " + split[0]);
            System.out.println("끝난시각 = " + split[1]);


            // split ==> "12:00,12:14,HELLO,CDEFGAB"
            //0: 시작 시각, 1: 끝난 시각, 2 : 음악명, 3: 음악 가사


            int time = getConvertTime(split[0], split[1]);
            //종료시간 - 시작시간 = time


            int len = split[3].replaceAll("#", "").length();

            System.out.println("len = " + len);
            System.out.println("split[3]==>" + split[3]);
            if (len < time) {
                //가사의 길이가 재생시간보다 짧으면 converChroes 함수를 호출하여 재생시간에 맞게 가사 생성
                split[3] = setChores(split[3], len, time);

            }else{
                builder.setLength(0);//초기화
                for (j = 0; j < time; j++) {
                    if (split[3].charAt(j) == '#') {
                        builder.append("#");
                        ++time;
                    }else
                        builder.append(split[3].charAt(j));
                }
                if (split[3].charAt(j)=='#') {
                    builder.append("#");
                }

//              split[3] = split[3].substring(0, time);

                split[3] = builder.toString();
            }



            List<Integer> templist = getLocation(split[3]);
            //#위치값
            for (Integer integer : templist) {
                System.out.println("templist = " + integer);
            }


            split[3] = removeChores(split[3]); //가사 변환

            System.out.println("argx = " + argx);//주어진 가사(m)
            System.out.println("음악가사 변경 전 = " + musicinfos[i]);
            System.out.println("음악가사 변경 후 = " + split[3]);
            System.out.println("음악가사 길이 = " + split[3].length());

            System.out.println("\n\n=============시작 "+ i+"================");

            System.out.println("argx = " + argx);
            System.out.println("split[3] = " + split[3]);
            System.out.println("mlist.size() = " + mlist.size());
            System.out.println("templist.size() = " + templist.size());

            System.out.println("=============끝================\n\n");
            if (split[3].contains(argx) && templist.size() >= mlist.size()) {
                boolean state = true;

                for (int index = 0; index < templist.size(); index++) {
                    if (mlist.contains(templist.get(i))) {
                        state = true;
                    } else {
                        state = false;
                        break;
                    }
                }
                if(state)
                    return split[2];

            }
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

    static List<Integer> getLocation(String chores) { // 반올림표 위치 찾기
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chores.length(); i++) {
            if (chores.charAt(i) == '#') {
                list.add(i - 1);
            }
        }
        return list;
    }

    static String convertChore(String chores, List<Integer> list,int len) {

        // 반올림 가사로 변롼
        String answer = "";



        return answer;
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
//            builder.append(chores).append(chores.substring(0, temp));
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
