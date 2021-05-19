package javastandard;

public class ThreadEx10 implements Runnable {
    static boolean autosave = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadEx10());
//        thread.setDaemon(true);
        thread.start();

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i = " + i);
            if (i == 5) {
                autosave = true;
            }

        }
        System.out.println("end");
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (autosave) {
                autosave();
            }
        }

    }

    public void autosave() {
        System.out.println("작업파일이 자동저장 되었습니다.");
    }
}
