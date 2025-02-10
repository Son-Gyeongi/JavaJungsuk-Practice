package chapter13.readFiveTimes;

public class Practice13_3_R5 {
    public static void main(String[] args) {
        Thread13_3_R5 th1 = new Thread13_3_R5();
        //th1.run(); // Thread13_3_R5 클래스의 메서드를 호출한 것이다.
        th1.start(); // 쓰레드 실행

        for (int i = 0; i < 10; i++)
            System.out.print(i);
    }
}

class Thread13_3_R5 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++)
            System.out.print(i);
    }
}