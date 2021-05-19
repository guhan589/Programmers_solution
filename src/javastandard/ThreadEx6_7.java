package javastandard;

import javax.swing.*;

public class ThreadEx6_7 {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static String input = "";
    public static void main(String[] args) {
        inputNumberSingleThread();



        Thread thread = new InputNumberMultiThread();
        thread.start();
        inputNumber();
    }

    static void inputNumberSingleThread() { // singleThread

        inputNumber();
        for (int i : arr) {
            System.out.println("i = " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    static void inputNumber() {
        input = JOptionPane.showInputDialog("아무값을 입력하세요");
        System.out.println("입력한 값은 " + input + "입니다");
    }
}

class InputNumberMultiThread extends Thread {//멀티쓰레드
    public void run() {
        for (int i : ThreadEx6_7.arr) {
            System.out.println("i = " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
