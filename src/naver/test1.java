package naver;

import java.text.DecimalFormat;

public class test1 {
    public static void main(String[] args){
        /*int n = 6;
        int[]p = {5,4,7,2,0,6};
        int[]c = {4,6,4,9,2,3};*/
        int n = 7;
        int[] p ={6, 2, 1, 0, 2, 4, 3};
        int[] c = {3, 6, 6, 2, 3, 7, 6};
        String result=solution(n,p,c);
        System.out.println("result===>"+result);
    }
    static String solution(int n , int[]p, int[]c){
        String answer= "";
        int charge=0;

        int temp = 0; //재고
        int unit_price = 100; //단가
        int count = 0;
        int i;
        DecimalFormat df = new DecimalFormat("#######.00");

        for(i = 0 ; i < n ;i++){
            temp += p[i]; //재고
            System.out.println("temp==>"+temp);
            if(temp>=c[i]){
                charge += c[i]*unit_price;
                count=0;
                unit_price=100;//단가 초기화
                temp = temp-c[i];//납품
            }else{
                count++;
                if(count<3)
                    unit_price /= 2;
                if(count==3) {
                    i+=1;
                    break;
                }
            }

        }


        double average =(double)charge / i;
        average = 3.145;
        average = Math.round(average*100)/100.0; //반올림
        System.out.println(df.format(average));

        return null;
    }

}
