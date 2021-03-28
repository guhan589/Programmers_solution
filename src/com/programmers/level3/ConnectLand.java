package com.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 섬 연결하기 레벨 3 (완성)
 * **/
public class ConnectLand {
    static int[] parent;

    public static void main(String[] args) {
        int[][] cost = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        int n = 4;
        int result = solution(n, cost);
        System.out.println("result = " + result);
    }
    public static int find(int child) { // 재귀 호출을 통해서 부모 찾기
        if(parent[child] == child) {
            return child;
        }else {
            return parent[child] = find(parent[child]);
        }
    }
    public static int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n]; //각 노드가 가지고 부모를 의미하는 int 배열
        for (int i = 0; i < parent.length; i++)
            parent[i] = i; // 부모를 의미하는 값을 자기 자신으로 초기화
        Arrays.sort(costs, new Comparator<int[]>() { // 가중치를 기준으로 오름차순 정렬
            @Override
            public int compare(int[] o1, int[] o2) {

                Integer a = o1[2];
                Integer b = o2[2];
                return a.compareTo(b); // a==b -> 0, a>b -> 양수 a<b -> 음수 반환
            }
        });

        for (int[] cost : costs) {
            System.out.println("cost = " + cost[0] + ", " + cost[1] + ", " + cost[2]);
        }
        for(int i = 0; i < costs.length; i++) {
            int num1 = find(costs[i][0]);    
            int num2 = find(costs[i][1]);
            if(num1 != num2) {            //부모가 같지 않다면 연결이 안된 최솟값이므로
                parent[num2] = num1;    //연결
                answer += costs[i][2];
            }
        }
        return answer;



    }

}
