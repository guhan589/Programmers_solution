package javastandard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWaitEx4 {
    public static void main(String[] args) throws InterruptedException {
        TableEx4 table = new TableEx4();
        new Thread(new CookEx4(table),"COOK1").start();
        new Thread(new CustomerEx4(table,"donut"),"CUST1").start();
        new Thread(new CustomerEx4(table,"burger"),"CUST2").start();


        Thread.sleep(2000);
        System.exit(0);

    }
}
class TableEx4 {
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishse = new ArrayList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition forCook = lock.newCondition();
    private Condition forCust = lock.newCondition();

    public void add(String dish) {
        lock.lock();

        try {
            while (dishse.size() >= MAX_FOOD) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting");

                try {
                    forCook.await();
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dishse.add(dish);
                forCust.signal();
                System.out.println("Dishes:" + dishse.toString());
            }
        }finally {
            lock.unlock();

        }
    }

    public void remove(String dishName) {
        lock.lock();
        String name = Thread.currentThread().getName();
        try{
            while (dishse.size() == 0) {
                System.out.println(name + " is wating.");
                try {
                    forCust.await();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (true) {
                for (int i = 0; i < dishse.size(); i++) {
                    if (dishName.equals(dishse.get(i))) {
                        dishse.remove(i);
                        forCust.signal();
                        return;
                    }
                }
                try {
                    System.out.println(name + " is waiting.");
                    forCust.await();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            lock.unlock();
        }
    }
    public int dishNum() {
        return dishNames.length;
    }
}

class CustomerEx4 implements Runnable {

    private TableEx4 table;
    private String food;

    public CustomerEx4(TableEx4 table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                String name = Thread.currentThread().getName();
                table.remove(food);
                System.out.println(name + "eat a " + food);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CookEx4 implements Runnable {

    private TableEx4 table;

    public CookEx4(TableEx4 table) {
        this.table = table;
    }
    @Override
    public void run() {
        while (true) {
            int index = (int) (Math.random() * table.dishNum());
//            System.out.println("index = " + index);
            table.add(table.dishNames[index]);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}


