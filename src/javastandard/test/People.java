package javastandard.test;

import java.util.Arrays;
import java.util.List;

public class People {
    private String name;
    private int age;
    private int gendar;

    public People(String name, int age, int gendar) {
        this.name = name;
        this.age = age;
        this.gendar = gendar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public int getGendar() {
        return gendar;
    }

    public void setGendar(int gendar) {
        this.gendar = gendar;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gendar=" + gendar +
                '}';
    }

    public static List<People> getPeopleList() {
        return Arrays.asList(
                new People("홍길동", 17, 1),
                new People("홍길자", 18, 1),
                new People("홍길순", 15, 2),
                new People("홍길길", 17, 1),
                new People("홍길락", 10, 2)
        );
    }
}
