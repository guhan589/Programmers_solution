package javastandard.test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 강의주소:https://www.youtube.com/watch?v=x8-p7Hcxpr8
 * */
//sadsadasdsads
public class StreamTest1 {
    public static void main(String[] args) {
        /*List<People> femaleList = People.getPeopleList().stream().filter(people -> people.getGendar() == 2).collect(Collectors.toList());
        System.out.println("여성목록");
        femaleList.forEach(System.out::println);

        List<People> sortedList = People.getPeopleList().stream().sorted(Comparator.comparing(People::getAge)).collect(Collectors.toList());
        System.out.println("나이순 목록");
        sortedList.forEach(System.out::println);*/

        People.getPeopleList().forEach(System.out::println);



    }
}
