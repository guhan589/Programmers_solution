package com.programmers.level3;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 단속 카메라 level3(완성)
 * */
public class CheckdownCamera {
    public static void main(String[] args) {
        int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int result = solution(routes);
        System.out.println("result = " + result);

    }


    static int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
                //x == y 일 경우 0 리턴
                //x < y   일 경우 음수 리턴
                //x > y   일 경우 양수 리턴

            }
        });

        /*for (int[] route : routes) {
            System.out.println("route0 = " + route[0]);
            System.out.println("route 1= " + route[1]);
        }*/

        int min = routes[0][1];

        for (int i = 1; i < routes.length - 1; i++) {
            if (min > routes[i][1])
                 min = routes[i][1];


            if (min < routes[i+1][0]) {
                answer++;
                min = routes[i+1][1];
            }
        }

        return answer;

    }
}
