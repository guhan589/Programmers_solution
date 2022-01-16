package com.programmers.level2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ParkingFeeCalculation {
        public static void main(String[] args) throws InterruptedException {
        int[] fees = {180, 5000, 10, 600}; // 기본시간, 기본요금, 단위 시간, 단위요금
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] solution = solution(fees, records);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
        Thread.sleep(1000);
    }
    public static int[] solution(int[] fees, String[] records)
    {
        int[] answer = {};
        Map<String, Integer> timehistory = new HashMap<>();
        Map<String, Integer> feehistory = new HashMap<>();

        /*int[] fees = {180, 5000, 10, 600}; // 기본시간, 기본요금, 단위 시간, 단위요금
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};*/
        for (int i = 0; i < records.length; i++) {
            String[] inner_split = records[i].split(" ");

        }

        return answer;
    }
    public static int converTime(String time)
    {
        int answer = 0;
        String[] split = time.split(":");
        answer = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]); // hh*60 + mm / return mm
        return answer;
    }


}
