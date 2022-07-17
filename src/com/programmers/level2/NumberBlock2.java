package com.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberBlock2 {
    /**
     * 문제명: 숫자블록
     * 난이도: level2
     *
     * */
    public static List<Integer> list;
    public static void main(String[] args) {
        long begin = 1, end =10;
        int[] solution = solution(begin, end);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
    public static int[] solution(long begin, long end) {
        int[] answer = new int[(int) ((end - begin) + 1)];
        int index= 0;
        list = new ArrayList<>();
        for (long i = begin; i <= end; i++) {
            if(i == 1)
                list.add(0);
            else{
                list.add((int) addValue(i));
            }
        }
        for (Integer integer : list) {
            answer[index++] = integer;
        }

        return answer;
    }
    public static long addValue (long index){

        for (long i = 2; i <= Math.sqrt(index); i++) {
            if (index % i == 0) {
                if (index / i > 10000000) {
                    continue;
                }
                return index / i;
            }
        }

        return 1;
    }
}
