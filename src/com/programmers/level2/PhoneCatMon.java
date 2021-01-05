package com.programmers.level2;

import java.util.HashSet;
import java.util.Set;

/**
 * 폰켓몬
 * */
public class PhoneCatMon {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 4};
        int result = solution(nums);
        System.out.println("result==>" + result);
    }
    public static int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums)
            set.add(i);
        if(nums.length/2 > set.size())
            answer = set.size();
        else
            answer = nums.length/2;
        return answer;
    }
}
