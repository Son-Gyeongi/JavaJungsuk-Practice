package chapter13.readSevenTimes;

public class Practice13_3_R7 {
    public static void main(String[] args) {
        Thread13_3_R7 th1 = new Thread13_3_R7();
//        th1.run(); // Thread13_3_R7 클래스의 메서드를 그냥 호출한 것이다.
        th1.start(); // start() 테스트 - 숫자가 섞여서 출력될 것이다.

        for (int i = 0; i < 10; i++) {
            System.out.print(i);

            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }
}

class Thread13_3_R7 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);

            try {
                Thread.sleep(50);
            } catch (Exception e) {}
        }
    }
}