package com.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class test2 {
    public static void main(String[] args){
        String[][] str = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = solution(str);
        System.out.println("result===>"+result);
    }
    public static int solution(String[][] clothes){
        int answer= 0;
        HashMap<String,String> map =new HashMap<>();
        ArrayList<Integer>list = new ArrayList<>();

        for(int i = 0 ; i< clothes.length;i++){
            map.put(clothes[i][0],clothes[i][1]);
        }

        Iterator iterator = map.keySet().iterator();

        while(iterator.hasNext()){
            answer++;
            iterator.next();
        }
        iterator = map.values().iterator();

        while(iterator.hasNext()){

        }

        if(list.size()==1)
            return answer;
        return answer;

    }
}
