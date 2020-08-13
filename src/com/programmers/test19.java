package com.programmers;
/*멀쩡한 사각형*/
public class test19 {
    public static void main(String[] args){
        int w = 8 ,h= 12;

        long result = solution(w,h);

        System.out.println("result===>"+result);

    }

    public static long solution(int w, int h){
        long answer= 1;

        long temp_w = Long.parseLong(String.valueOf(w));
        long temp_h = Long.parseLong(String.valueOf(h));

        return (temp_w*temp_h) - ( temp_w+temp_h-re_parsing(temp_w,temp_h));


    }
    public static long re_parsing(long w, long h){

        long min,max ;


        //w = 8 h=12 이라고 가정하면 big =12  small =6;
        max = w >= h ? w : h ;
        min = w < h ? w : h ;

        while ( min != 0 ) {
            long temp = max % min ;   //ex: nmg = 12 % 6 = 0;
            max = min;  //ex big = 6;
            min = temp; //ex small 은 나머지 값 0이된다.
        }
        return max;

    }
}
