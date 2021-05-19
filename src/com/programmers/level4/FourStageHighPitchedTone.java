package com.programmers.level4;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class FourStageHighPitchedTone {
    /**
     * 4단 고음 level4 (미완성)
     * */
    public static void main(String[] args) {
        List list = new ArrayList();

        int n = 15;
        int solution = solution(n);
        System.out.println("solution = " + solution);

        addAll(list, 1, 2, 3, 45);
        rotate(list, 2);
        for (Object o : list) {
            System.out.println("o = " + o);
        }
    }
    static int solution(int n) {
        int answer = 0;
        return answer;
    }

}
