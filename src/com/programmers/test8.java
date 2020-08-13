package com.programmers;


/* 최소공배수 */
public class test8 {
    public static void main(String[] args){
        //int[] arr = {1,2,3};
        int[] arr = {2,6,8,14};
        int result = solution(arr);
        System.out.println("result===>"+result);
    }
    public static int solution(int[] arr) {
        int answer = 0;
        int temp = arr[arr.length-1];// 배열의 마지막 값을 temp 변수에 저장
        int i=1;
        int count=0;

        while (true){
            int inner_temp = temp * i;
            for(int z = 0 ; z < arr.length-1;z++){
                if(inner_temp % arr[z] == 0)
                    count++;
                else {
                    i++;
                    break;
                }

                if(count==arr.length-1)
                    return inner_temp;
            }

            count=0;

        }

    }
}
