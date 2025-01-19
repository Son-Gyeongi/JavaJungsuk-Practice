package chapter13.readFourTimes;

public class Practice13_5 {
    static boolean stopped = false;

    public static void main(String[] args) {
        Thread5 th1 = new Thread5();
        th1.start();

        try {
            Thread.sleep(6 * 1000);
        } catch (Exception e) {}

        stopped = true; // 쓰레드를 정지시킨다.
        th1.interrupt(); // 일시정지 상태(Thread.sleep(3 * 1000);)에 있는 쓰레드를 깨운다.
        System.out.println("stopped");
    }
}

class Thread5 extends Thread {
    @Override
    public void run() {
        // Practice13_5.stopped 의 값이 false 인 동안 반복한다.
        for (int i = 0; !Practice13_5.stopped; i++) {
            System.out.println(i);

            try {
                Thread.sleep(3 * 1000); // 3초간 쉰다.
            } catch (Exception e) {}
        }
    }
}