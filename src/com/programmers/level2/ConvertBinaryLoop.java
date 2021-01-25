package com.programmers.level2;


/**
 *
 * 이진 변환 반복하기
 *
 * */
public class ConvertBinaryLoop {
    public static void main(String[] args) {
        String s = "110010101001";
        int[] result = solution(s);
        System.out.println("result[0] = " + result[0]);
        System.out.println("result[1] = " + result[1]);
    }
    public static int[] solution(String s) {
        int[] answer = new int[2];
        int count =0;//회숫를 의미
        int delteZero = 0;
        String temp = s;

        while(!temp.equals("1")){
            count++;//회수증가
            String[] convertBinaryResult = convertBinary(temp);

            temp = convertBinaryResult[0];
            delteZero += Integer.parseInt(convertBinaryResult[1]);
        }
        answer[0] = count;
        answer[1] = delteZero;
        return answer;
    }

    static String[] convertBinary(String s) { //주어진 입력값에 대해서 0을 제거한 결과를 반환
        String[] answer = new String[2];
        String temp = "";
        int dleteZerocount = 0;
        char[] ch = s.toCharArray();

        for (char c : ch) {
            if (c == '1') {
                temp += c; //1만 문자열에 붙임
            }else{
                dleteZerocount++; // 0 제거 회수
            }

        }
        answer[0] = convertInt(temp.length());
        answer[1] = String.valueOf(dleteZerocount);

        return answer;
    }
    static String convertInt(int oneGroup){ //1의 문자열의 길이를 binary로 변환
        String answer = "";

        int temp = oneGroup;
        while (temp != 0) {
            answer = String.valueOf(temp % 2) + answer;
            temp = temp / 2;
        }
               return answer;
    }

}
