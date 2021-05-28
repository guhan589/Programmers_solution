package javastandard;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx5 {
    public static void main(String[] args) {
        /**
         * Supplier: 매개변수 X , return O
         * Consumer: 매개변수O, return X
         * Prdicate: 매개변수 O, return O
         * Function:매개변수 O, return O (조건식을 표현할 떄 사용함)
         * 함수형 인터페이스를 사용하는 이유는 라담식 접근 되기 때문
         * */
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i % 2 == 0;
        Function<Integer, Integer> f = i -> i / 10 * 10;

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println("makeRandomList="+list);
        printEvenNum(p, c, list);
        List<Integer> newList = doSomthing(f, list);
        
        System.out.println(newList);

    }

    static <T> List<T> doSomthing(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<T>(list.size());

        //list에 담겨있는 값을 newList에 추가
        newList.addAll(list);
//        for (T t : list) {
//            newList.add(t);
//        }
        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        
        //makeRandomList를 통해 10개의 랜덤 값을 담은 list에 짝수인것을 출력하는 메서드
        System.out.print("[");

        for (T t : list) {
            if (p.test(t)) { //Predicate p = i->i%2==0
                c.accept(t); //Consumer c = System.out.print(i+", ");
            }
        }
        System.out.println("]");

    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        //Supplier은 매개변수 O ,return X
        //10번 반복으로 1~100까지 랜덤 수를 list에 추가
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }
}
