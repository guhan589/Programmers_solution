package com.programmers.level2;

public class OtherTwoBit {
    /**
     * 문제명 : 2개의 또 다른 비트
     * 난이도 :level2
     * */
    public static void main(String[] args) {
        long[] numbers = {2, 7, 9, 11};

        long[] solution = solution(numbers);
        for (long result : solution) {
            System.out.println("result = " + result);
        }

    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length]; // 반환 배열 초기화
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] % 2 ==0) // 짝수인 경우 number 값보다 1 큰 값이 제약조건에 맞는 값.
                answer[i] = numbers[i]+1;
            else{

                String s = Long.toString(numbers[i],2);// number 값을 radix(2진수)로 표현
                int zeroIdx = s.lastIndexOf("0"); // 마지막 0의 인자가 있는 index값을 구한다.
                if( zeroIdx != -1){
                    s = s.substring(0, zeroIdx) + "10" + s.substring(zeroIdx+2, s.length());
                    answer[i] = Long.parseLong(s,2);
                }else{// 7(111)과 같은 바이너리 값은 0의 위치가 없기에 아래와 같은 로직을 태운다.
                    s = "10" + s.substring(1,s.length());
                    answer[i] = Long.parseLong(s,2);
                }
            }

        }
        return answer;
    }


}
