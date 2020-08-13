package com.programmers;

import java.util.Stack;
import java.util.StringTokenizer;

/*올바른 괄호*/
public class test18 {
    public static void main(String[] args){
        //String s = "()()";
        String s = ")()(";
        boolean result = solution(s);

        System.out.println("rseult===>"+result);
    }
    public static boolean solution(String s) {
            boolean answer = true;
            Stack<Character> stack = new Stack();

            String str_temp=s;
            //String[] split_str = s.split("");


            //) : 41 (: 40
            for(char c : s.toCharArray()){
                if(!stack.isEmpty()){
                    char temp_c = stack.peek();
                    int ascii_code = (int)temp_c - (int)c;
                    if(ascii_code==-1)
                        stack.pop();
                    else
                        stack.push(c);

                }
                else
                    stack.push(c);
            }

            if (stack.isEmpty())
                answer = true;
            else
                answer = false;

            return answer;


       /* Stack<Character> a = new Stack<Character>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                a.push(s.charAt(i));
            }
            //answer를 false로 초기화 해놓고 바로 return을 해줘야 시간초과가 나지 않는다.
            else {
                if(a.isEmpty()) {
                    return answer;
                } else if(a.pop()!='(') {
                    return answer;
                }
            }
        }

        if(a.isEmpty()) {
            answer = true;
        }

        return answer;*/
    }
}
