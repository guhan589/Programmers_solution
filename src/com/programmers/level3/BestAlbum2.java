package com.programmers.level3;

import java.util.*;

public class BestAlbum2 {
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

        int distict = (int) Arrays.stream(genres).distinct().count();
        List<Musicinformation> musiclist = new ArrayList<>();

        for (int i = 0; i < genres.length; i++)
            musiclist.add(new Musicinformation(i,genres[i], plays[i]));



//        같으면 0, 자신이 크면 양수, 자신이 작으면 음수를 반환
        musiclist.sort(new Comparator<Musicinformation>() {
            @Override
            public int compare(Musicinformation o1, Musicinformation o2) {
                if(o1.getGenres().equals(o2.getGenres()))
                    return o2.getPlays() - o1.getPlays();

                return o1.getGenres().compareTo(o2.getGenres());
            }
        });

//        Map<Integer, List<Musicinformation>> list = new HashMap<>();

  /*      for (Musicinformation musicinformation : musiclist) {
            System.out.println("musicinformation = " + musicinformation.getIndex());
            System.out.println("musicinformation.getGenres() = " + musicinformation.getGenres());
            System.out.println("musicinformation.getGenres() = " + musicinformation.getPlays());
            System.out.println("=======================\n");
        }*/

        Map<String, Integer> totaltime = new HashMap<>();
        String temp = musiclist.get(0).getGenres();
        totaltime.put(temp, musiclist.get(0).getPlays());


        int cnt = 0;
        for (int i = 1; i < musiclist.size(); i++) {
            String str = musiclist.get(i).getGenres();
            System.out.println("str = " + str);
            if (temp.equals(str) && cnt <2) {
//                System.out.println("totaltime.get(temp) = " + totaltime.get(temp));
                totaltime.put(str,totaltime.get(temp)+musiclist.get(i).getPlays());
                ++cnt;
            }else{
                temp = str;
                cnt = 0;
            }
        }

        for (String s : totaltime.keySet()) {
            System.out.println("s = " + s);
            System.out.println("totaltime.get(s) = " + totaltime.get(s));
        }


        return answer;
    }
    static class Musicinformation{

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
    }
}
