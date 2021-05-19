package javastandard;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SeasonTest {
    /**자바의 정석 p696
     * chaptor 열거형*/
    
    
    public static void main(String[] args) {
//        Season season = Season.봄;
//        Season[] list = Season.values();
//        Season s = Season.valueOf("봄");
//        System.out.println("s = " + s);
//
//        Direction direction = Direction.EAST;
//        System.out.println("direction = " + direction.getValue());
//
//        System.out.println("direction.of(0) = " + direction.of(4));

        /*int[] arr = {2, 50, 20, 3, 1, -1};
        List list = Arrays.asList(arr);*/

        String[] str = {"김혁규", "박성준", "정두화", "권구환", "차상현", "이두희"};
        List<String> list = Arrays.asList(str);


        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int value = o1.compareTo(o2);
                System.out.print("o1=>" + o1 + ", o2=>" + o2);
                System.out.println("value = " + value);

                return value;
            }
        });
        for (String s : list) {
            System.out.println("ss = " + s);
        }

        System.out.println("Transportation.BUS.fare(100) = " + Transportation.BUS.fare(100));
    }
    enum Direction{
        EAST(10), WEST(-1), SOUTH(20), NORTH(100);
        private static final Direction[] arr = Direction.values(); 
        private final int value;
        Direction(int i) {
            value = i;
        }

        public Direction of(int index) {
            if (index >0 && index <= arr.length) {
                return arr[index - 1];
            }else
                throw new IllegalStateException("Invalid value:" + index);
            
        }
        public int getValue() {
            return value;
        }
    }

    enum Transportation {
        BUS(100){
            int fare(int distance) {
                return distance * BASIC_FARE;
            }
        }, TRAIN(150){
            int fare(int distance) {
                return distance * BASIC_FARE;
            }
        },SHIP(100){
            int fare(int distance) {
                return distance * BASIC_FARE;
            }
        }, AIRPLANE(300){
            int fare(int distance) {
                return distance * BASIC_FARE;
            }
        };

        
        protected final int BASIC_FARE;
        private Transportation(int i) {
            BASIC_FARE = i;
        }

        abstract int fare(int distance);
    }
    
}
