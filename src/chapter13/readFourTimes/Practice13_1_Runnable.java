package chapter13.readFourTimes;

public class Practice13_1_Runnable {
    public static void main(String[] args) {
        Runnable r1 = new Thread1_R();
        Thread th1 = new Thread(r1);
//        Thread th1 = new Thread(new Thread1_R()); // 위 코드 한줄로
        th1.start();
    }
}

// Runnable 인터페이스 구현
class Thread1_R implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print('-');
        }
    }
}