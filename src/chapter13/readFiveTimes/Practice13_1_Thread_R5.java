package chapter13.readFiveTimes;

public class Practice13_1_Thread_R5 {
    public static void main(String[] args) {
        Thread13_1_R5 th1 = new Thread13_1_R5();
        th1.start();
    }
}

class Thread13_1_R5 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++)
            System.out.print('-');
    }
}