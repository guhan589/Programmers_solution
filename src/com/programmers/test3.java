package com.programmers;

public class test3 {
    public static void main(String[] args){
        int n =15;
        int result = solution(n);
        System.out.println("result==>"+result);
    }
    public static int solution(int n) {
        int answer = 0;
        int sum = 0 ;
        for(int i = 1 ; i<=n;i++){
            for(int j = i; j<=n;j++){
                sum+=j;
                if(sum==n){
                    answer++;
                    sum=0;
                    break;
                }else if(sum>n) {
                    sum=0;
                    break;
                }
            }

        }
        return answer;
    }
}
