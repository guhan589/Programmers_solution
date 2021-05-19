package com.programmers.level2;

import java.util.*;


/**
 * 뉴스 클러스팅 level2 (완성)
 * */
public class arrNewsClustering {
    public static void main(String[] args){


        String str1 = "FRANCE";
        String str2 = "french";
        String str3 = "aa1+aa2";
        String str4 = "AAAA12";

        int result  = solution(str1,str2);
        System.out.println("answer==>"+result);
    }
    public static int solution(String str1, String str2){


        List<String> result1 = splitStr(str1);
        List<String> result2 = splitStr(str2);
        List<String> unionList = new ArrayList<>();
        List<String> intersectionList = new ArrayList<>();
        double jacquard = 0;
        /*Arrays.sort(result1);
        Arrays.sort(result2);*/
        Collections.sort(result1);
        Collections.sort(result2);


        for(String s : result1){
            if(result2.remove(s))
                intersectionList.add(s);
            unionList.add(s);

        }
        unionList.addAll(result2);

        if(unionList.size()==0)
            jacquard = 1;
        else
            jacquard =(double)intersectionList.size() / unionList.size();
        return (int)(jacquard*65536);
    }

    static List<String> splitStr(String str){
        String[] answer;
        ArrayList<String>list = new ArrayList<>();
        int i = 0;
        for( ; i< str.length();i++){
            if(i>0){
                char c1 = str.charAt(i-1);
                char c2 = str.charAt(i);

                boolean status1 = checkNum((int)c1);

                if(status1) { // char값이 알파벳이면
                    boolean status2 = checkNum((int)c2);
                    if(status2){
                        String temp = (String.valueOf(c1)+String.valueOf(c2)).toUpperCase();
                        list.add(temp);
                    }
                    else
                        i++;
                }




            }
        }



        return list;
    }
    static boolean checkNum(int value){
        if((value>=65 && value<=90) || (value>=97 && value<=122)){
            return true;
        }else
            return false;
    }
}
