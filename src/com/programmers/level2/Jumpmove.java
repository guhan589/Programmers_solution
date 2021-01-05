package com.programmers.level2;

public class Jumpmove {
    public static void main(String[] args){
        int n = 6;
        int result = solution(n);
        System.out.println("result-->"+result);
    }
    public static int solution(int n){
        int ans = 0;

        while(n!=0){
            if(n%2==0){
                n = n /2;
            }else{
                n--;
                ans++;
            }
        }

        return ans;
    }

}
