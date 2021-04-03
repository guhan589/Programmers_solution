package com.programmers.kakao;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
    static int[][] train1;
    public static void main(String[] args) {
        int n = 6;
        int[] passenger = {1, 1, 1, 1, 1, 1};
        int[][] train = {{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}};
    }
    /**
     * 1부터 n까지 번호가 하나씩 붙어있는 n개의 역이 철로로 연결되어 있습니다. 철로는 양방향 통행이 가능하며, 임의의 두 역을 직접 연결하는 철로는 최대 하나입니다. 또, 서로 다른 두 역 사이의 이동 경로는 딱 한 가지며, 임의의 두 역 사이에 이동 불가능한 경우는 없습니다.
     *
     * 출발역과 종착역 사이를 왕복하는 열차를 운행하려 합니다. 출발역은 1번 역이며, 전체 역 중 한 곳을 종착역으로 정해야 합니다. 단, 열차가 출발역에서 종착역까지 갈 때 모든 역을 방문할 필요는 없으며, 같은 역을 두 번 이상 방문하면 안 됩니다.
     *
     * 종착역을 정하기 위해 각 역의 일일 이용객 수를 조사했습니다. 이때, 열차가 방문하는 역의 일일 이용객 수의 합이 최대가 되도록 종착역을 지정하면 됩니다. 만약 일일 이용객 수의 합이 최대가 되는 역이 여러개라면, 그 중 번호가 큰 역을 선택하면 됩니다.
     *
     * 전체 역의 개수 n, 1번부터 n번 역까지 일일 이용객 수 passenger, 역 사이의 철로 연결 정보 train이 매개변수로 주어질 때, 종착역으로 지정할 역 번호와 그때의 이용객 수 합을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
     * */
    public static int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = {};
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();


        출처: https://mine-it-record.tistory.com/236 [나만의 기록들]
        train1 = train;
        for (int i = 2; i <= n; i++) {//출발지점이 1부터 시작

        }
        return answer;
    }

    static void dfs() {
        for (int[] ints : train1) {

        }
    }

}
