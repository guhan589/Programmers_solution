package com.programmers.level2;

<<<<<<< HEAD
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;
=======
import java.util.*;
import java.util.stream.Collectors;

>>>>>>> e7800fac2ae2ed5429fbc0d81b95f1995166e3ef
public class ParkingFeeCalculation {

    public static void main(String[] args) {
/*        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};*/
        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        int[] solution = solution(fees, records);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
    public static int[] solution(int[] fees, String[] records)
    {
        int[] answer = {};
        List<Parking> list = new ArrayList<>();
        Map<String, Integer> timehistory = new HashMap<>();

        /*int[] fees = {180, 5000, 10, 600}; // 기본시간, 기본요금, 단위 시간, 단위요금
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};*/

        for (int i = 0; i < records.length; i++) {
            String[] split = records[i].split(" ");
            list.add(new Parking(split[0], split[1], split[2]));
        }
        Map<String, List<Parking>> collect = list.stream().collect(Collectors.groupingBy(Parking::getNumber));
        for (String s : collect.keySet()) {
            int size = collect.get(s).size();
            if (size % 2 == 1) { //입차만 있고 출차가 없는경우
                String number = collect.get(s).get(0).number;
                collect.get(s).add(new Parking("23:59", number, "OUT"));
            }
            int time = 0;
            for (int i = 0; i < size; i += 2) {
                time += converTime(collect.get(s).get(i + 1).time) - converTime(collect.get(s).get(i).time);
            }
            timehistory.put(s, time);

        }
        Object[] key = timehistory.keySet().toArray();
        Arrays.sort(key);
        System.out.println("key.length = " + key.length);
        answer = new int[key.length];
        for (int index = 0; index < key.length; index++) {
            answer[index] = calFee(fees, timehistory.get(key[index]));
        }








        return answer;
    }
    public static class Parking
    {
        String time, number, state;

        public Parking(String time, String number, String state) {
            this.time = time;
            this.number = number;
            this.state = state;
        }

        public String getTime() {
            return time;
        }

        public String getNumber() {
            return number;
        }

        public String getState() {
            return state;
        }


    }

    public static int calFee(int[] fees, int time)
    {
        /*int[] fees = {180, 5000, 10, 600}; // 기본시간, 기본요금, 단위 시간, 단위요금*/
        int fee = 0;
        int gap = 0;
        if(time < fees[0]){
            gap = 0;
        }else
            gap = time - fees[0];
        fee = 5000 + (int)Math.ceil((double)gap / fees[2]) * fees[3];
        return fee;
    }
    public static int converTime(String time)
    {
        int answer = 0;
        String[] split = time.split(":");
        answer = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]); // hh*60 + mm / return mm
        return answer;
    }


}
