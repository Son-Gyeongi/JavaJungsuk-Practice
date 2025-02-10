package chapter13.readFiveTimes.example;

public class Ex13_8_R5 {
    public static void main(String[] args) {
        ThreadEx13_8_1_R5 th1 = new ThreadEx13_8_1_R5();
        ThreadEx13_8_2_R5 th2 = new ThreadEx13_8_2_R5();
        th1.start(); th2.start();

        try {
            th1.sleep(2000); // main 쓰레드가 2초 쉰다. Thread.sleep(2000) 으로 적는 게 바람직. static 이니까
        } catch (InterruptedException e) {}

        System.out.print("<<main 종료>>");
    }
}


class ThreadEx13_8_1_R5 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) System.out.print("-");
        System.out.print("<<th1 종료>>");
    }
}

class ThreadEx13_8_2_R5 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) System.out.print("|");
        System.out.print("<<th2 종료>>");
    }
}