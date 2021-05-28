package javastandard;

import java.util.ArrayList;
import java.util.List;

public class ThreadWaitEx1 {

    /**
     * add와 remove 메서드에 동기화 처리를 하지 않아 예외발생 가능성이 있음
     * */
    public static void main(String[] args) throws Exception{
        Table table = new Table();
        new Thread(new Cook(table), "COOK1").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();
        Thread.sleep(100);
        System.exit(0);
        
    }
}

class Customer implements Runnable {
    private Table table;
    private String food;

    public Customer(Table table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        String name = Thread.currentThread().getName();

        if (eatFood()) {
            System.out.println(name + " eat a" + food);
        }else{
            System.out.println(name + " failt to eat" + food);
        }
    }
    boolean eatFood() {
        return table.remove(food);
    }
}

class Cook implements Runnable {

    private Table table;

    public Cook(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            int index = (int)(Math.random() * table.dishNum());
            table.add(table.dishName[index]);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Table {

    String[] dishName = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;

    private List<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        if (dishes.size() >= MAX_FOOD) {
            return;
        }

        dishes.add(dish);
        notify(); // 기다리고 있는 customer 스레드를 깨운다.
        System.out.println("Dishes:" + dishes.toString());
    }
    public boolean remove(String dishname) {
        synchronized (this) {
            String name = Thread.currentThread().getName();
            while (dishes.size() == 0) {

                System.out.println(name + " is waiting.");
                try {
                    wait();//customer 스레드를 기다리게 한다
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace(); 
                }

            }
            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishname.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify();
                        return true;
                    }
                }
                try {
                    System.out.println(name + "is waiting.");
                    wait();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public int dishNum() {
        return dishName.length;
    }
}
