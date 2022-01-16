package com.programmers.level2;

import java.util.*;


/**
 * 후보키 level2 완성
 * */
public class CandidateKey {
    static List<String> candi = new ArrayList<>();
    public static void main(String[] args) {
        String[][] realtion ={
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        };

        int result = solution(realtion);
        System.out.println("result = " + result);
    }

    public static int solution(String[][] relation) {
        int answer = 0;

        for (int i = 0; i < relation[0].length; i++) {
            boolean[] visit = new boolean[relation[0].length];//릴레이션 사이즈 만큼
            dfs(visit, 0, 0, i + 1, relation);
        }
        answer = candi.size();
        return answer;
    }

    public static void dfs(boolean[] visit, int start, int depth, int end, String[][] relation) {
        if (depth == end) {
            List<Integer> list = new ArrayList<>();
            String key = "";
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    key += String.valueOf(i);
                    list.add(i);
                }
            }
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < relation.length; i++) {
                String s = "";
                for (Integer j : list) {
                    s += relation[i][j];
                }

                if (map.containsKey(s)) {
                    return;
                } else {
                    map.put(s, 0);
                }
            }

            // 후보키 추가
            for (String s : candi) {
                int count = 0;
                for(int i = 0; i < key.length(); i++){
                    String subS = String.valueOf(key.charAt(i));
                    if(s.contains(subS)) count++;
                }
                if (count == s.length()) return;
            }
            candi.add(key);

            return;
        }
        for (int i = start; i < visit.length; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            dfs(visit, i, depth + 1, end, relation);
            visit[i] = false;
        }


    }

}
