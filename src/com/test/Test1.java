package com.test;

public class Test1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
        thread1.start();
        thread2.start();

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("threadGroup = " + threadGroup);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("<<main end>>");
    }
}

class Thread1 extends Thread {
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
        System.out.print("<<th1 end>>");
    }
}
class Thread2 extends Thread {
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
        System.out.print("<<th2 end>>");
    }
}
