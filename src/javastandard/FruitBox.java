package javastandard;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * java의정석 p682
 * chaptor 와일드 카드
 * */
class Fruit {
    String name;
    int weight;

    public Fruit(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}

class Apple extends Fruit {
    public Apple(String name, int weight) {
        super(name, weight);
    }
}

class Grape extends Fruit {

    public Grape(String name, int weight) {
        super(name, weight);
    }
}

class AppleComp implements Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
        return o2.weight - o1.weight;
    }

}

class GrapeComp implements Comparator<Grape> {

    @Override
    public int compare(Grape o1, Grape o2) {
        return o2.weight - o1.weight;
    }
}

class FruitComp implements Comparator<Fruit> {

    @Override
    public int compare(Fruit o1, Fruit o2) {
        return o2.weight - o1.weight;
    }
}

class FruitBox<T extends Fruit> extends Box<T>{
}


class Box<T> {
    ArrayList<T> list = new ArrayList<T>();

    void add(T item) {
        list.add(item);

    }

    T get(int i) {
        return list.get(i);
    }

    ArrayList<T> getList() {
        return list;
    }
    int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return "Box{" +
                "list=" + list +
                '}';
    }


}
class FruitBoxMain {
    public static void main(String[] args) {



        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();

        appleBox.add(new Apple("GreenApple",300));
        appleBox.add(new Apple("YellowApple",500));
        appleBox.add(new Apple("RedApple",100));

        grapeBox.add(new Grape("GreenGrape", 1000));
        grapeBox.add(new Grape("YellowGrape", 900));
        grapeBox.add(new Grape("RedGrape", 700));

        Collections.sort(appleBox.getList(), new AppleComp());
        Collections.sort(grapeBox.getList(), new GrapeComp());
        System.out.println("appleBox(AppleComp) = " + appleBox);
        System.out.println("grapeBox(GrapeComp) = " + grapeBox);

        Collections.sort(appleBox.getList(), new FruitComp());
        Collections.sort(grapeBox.getList(), new FruitComp());

        System.out.println("appleBox(FruitComp) = " + appleBox);
        System.out.println("grapeBox(FruitComp) = " + grapeBox);


    }

}