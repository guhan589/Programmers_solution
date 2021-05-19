package javastandard;

import javax.swing.*;

/**
 * 쓰레드가 동작하면 사용자으로부터 값을 입력받기 전까지 쓰레드가 동작되며
 * 값을 입력받으면 인터럽트를 true로 상태값을 변경하여 쓰레드 동작을 멈춘다.
 * */
public class ThreadEx13 {
    public static void main(String[] args) {
        Thread th1 = new ThreadEx13_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
        System.out.println("입력하신 값은" + input + "입니다");
        th1.interrupt();
        
    }

}

class ThreadEx13_1 extends Thread {

    public void run() {
        int i = 10;
        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);
            for(long x = 0;x <10000000000L;x++)
                ;
        }
        System.out.println("Count End");
    }
}
