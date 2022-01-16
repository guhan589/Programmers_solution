package com.programmers.level2;

public class OtherBit {
    public static void main(String[] args) {
        long[] numbers = {2, 7};
        long[] solution = solution(numbers);
        for (long l : solution) {
            System.out.println("l = " + l);

        }
    }
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary_str = Long.toBinaryString(numbers[i]);
            if (numbers[i] % 2 == 0) { //짝수 일 경우 다음 값이 비트가 1~2개 다르면서 제일 작은 수
                answer[i] = answer[i] + 1;
            }else{
                int l_index = binary_str.lastIndexOf(0);

                int f_index = binary_str.lastIndexOf('1', l_index);

                System.out.println("l_index = " + l_index);
                System.out.println("f_index = " + f_index);


            }

        }
        return answer;
    }
}
