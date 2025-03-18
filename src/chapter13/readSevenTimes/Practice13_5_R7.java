package chapter13.readSevenTimes;

public class Practice13_5_R7 {
    static boolean stopped = false;

    public static void main(String[] args) {
        Thread13_5_R7 th1 = new Thread13_5_R7();
        th1.start();

        try {
            Thread.sleep(7 * 1000);
        } catch (Exception e) {}

        stopped = true; // th1 쓰레드를 정지시킨다.
        th1.interrupt(); // sleep()에 의해 일시정지 상태에 있는 쓰레드를 깨운다. -> 쓰레드 실행 즉시 종료된다.
        System.out.println("stopped");
    }
}

class Thread13_5_R7 extends Thread {
    @Override
    public void run() {
        // Practice13_5_R7.stopped 의 값이 false 인 동안 반복
        for (int i = 0; !Practice13_5_R7.stopped; i++) {
            System.out.println(i);

            try {
                Thread.sleep(3 * 1000);
            } catch (Exception e) {}
        }
    }
}