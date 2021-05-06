package javastandard;

public class ThreadEx15 {
    public static void main(String[] args) {
        ThreadEx15_1 te = new ThreadEx15_1();
        Thread th1 = new Thread(te, "*");
        Thread th2 = new Thread(te, "**");
        Thread th3 = new Thread(te, "***");

        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend();
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume();
            Thread.sleep(3000);
            th1.stop();
            th2.stop();
            Thread.sleep(2000);
            th3.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}

class ThreadEx15_1 extends Thread {

    public void run(){

        while (true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
