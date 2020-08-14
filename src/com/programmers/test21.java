package com.programmers;

import java.util.ArrayList;

public class test21 {
    public static void main(String[] args){

        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int result = solution(land);
        System.out.println("resullt --->" +result);
    }
    public static int solution(int[][] land) {
        int answer = 0;
        int count = 0;
        int temp = 0 , j=-1;
        ArrayList<A> list = new ArrayList<>();

        while(count<land.length){
            int max = -1; //행이 변경될 떄마다 max변수값 -1로 초기화
            int key = -1; //최대값을 가능 열를 뜻하는 변수
            if(j!=-1)
                land[count][j] = -1;
            for(int i  = 0; i < land[count].length; i++){

                int inner_temp = land[count][i];

                if(inner_temp>max) {//최대값 변경
                    max = inner_temp; // 맥스값 변경
                    key = i;

                }

            }
            list.add(count,new A(key,max)); //열과 열에 대한 value값
            A a = list.get(count);
            j =  a.getKey();

            count++;
        }

        for(int i =0; i <list.size();i++){
            A a = list.get(i);
            answer+=a.getValue();
        }
        return answer;
    }
    public static class A{
        int key, value;
        public A(int key, int value){
            this.key = key;
            this.value = value;
        }
        public int getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }
    }
}
