package com.programmers.level2;


import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 
 *프린터 level 2
 * */

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int result = solution(priorities, location);
        System.out.println("result ==> "+result);
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); //우선순위가 높은 int값 순서대로
        for(int i : priorities)
            queue.offer(i);


        while(!queue.isEmpty()){

            for(int i = 0 ; i < priorities.length;i++){
                if(queue.peek() == priorities[i]) { //정렬된 우선 순위큐 값들을 순서에 따라
                    //priorities 배열 값과 일치할 때 실행
                    queue.poll();// 첫번째 값 제거
                    answer++;//횟수증가

                    if(location == i)
                        return answer;

                }

            }

        }

        return answer;
    }
}
