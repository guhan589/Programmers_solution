package com.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test4 {
    public static void main(String[] args){

        int bridge_length =2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        int result = solution(bridge_length,weight,truck_weights);
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayList<Integer> list =new ArrayList<>();
        int weight_sum = 0;
        int i = 0 ;
        Queue queue = new LinkedList();


        for(i = 0; i< truck_weights.length;i++)
            list.add(truck_weights[i]);



        while(!list.isEmpty()){
            weight_sum += list.get(i);
            list.remove(i);
            i++;

            for(int j = 0 ; j < bridge_length; j++){ // 0~1
                int temp = weight_sum + list.get(i);
                if(weight_sum > weight || temp > weight) //다리가 버틸 수 있는 무게를 초과할때
                    continue;
                else{
                    weight_sum += list.get(i);

                }

            }

        }

        return answer;
    }
}
