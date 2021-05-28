package test;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "aaa", "bbb", "cccc", "adsdwqdo");
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
        Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
        for (String s : list) {
            System.out.println("s = " + s);
        }
    }

}
