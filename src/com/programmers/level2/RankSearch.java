package com.programmers.level2;

public class RankSearch {
    /**
     * 순위 검색 level2 (미완성)
     *
     * */
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] solution = solution(info, query);
        for (int i : solution) {
            System.out.println("solution = " + solution[i]);
        }
    }

    static int[] solution(String[] inf, String[] query) {
        int[] answer = new int[query.length];

        String[][] arr = new String[inf.length][5];
        for (int i = 0; i < inf.length; i++) {
            String[] strings = inf[i].split(" ");

            for (int j = 0; j < strings.length; j++) {
                arr[i][j] = strings[j]; // 배열에 info문 저장
            }
        }

        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println("");
        }
        return answer;
    }
}
