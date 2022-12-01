package com.programmers.level2;

public class Jumpmove {
    public static void main(String[] args){
        int n = 4;
        long result = solution(n);
        System.out.println("result-->"+result);
    }
    public static long solution(int n){
        long[] dpTree = new long[2001];
        dpTree[1]=1;
        dpTree[2]=2;
        for(int i=3;i<=2000;i++){
            dpTree[i] = (dpTree[i-1]+dpTree[i-2])%1234567;
        }
        return dpTree[n]%1234567;
    }
}
