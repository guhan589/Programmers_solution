package com.programmers.level3;


/**
 * 네트워크
 * **/
public class Network {
    public static void main(String[] args) {

        int n = 3;
        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int result = solution(n, computers2);

        System.out.println("result = >" + result);

    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if(visit[i] == false) {
                dfs(i, visit, computers);
                answer++;
            }
        }

        return answer;

    }

    public static void dfs(int i, boolean[] visit, int[][] computers) {
        visit[i] = true;
        for (int j = 0; j < computers.length; j++) {
            if (visit[j] == false && computers[i][j] == 1) {
                dfs(j, visit, computers);
            }
        }

    }
}
