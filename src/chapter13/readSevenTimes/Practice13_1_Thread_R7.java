package chapter13.readSevenTimes;

/*
Thread 클래스 구현하는 방법
 */
public class Practice13_1_Thread_R7 {
    public static void main(String[] args) {
        Thread13_1_T_R7 th1 = new Thread13_1_T_R7();
        th1.start();
    }
}

class Thread13_1_T_R7 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print('-');
        }
    }
}