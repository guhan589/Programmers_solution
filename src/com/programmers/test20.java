package com.programmers;

import java.util.*;

public class test20 {
    public static void main(String[] args){
        //String numbers = "147"; // 7,17,71
        String numbers= "011"; //11 , 101
        int result = solution(numbers);
        System.out.println("result===>"+result);
    }
    public static int solution(String numbers){

        int answer= 0;
        int count = 0, redo_temp  = -1;
        ArrayList<Integer> list = new ArrayList<>();

        String[] split_str = numbers.split("");


        Arrays.sort(split_str,Comparator.reverseOrder());


        for(String str : split_str)
            list.add(Integer.parseInt(str));

        /*Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 >= o2 ? o1 : o2;
            }
        });*/



        /*필터 1*/
        for(int i = 0; i < list.size(); i++){
            int temp =  list.get(i);
            if(temp == 0) //0일 때 무시
                continue;
            else {
                if(temp == redo_temp)
                    list.add(temp);
                else {
                    boolean result = re_parsing(temp, count); //flase: 소수 true: 소수x
                    count = 0;
                    if (!result){ // 소수일떄
                        list.remove(i);
                        redo_temp = -1;
                    }else//소수가 아닐때
                        redo_temp = temp;
                }
            }
        }
        for(int i =  0; i < list.size(); i++) //list내역 출력
            System.out.println("list--->"+list.get(i));
        /*필터2*/
       /*while(list.size()!=0){
            for(int i = 0; i < list.size(); i++){
                int temp =  list.get(i);
                if(temp == 0) //0일 때 무시
                    continue;
                else {
                    if(temp == redo_temp)
                        list.add(temp);
                    else {
                        boolean result = re_parsing(temp, count); //flase: 소수 true: 소수x
                        count = 0;
                        if (!result){ // 소수일떄
                            list.remove(i);
                            redo_temp = -1;
                        }else//소수가 아닐때
                            redo_temp = temp;
                    }
                }
            }
        }*/

        ArrayList<Integer> solution_result = last_order(list);
        for(int i =  0; i < solution_result.size(); i++) //list내역 출력
            System.out.println("solution_result--->"+solution_result.get(i));
        return answer;

    }
    public static ArrayList last_order(ArrayList<Integer> list){

        ArrayList<Integer> temp_list = new ArrayList<>();


        for(int i=0 ; i <list.size();i++){
            temp_list.add(list.get(i));
            for(int j = 0 ; j < list.size(); j++){
                if(i!=j)
                    temp_list.add(Integer.parseInt(String.valueOf(list.get(i))+String.valueOf(list.get(j))));
                else
                    continue;
            }
        }
        return temp_list;
    }
    public static boolean re_parsing(int num,int count){

        if(count>1)
            return false;
        if(num % 2 ==0) {
            count++;
            return re_parsing(num/2, count);
        }else if( num % 3 ==0){
            count++;
            return re_parsing(num/3, count);
        }

        return true;
    }


}
