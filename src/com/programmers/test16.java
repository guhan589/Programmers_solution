package com.programmers;

import java.util.Stack;
/*짝지어 제거하기*/
public class test16 {
    public static void main(String[] args){
        String s = "baabaa";
        //String s = "cdcd";
        int result= solution(s);
        System.out.println("result==>"+result);
    }
    public static int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray())
            if(!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);

        return stack.isEmpty() ? 1 : 0;

    }
}
