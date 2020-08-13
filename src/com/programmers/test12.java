package com.programmers;

import java.util.ArrayList;

/*영어 끝말잇기*/
public class test12 {
    public static void main(String[] args){
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int n = 3;
        int[] result = solution(n,words);


        System.out.println(result[0]+","+result[1]);
    }
    public static int[] solution(int n ,String[] words){
        int[] answer={0,0};
        int count = 0, num=0;
        ArrayList<String>list = new ArrayList<>();

        String[][] inform = new String[n][words.length/n];

        while(count< words.length){ //중복검사

            if(num==3)
                num = 0;

            if(list.contains(words[count])) {
                answer = new int[]{(num + 1), (count + 1) / (num + 1)};
                return answer;
            }

            list.add(words[count]);
            count++;num++;
        }

        for(int i = 0; i< inform.length;i++){ // 열
            for(int j =0 ; j < inform[i].length;j++) {//행
                if(j!=0){

                }else{

                }
            }
        }

        return answer;
    }
}
