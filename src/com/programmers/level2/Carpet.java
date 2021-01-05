package com.programmers.level2;

public class Carpet {
    public static int[] result = new int[2];
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        int[] result = solution(brown, yellow);
        for(int i : result)
            System.out.println(i);
    }

    static int[] solution(int brown,int yellow){
        int[] answer = new int[2];
        int sum = (brown + 4) / 2; // 가로와 세로의 합.
        /**
         * n:가로 m: 세로 일때
         * ex) 2*3 + 2*(4-2) = 10(brown 개수)
         * */
        int m = 3; // 세로
        int n = sum - m; // 가로
        // 노란색 칸이 최소 1개이기때문에 n은 3이상이어야 함.
        // 문제에서 가로 길이는 세로 길이보다 크거나 같다고 명시되어 있음.
        while(n >= 3 && n >= m) {
            // (가로 - 2) * (세로 - 2)는 노란색 칸의 개수와 같음.
            if((n - 2) * (m - 2) == yellow){
                answer[0] = n;
                answer[1] = m;
                break;
            }

            n--; m++;
        }

        return answer;
    }
    /*static int[] solution(int brown, int yellow){
        int[] answer= {};
        int sum = brown + yellow;
        System.out.println("sum:" + sum);
        if(sum%2 == 0){
            answer = re_parsing(2, sum/2,2);
        }else
            answer = re_parsing(3, sum/3,3);

        return answer;
    }
    static int[] re_parsing(int front, int back,int div){
        if(front == back){
            result[0] = front;
            result[1] = back;
        }else if(back > front){
            return re_parsing(front * div, back / div, div);
        }else{
            result[0] = front;
            result[1] = back;
        }

        return result;
    }*/
}
