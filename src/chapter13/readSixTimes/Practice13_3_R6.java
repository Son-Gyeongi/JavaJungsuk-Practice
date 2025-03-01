package chapter13.readSixTimes;

public class Practice13_3_R6 {
    public static void main(String[] args) {
        Thread13_3_R6 th1 = new Thread13_3_R6();
        th1.run(); // Thread13_3_R6 클래스의 메서드를 호출한 셈
//        th1.start();

        for (int i = 0; i < 10; i++) {
            System.out.print(i);

            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }
    }
}

class Thread13_3_R6 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);

            try {
                Thread.sleep(10);
            } catch (Exception e) {}
        }
    }
}