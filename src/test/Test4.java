package test;

import java.util.Arrays;
import java.util.Collections;

public class Test4 {
    public static void main(String[] args) {
        String[] str = {"hello", "Hello", "123a"};
        Arrays.sort(str, Collections.reverseOrder());

        for (String s : str) {
            System.out.println("s = " + s);
        }
    }
}
