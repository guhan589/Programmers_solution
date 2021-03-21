package com.championship;

import java.util.Arrays;

public class Socar1 {
    public static void main(String[] args) {
        String[] times = {"10:00 ~ 17:00", "14:00 ~ 20:00", "13:00 ~ 16:00"};

        String result = solution(times);

        //result = 14:00 ~ 16:00
    }

    static String solution(String[] times) {
        String answer = "-1";
        String front_hour = "0", front_min = "0";
        String back_hour = "0", back_min = "0";

        /**
         * map은 요소들을 특정조건에 해당하는 값으로 변환해 줍니다.
         * 요소들을 대,소문자 변형 등 의 작업을 하고 싶을떄 사용 가능 합니다.
         *
         * filter는 요소들을 조건에 따라 걸러내는 작업을 해줍니다.
         * 길이의 제한, 특정문자포함 등 의 작업을 하고 싶을때 사용 가능합니다.
         *
         * sorted는 요소들을 정렬해주는 작업을 해줍니다.
         * */


        String[] temp_split = times[0].split("~");
        back_hour = temp_split[1].replaceAll(" ", "").replaceAll(":", "").substring(0, 2);
        back_min = temp_split[1].replaceAll(" ", "").replaceAll(":", "").substring(2);

    for (String time : times) {
            String[] split = time.replaceAll(" ", "").replaceAll(":","").split("~");
            for (int i = 0; i < split.length; i++) {
                if (i % 2 == 0) {//front
                    if (Integer.parseInt(front_hour) < Integer.parseInt(split[i].substring(0, 2)))
                        front_hour = split[i].substring(0, 2);

                    if (Integer.parseInt(front_min) < Integer.parseInt(split[i].substring(1)))
                        front_min = split[i].substring(2);

                }else{//back(0
                    if (Integer.parseInt(back_hour) > Integer.parseInt(split[i].substring(0, 2)))
                        back_hour = split[i].substring(0, 2);

                    if (Integer.parseInt(back_min) > Integer.parseInt(split[i].substring(1)))
                        back_min = split[i].substring(2);
                }
            }
        }

        System.out.println("front_hour = " + front_hour + ":" + front_min);
        System.out.println("front_hour = " + back_hour + ":" + back_min);

//        for (int i = 0; i < times.length; i++) {
//            String[] split = times[1].split("~");
//
//        }
        return answer;
    }
//    static void modify()
}
