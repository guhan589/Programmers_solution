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
            gset.add(genres[i]);// 중복되는 장르 삭제
            gmap.put(i, genres[i]); //장르명
            pmap.put(i, plays[i]); // 플레이시간 
        }


        

        Map<Integer, String> totalPlayTime = new HashMap<>(); // 장르별 재생횟수(총재생시간, 장르)
        for (String o : gset) {
            int total = 0; //총재생시간 변수
            for (int i = 0; i < gmap.size(); i++) {
                if(gmap.get(i).equals(o))
                    total += pmap.get(i); //총 재생시간
            }
            totalPlayTime.put(total, o);//횟수와 재생시간
        }


        TreeMap treeMap = new TreeMap(totalPlayTime);
        String[] sorttemp = new String[gset.size()];// hashset사이즈 만큼 배열 선언

        int index = 0;
        for (Object o : treeMap.keySet()) {
            sorttemp[index++] = treeMap.get(o).toString(); //많이 재생된 시간별로 정렬
        }
        //treeMap.get(o).toString(); = 1450
        //treeMap.get(o).toString(); = 3100

        List<Integer> playtimeList = new ArrayList<>();
        for (int i = sorttemp.length - 1; i > -1; i--) {
            int cnt = 0;
            for (int key : gmap.keySet()) {
                System.out.println("key = " + key);
                if (sorttemp[i].equals(gmap.get(key))) {
                    cnt++;
                }
            }


            int[] temp = new int[cnt];
            int count = 0;

            for (int o : gmap.keySet()) {
                if (sorttemp[i].equals(gmap.get(o))) {
                    temp[count++] = pmap.get(o);
                }
            }


        }
        return answer;
    }
  
    /*static class Musicinformation implements Comparable<Musicinformation>{

        int index;
        String genres;
        int plays;

        public Musicinformation(int index, String genres, int plays) {
            this.index = index;
            this.genres = genres;
            this.plays = plays;
        }

        public int getIndex() {
            return index;
        }

        public String getGenres() {
            return genres;
        }

        public int getPlays() {
            return plays;
        }

        @Override
        public int compareTo(Musicinformation musicinformation) {
            if(this.plays == musicinformation.plays)
                return this.plays - musicinformation.plays;
            else
                return -(this.plays - musicinformation.plays);
        }

        //장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

    }*/
}
