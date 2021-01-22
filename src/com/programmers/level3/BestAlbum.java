package com.programmers.level3;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 베스트 앨범
 *
 * **/
public class BestAlbum {
    public static HashMap<String, Integer> map;
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plyas = {500, 600, 150, 800, 2500};
        int[] result = solution(genres, plyas);

    }
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int genresCount = (int) Arrays.stream(genres).distinct().count();
        boolean[][] genresType = new boolean[genresCount][2];// 장르별 배열 공간생성
        map = new HashMap<>();


        System.out.println(map.size());



        return answer;
    }
}
