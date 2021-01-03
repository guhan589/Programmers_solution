package com.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class Mocktest {
    /**
     * 모의고사 문제
     * */

    public static void main(String[] args){
        int[] answers1 = {1,2,3,4,5};
        int[] answers2 = {1,3,2,4,2};
        int[] result = solution(answers2);
        for (int i : result)
            System.out.print(i);
    }
    public static int[] solution(int [] answers){
        int[] answer = {};
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int result1 = 0, result2 = 0, result3 = 0;//각 인원이 맞은 개수
        ArrayList<Integer> list = new ArrayList<>();


        int i ;
        for(i = 0; i < answers.length;i++){
            if(num1[i%num1.length] == answers[i]) result1++;
            if(num2[i%num2.length] == answers[i]) result2++;
            if(num3[i%num3.length] == answers[i]) result3++;
        }
        int max = Math.max(Math.max(result1,result2),result3); //최대값 뽑기
        if(max == result1) list.add(1);
        if(max == result2) list.add(2);
        if(max == result3) list.add(3);

        answer = new int[list.size()];
        i=0;
        for(int index : list)
            answer[i++] = index;

        return answer;
    }
}
