package com.programmers.kakao;

public class TechDevelopersTest2 {
    public static void main(String[] args) {
        /**
         *
         * 각 대기실 별로 모든 응시자가 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 담습니다.
         *
         * 대기실은 5개이며, 각 대기실은 5x5 크기입니다.
         * 거리두기를 위하여 응시자들 끼리는 맨해튼 거리1가 2 이하로 앉지 말아 주세요.
         * 단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.
         *
         * 두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면, T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다
         * */
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        int[] solution = solution(places);
        for (int i : solution) {
            System.out.println("i = " + i);
        }

    }
    public static int[] solution(String[][] places) {
        int[] answer = {};
        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[i].length; j++) {

            }
        }
        return answer;
    }
}
