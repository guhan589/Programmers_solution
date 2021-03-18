package com.programmers.level2;


/**
 * 방금그곡 level2 미완성
 * */
public class FindMusic {
    public static String[] basic = {"C#", "D#", "E#", "F#", "G#", "A#"};
    public static String[] convert = {"c", "d", "e", "f", "g", "a"};
    public static void main(String[] args) {

        String m = "CDEFGABCDEFGAB";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String result = solution(m,musicinfos);
    }
    static String solution(String m, String[] musicinfos){
        String answer = "";
        String temp_m = changeContext(m);

        String[][] info = array(musicinfos);
        return answer;
    }
    public static String changeContext(String m){
        String answer = m;
        for(int i = 0 ;i< basic.length;i++){
            answer = m.replaceAll(basic[i], convert[i]);
        }
        return answer;
    }
    static String[][] array(String[] s){
        String[][] result = new String[s.length][3];
        for(int i = 0; i< s.length;i++){
            String[] detail = s[i].split(",");

            String[] start = detail[0].split(":");
            String[] end = detail[1].split(":");
            String title = detail[2];
            String infor = detail[3];
            int time = changTime(start, end); //시간 출력


            for(int j = 0; j<time;j++){

            }
        }

        return result;
    }
    static int changTime(String[] start , String[] end){

        int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
        int min = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);

        return hour * 60 + min;
    }

}
