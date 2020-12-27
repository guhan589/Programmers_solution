package com.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class select_twoValue_pluse {
    /**
     * 두개 뽑아서 더하기
     * */
    public static void main(String[] args) {
        int[] number = {2,1,3,4,1};
        int[] result = solution(number);
        for(int num : result)
            System.out.println(num);
    }
    public static int[] solution(int[] numbers) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();


        for(int i = 0; i< numbers.length-1;i++){
            for(int j = i+1; j< numbers.length; j++){
                int temp = numbers[i] + numbers[j];
                if(list.indexOf(temp)<0)
                    list.add(temp);

            }
            //list.remove(i);
        }
        //Arrays.sort(list); // 오름차순 정렬

        answer = new int[list.size()];
        int i = 0;
        for (int num : list){
            answer[i++] = num;
        }

        Arrays.sort(answer);
        return answer;
    }
}
