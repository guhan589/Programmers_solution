package test;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        list.removeIf(x -> x % 2 == 0);
        for (Integer integer : list) {
            System.out.println("integer = " + integer);
        }
    }
}
