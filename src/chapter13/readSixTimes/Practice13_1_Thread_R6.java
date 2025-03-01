package chapter13.readSixTimes;

public class Practice13_1_Thread_R6 {
    public static void main(String[] args) {
        Thread13_1_R6 th1 = new Thread13_1_R6();
        th1.start();
    }
}

class Thread13_1_R6 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++)
            System.out.print('-');
    }
}