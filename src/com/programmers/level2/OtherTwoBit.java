package com.programmers.level2;

public class OtherTwoBit {
    public static void main(String[] args) {
        long[] numbers = {2, 7};

        long[] solution = solution(numbers);
        for (long l : solution) {
            System.out.println("l = " + l);
        }


    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length]; //return 할 배열 사이즈 선언

        for (int i = 0; i < numbers.length; i++) {
            String BinaryCode = Long.toBinaryString(numbers[i]);
            //long값을 바이너리 코드 값으로 변경
            System.out.println("BinaryCode = " + BinaryCode);

            if (numbers[i] % 2 == 0) {
                answer[i] += 1; // bit는 2의 제곱승으로 표현하기에 사실상 마지막 비트의 0값을
                // 바꾼 값이 2개 이하로 다른 bit값이다.

            } else {
                int lastValue = BinaryCode.lastIndexOf("0");
                int firstValue = BinaryCode.lastIndexOf("1", lastValue);
                System.out.println("lastValue = " + lastValue);
                System.out.println("firstValue = " + firstValue);

                if (lastValue == -1) { //Binary 코드 값

                }
            }
            System.out.println();
        }

        return answer;
    }


}
