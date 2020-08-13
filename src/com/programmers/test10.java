package com.programmers;
/*피보나치 수열*/
public class test10 {
    public static void main(String[] args){
        int n = 3;
        int result = solution(3);
        System.out.println("result--->"+result);
    }
    public static int solution(int n) {
        int a =0; int b =1;int c=0;
        for(int i =2; i<=n; i++) {
            c = (a+b)%1234567;
            a = b%1234567;
            b = c%1234567;
        }
        return c;
    }
}