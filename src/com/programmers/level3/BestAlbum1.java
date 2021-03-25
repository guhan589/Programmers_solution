package com.programmers.level3;


import java.util.*;

/**
 * 베스트 앨범 level3 (미완성)
 *
 * **/
public class BestAlbum1 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plyas = {500, 600, 150, 800, 2500};
        int[] result = solution(genres, plyas);

    }
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        /**
         * 제약조건
         * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
         * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
         * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
         * */

        
        Map<Integer, String> gmap = new HashMap<>(); //index - 장르명
        Map<Integer, Integer> pmap = new HashMap<>();//index - 플레이시간
        Set<String> gset = new HashSet<>(); // 중복되는 장르 삭제
        

        for (int i = 0; i < genres.length; i++) {
            gmap.put(i, genres[i]); //장르명
            gset.add(genres[i]);// 중복되는 장르 삭제
            pmap.put(i, plays[i]); // 플레이시간 
        }
        Map<String, Integer> totalPlayTime = new HashMap<>();

        for (int i = 0; i < gmap.size(); i++) {
            int temp = 0;
            if (totalPlayTime.containsKey(gmap.get(i))) {
                temp += totalPlayTime.get(gmap.get(i)) + pmap.get(i);
                totalPlayTime.put(gmap.get(i), temp);
            }else
                totalPlayTime.put(gmap.get(i), pmap.get(i));
        }


    /*    for (String s : totalPlayTime.keySet()) {
            System.out.println("map.get(s) = " + s);
            System.out.println("map.get(s) = " + totalPlayTime.get(s));

        }*/
        /*for (int i = 0; i < genres.length; i++) {
            list.add(new Musicinformation(genres[i], plays[i]));
        }*/

        /*Collections.sort(list, new Comparator<Musicinformation>() {
            @Override
            public int compare(Musicinformation o1, Musicinformation o2) {
                if(o1.genres.equals(o2.genres))
                    return 0;
                else if(o1.)
            }
        });*/
//        map = new HashMap<>();


        return answer;
    }
    static class Musicinformation{

        String genres;
        int plays;

        public Musicinformation(String genres, int plays) {
            this.genres = genres;
            this.plays = plays;
        }

        public String getGenres() {
            return genres;
        }

        public int getPlays() {
            return plays;
        }
    }
}
