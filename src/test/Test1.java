package test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5};
//        int[] b = a.clone();
//        for (int i : b) {
//            System.out.println("i = " + i);
//        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        list2.addAll(list1);
        list1.add(0);
        for (Integer integer : list2) {
            System.out.println("integer = " + integer);
        }
    }
}
