package com.programmers.level2;

import java.util.Stack;

/**
 * 괄호회전하기 level2(완성)
 * */
public class ParenthesisRotation {
    public static void main(String[] args) {
//        String s = "[)(]";
        String s = "[](){}";
//        String s = "[](){}";


        int solution = solution_1(s);
//        int solution = solution_2(s);
        System.out.println("solution = " + solution);
    }
    public static int solution_1(String s) {  //솔루션1
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            Stack<String> st = new Stack();
            s = s.substring(1,s.length())+s.substring(0,1);

            for(int j=0; j<s.length(); j++){
                String word = s.substring(j,j+1);
                if(st.isEmpty()){
                    st.push(word);
                    continue;
                }

                if(word.equals(")") && st.peek().equals("(")){
                    st.pop();
                }else if(word.equals("}") && st.peek().equals("{")){
                    st.pop();
                }else if(word.equals("]") && st.peek().equals("[")){
                    st.pop();
                }else{
                    st.push(word);
                }
            }

            if(st.isEmpty()){
                answer++;
            }

        }
        return answer;
    }
   /* public static int solution_2(String s) {
        int temp = 0;

        for (int i = 0; i < s.length(); i++) {

        }
        return temp;
    }*/
}
