package com.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class SortFilename {
    public static void main(String[] args){
        //foo010bar020.zip
        String[] temp = {"foo9.txt","foo010bar020.zip","F-15"};
        String[] temp1 = {"img12.png", "img10.png", "img02.png", "img1.png"," IMG01.GIF", "img2.JPG"};
        String[] temp2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] result = solution(temp1);
        for(String temp12 : result)
            System.out.println(temp12);
    }
    public static String[] solution(String[] files){
        String[] answer= {};
        /*String[] result1 = splitArray(files[0]);
        System.out.println("result==>"+result1[0]);
        System.out.println("result==>"+result1[1]);
        System.out.println("result==>"+result1[2]);*/

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] file1 = splitArray(o1); // file1의 head number tail 각각 구분하기
                String[] file2 = splitArray(o2); // file2의 head number tail 각각 구분하기

                /*System.out.println("result1==>"+file1[0] + " "+ file1[1] + " "+file1[2]);
                System.out.println("result2==>"+file2[0] + " "+ file2[1] + " "+file2[2]);*/


                int headresult = file1[0].compareTo(file2[0]); // 같으면 0, o1>o2: 양수 o2<o1: 음수
                
                if(headresult == 0) {// 두 문자열이 같은경우우
                    return Integer.parseInt(file1[1]) - Integer.parseInt(file2[1]); //head가 같으면 number값으로 비교
                }else
                    return headresult;

            }
        });

        return files;
    }

    public static String[] splitArray(String content){
        String head="";
        String number = "";
        String tail = "";
        int i = 0;
        char word;
        for( ; i<content.length();i++){
            word = content.charAt(i);
            if(word >= '0' && word <='9')//head 자르기 위한 for문
                break;
            else
                head += word; // head
        }

        for( ;i<content.length();i++){ // number부분
            word = content.charAt(i);
            if(word >='0' && word <= '9')
                number += word;
            else
                break;
        }
        
        for( ; i<content.length(); i++){ //tail부분
            tail += content.charAt(i);
        }

        String[] result = {head.toLowerCase(),number,tail}; //head는 문제에서 대문자든 소문자든 같은 것으로 취급
        return result;
    }
}
