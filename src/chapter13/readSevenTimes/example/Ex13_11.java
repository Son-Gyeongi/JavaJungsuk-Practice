package chapter13.readSevenTimes.example;

public class Ex13_11 {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx13_11 th1 = new ThreadEx13_11();
        Thread2Ex13_11 th2 = new Thread2Ex13_11();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {}

        System.out.print("소요 시간:" + (System.currentTimeMillis() - Ex13_11.startTime));
    }
}

class ThreadEx13_11 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("-"));
        }
    }
}

class Thread2Ex13_11 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("|"));
        }
    }
}