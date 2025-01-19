package chapter13.readFourTimes;

public class Practice13_1_Thread {
    public static void main(String[] args) {
        Thread1_T th1 = new Thread1_T();
        th1.start();
    }
}

// Thread 클래스 상속 받아서 쓰레드 구현
class Thread1_T extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print('-');
        }
    }
}