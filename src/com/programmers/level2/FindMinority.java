package com.programmers.level2;


import java.util.HashSet;
import java.util.Set;

/**
 * 2022.12.01 소수찾기 level2 미완성
 * 
 * */
public class FindMinority {
    public static void main(String[] args) {
        String numbers = "01840001";
        int result = solution(numbers);

        System.out.println("result = " + result);
    }
    public static int solution(String numbers) {
        int answer = 0;
        char[] chNumber = numbers.toCharArray();
        Set<String> set = new HashSet<>();
        String stringNumber = "";
        for (int i = 0; i < chNumber.length; i++) {
            stringNumber += chNumber[i];
            if (calValue(stringNumber) &&!set.contains(stringNumber)) {
                set.add(stringNumber);
                answer++;
            }

            for (int j = 0; j < chNumber.length; j++) {
                if(i == j)
                    continue;
                else {
                    stringNumber += chNumber[j];
                    if (calValue(stringNumber) && !set.contains(stringNumber)) {
                        set.add(stringNumber);
                        answer++;
                    }
                }

            }
            stringNumber = "";
        }

        for (String s : set) {
            System.out.println("s = " + s);
        }
        return answer;
    }

    public static boolean calValue(String number) {
        System.out.print("number = " + number);
        int intNumber = Integer.parseInt(number);
        System.out.println("   intNumber = " + intNumber);
        if (intNumber % 2 == 0 || intNumber == 1) {

            return false;
        }
        return true;
    }
//    public static int solution(String numbers) {
//        int count = 0;
//        List<Integer> numberList = new ArrayList<>();
//        Set<Integer> numberSet = new HashSet<>();
//
//        int numberLength = numbers.length();
//
//        if(numberLength < 1 || numberLength >7)
//            return 0;
//
//        char[] chNumbers = numbers.toCharArray();
//        for (char chNumber : chNumbers) { //char -> ArrayList
//            numberList.add(Integer.parseInt(String.valueOf(chNumber)));
//        }
//        Collections.sort(numberList); // 오름차순 정렬
//
//        /**
//         * tempValue1 ===> 앞자리
//         * tempValue1 ===> 뒷자리
//       리 * */
//        for (int i = 0; i < numberList.size(); i++) {
//            int tempValue1 = numberList.get(i);
//            if (calValue(tempValue1)) {//단일 값이 소수가 아님
//                numberSet.add(tempValue1);// 소수 인 단일 값
//            }
//            for (int j = 0; j < numberList.size(); j++) {
//                if(i==j)
//                    continue;
//                else{
//
//                }
//            }
//
//        }
//        return count;
//    }
//
//    public static boolean calValue(int number) {
//        if (number % 2 == 1) {
//            return false;
//        }
//
//        return true;
//
//    }


}