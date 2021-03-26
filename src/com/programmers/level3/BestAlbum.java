package com.programmers.level3;

import java.util.*;


/**
 * 베스트 앨범 level3 (완성)
 * */
public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plyas = {500, 600, 150, 800, 2500};
        int[] result = solution(genres, plyas);
        for (int i : result) {
            System.out.println(i);
        }
    }
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        int[][] arr = new int[(int) Arrays.stream(genres).distinct().count()][2];
        /**
         * 제약조건
         * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
         * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
         * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
         * */


        List<Musicinformation> list = new ArrayList<>();
        Map<String, Integer> gmap = new HashMap<>(); //장르 - 플레이시간
        Map<String, Integer> cntmap = new HashMap<>(); //장르 - 카운트
        List<Integer> resultlist = new ArrayList<>(); // 결과 id값

        for (int i = 0; i < genres.length; i++) {
            list.add(new Musicinformation(i, genres[i], plays[i]));
            if (gmap.containsKey(genres[i])) {
                gmap.put(genres[i], gmap.get(genres[i]) + plays[i]);
            }else
                gmap.put(genres[i], plays[i]);
        }

        Collections.sort(list, new Comparator<Musicinformation>() {
            @Override
            public int compare(Musicinformation o1, Musicinformation o2) {
                if(o1.getGenres().equals(o2.getGenres()))
                    return o1.compareTo(o2);
                else
                    return -(gmap.get(o1.getGenres()) - gmap.get(o2.getGenres()));
            }
        });

    /*    for (Musicinformation musicinformation : list) {
            System.out.println("musicinformation = " + musicinformation.getIndex());
            System.out.println("musicinformation = " + musicinformation.getGenres());
            System.out.println("musicinformation = " + musicinformation.getPlays());
            System.out.println("==================");
        }*/



        for (Musicinformation entity : list) {
            if (!cntmap.containsKey(entity.getGenres())) { // 카운트를 의미하는 map에 key가 없을경우
                cntmap.put(entity.getGenres(), 1);// 장르 - 카운트 1
                resultlist.add(entity.index);
            }else{
                int cnt = cntmap.get(entity.getGenres());
                if (cnt < 2) {
                    cntmap.put(entity.genres, cnt + 1);
                    resultlist.add(entity.index);
                }

            }
        }
        answer = new int[resultlist.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = resultlist.get(i);
        }

        return answer;
    }

    static class Musicinformation implements Comparable<Musicinformation>{

        int index;
        String genres;
        int plays;

        public Musicinformation(int index, String genres, int plays) {
            this.index = index;
            this.genres = genres;
            this.plays = plays;
        }

        public String getGenres() {
            return genres;
        }

        public int getPlays() {
            return plays;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Musicinformation o) {
            if(this.plays == o.plays)
                return this.index - o.index;
            else
                return -(this.plays - o.plays);

        }
    }
}
