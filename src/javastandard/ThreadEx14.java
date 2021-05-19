package javastandard;

import javax.swing.*;
/**
 * 쓰레드가 동작한 후 sleep 메서드 호출로 쓰레드가 잠시 멈춰있을경우
 * 이 상태에서 interrupt가 발생하면 InterruptedException가 발생한다.
 * 또한, InterruptedException가 발생시 interrupt 상태값이 false로 초기화가 되어
 * 쓰레드가 멈추지 않고 계속 실행된다.
 * */
public class ThreadEx14 {
    public static void main(String[] args) {
        Thread th1 = new ThreadEx14_1();
        th1.start();
        String input = JOptionPane.showInputDialog("아무값이나 입력하세요.");
        System.out.println("입력하신 값은" + input + "입니다");
        th1.interrupt();
        System.out.println("th1.isInterrupted() = " + th1.isInterrupted());

    }
}

class ThreadEx14_1 extends Thread {
    public void run() {
        int i = 10;
        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("ThreadEx14_1.end");
    }
}
