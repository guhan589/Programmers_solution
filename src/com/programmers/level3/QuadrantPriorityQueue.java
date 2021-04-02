package com.programmers.level3;



import java.util.*;


/**
 * 이중우선순위 큐 level3 (완성)
 * */
public class QuadrantPriorityQueue {
    public static void main(String[] args) {
//        String[] opertation = {"I 16", "D 1"};
//        String[] opertation = {"I 7","I 5","I -5","D -1"};
        String[] opertation = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};  //result [0,0]
//        String[] opertation = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};  //result [333,-45]
        int[] solution = solution(opertation);
        for (int i : solution) {
            System.out.println("i = " + i);
        }

    }

    static int[] solution(String[] operations) {
        int[] answer = new int[2];


        /**
         * operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
         * operations의 원소는 큐가 수행할 연산을 나타냅니다.
         * 원소는 “명령어 데이터” 형식으로 주어집니다.
         * - 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
         * 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
         * */

        Queue<Integer> maxqueue = new PriorityQueue<>(Collections.reverseOrder()); //내림차순정렬
        Queue<Integer> minqueue = new PriorityQueue<>();
        int ntemp;
        for (String operation : operations) {
            String[] split = operation.split(" ");
            int num = Integer.parseInt(split[1]);
            if (split[0].equals("I")) {
                maxqueue.add(num);
                minqueue.add(num);
            } else {
                if (num == 1 && !maxqueue.isEmpty()) { //최댓값 삭제
                    ntemp = maxqueue.poll();
                    deleteEelement(minqueue,ntemp);
                } else if (num == -1 && !minqueue.isEmpty()) {//최솟값삭제
                    ntemp = minqueue.poll();
                    deleteEelement(maxqueue, ntemp);
                }
            }

        }
  /*      for (Integer integer : minqueue) {
            System.out.println("minqueue = " + integer);
        }
        for (Integer integer : maxqueue) {
            System.out.println("maxqueue = " + integer);
        }*/

        if(!maxqueue.isEmpty())
            answer[0] = maxqueue.poll();

        if(!maxqueue.isEmpty())
            answer[1] = minqueue.poll();


        return answer;
     }

    static void deleteEelement(Queue<Integer> queue, int number) {
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (temp == number)
                break;
            else
                list.add(temp);
        }
        queue.addAll(list);
    }

}
