package chapter13.readSixTimes;

public class Practice13_5_R6 {
    static boolean stopped = false;

    public static void main(String[] args) {
        Thread13_5_R6 th1 = new Thread13_5_R6();
        th1.start();

        try {
            Thread.sleep(6 * 1000); // 6초
        } catch (Exception e) {}

        stopped = true; // Thread13_5_R6 쓰레드를 정지시킨다.
        th1.interrupt(); // sleep() 에 의해 일시정지 상태에 있는 쓰레드를 깨운다. 지연없이 즉시 쓰레드 멈춘다.
        System.out.println("stopped");
    }
}

class Thread13_5_R6 extends Thread {
    @Override
    public void run() {
        // Practice13_5_R6.stopped 의 값이 false 인 동안 반복한다.
        for (int i = 0; !Practice13_5_R6.stopped; i++) {
            System.out.println(i);

            try {
                Thread.sleep(3 * 1000); // 3초
            } catch (Exception e) {} // InterruptedException
        }
    }
}