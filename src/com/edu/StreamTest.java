package com.edu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("권구환", "유혜연", "조아라", "김지은");
        Stream<String> stream = strings.stream();
        stream.forEach(name-> System.out.println("name = " + name));

        List<Student> students = Arrays.asList(new Student("권구환", 95), new Student("유혜현", 100));
        Stream<Student> stream1 = students.stream();
        stream1.forEach(s-> System.out.println("s.getName() = " + s.getName() + "s.getScore()="+s.getScore()));
    }



    public static class Student
    {
        String name;
        int score;
        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }


    }
}

