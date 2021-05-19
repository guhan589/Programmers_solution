package javastandard;

public class ThreadEx4_5 {
    static long startTime = 0;

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();
        operation();

        startTime = System.currentTimeMillis();

        Thread thread = new ThreadOpertaion();
        thread.start();
    }
    static void operation(){
        System.out.println("");
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
        System.out.print("time1==>" + (System.currentTimeMillis() - startTime));
    }

}

class ThreadOpertaion extends Thread {

    public void run() {
        System.out.println("");
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }

        System.out.println("time--->" + (System.currentTimeMillis() - ThreadEx4_5.startTime));
    }


}
