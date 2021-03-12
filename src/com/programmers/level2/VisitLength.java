package com.programmers.level2;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * Level 2 방문길이
 * 다시풀것
 * */
public class VisitLength {
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
//        String dirs = "ULURRDLLU";
        int result = solution(dirs);
        System.out.println("result = " + result);

    }

    public static int solution(String dirs) {
        int answer = 0;
        int x = 0, y = 0;

        HashSet<String> hashset = new HashSet<>();

        for(Character dir : dirs.toCharArray()){ //문자별로 반복문 iter
            int tempX = x, tempY = y;

            if(dir == 'U' && y+1 <= 5) y++; //방향이 up이고 범위 안에 있을 경우 y값 증가
            if(dir == 'D' && y-1 >= -5) y--;//방향이 down이고 범위 안에 있을 경우 y값 감소
            if(dir == 'R' && x+1 <= 5) x++;//방향이 right이고 범위 안에 있을 경우 x값 증가
            if(dir == 'L' && x-1 >= -5) x--;//방향이 left이고 범위 안에 있을 경우 x값 감소

            if(tempX == x && tempY == y){ // 주언진 방향이 xy좌표 범위값을 초과하는 경우 continue
                continue;
            }

            //양방향 다 넣어주기
            hashset.add(tempX+""+tempY+""+x+""+y);
            hashset.add(x+""+y+""+tempX+""+tempY);
        }


        for (String s : hashset) {
            System.out.println("s = " + s);
        }
        answer = hashset.size()/2;
        return answer;
    }
}
