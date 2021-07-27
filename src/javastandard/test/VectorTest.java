package javastandard.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
//        Vector<Student> vector = new Vector<>();
/*        Vector vector = new Vector();
        vector.add(new Student("권구환",26, Gender.MEN) );
        vector.add(1);

        for (Object o : vector) {
            System.out.println("o = " + o);
        }*/

        List<Student> list = new ArrayList<Student>();
        list.add(new Student("권구환7", 60, Gender.GIRL));
        list.add(new Student("권구환1", 26, Gender.MEN));
        list.add(new Student("권구환2", 22, Gender.MEN));
        list.add(new Student("권구환3", 40, Gender.GIRL));
        list.add(new Student("권구환4", 12, Gender.MEN));

//        for (Student student : list) {
//            System.out.println("student = " + student);
//        }
    }

    static class Student implements Comparator<Student> {
        private String name;
        private int age;
        private Gender gender;

        private Student(String name, int age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
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

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.gender == o2.gender) {
                System.out.println("Equals");
                return 1;
            } else{
                System.out.println("else");
                return -1;
            }

        }
    }

    enum Gender{
        MEN, GIRL

    }
}
