package com.programmers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*최솟값 만들기*/
public class test15 {
    public static void main(String[] args){

        int[] A = {1,4,2};
        int[] B = {5,4,4};


        /*int[] A = {1,2};
        int[] B = {3,4};*/

        int result = solution(A,B);
        System.out.println("result--->"+result);

    }
    public static int solution(int []A, int []B)
    {
        int answer= 0;

        Arrays.sort(A);
        Arrays.sort(B);




        for(int i = 0 ; i < A.length;i++){
            answer += A[i] * B[A.length-i-1];
        }
        return answer;

    }
}
