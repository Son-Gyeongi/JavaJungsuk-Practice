package chapter13.readFiveTimes.example;

public class Ex13_10_R5 {
    public static void main(String[] args) {
        RunImplEx10 r = new RunImplEx10();
        Thread th1 = new Thread(r, "*"); // 쓰레드에 이름을 붙여준다.
        Thread th2 = new Thread(r, "**");
        Thread th3 = new Thread(r, "***");
        th1.start();
        th2.start();
        th3.start();

        try {
            // suspend(), resume(), stop() 은 Deprecated 되었다.
            Thread.sleep(2000); // main 쓰레드 중단
            th1.suspend(); // 쓰레드 th1을 잠시 중단시킨다.
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume(); // 쓰레드 th1이 다시 동작하도록 한다.
            Thread.sleep(3000);
            th1.stop(); // 쓰레드 th1을 강제종료시킨다.
            th2.stop();
            Thread.sleep(2000);
            th3.stop();
        } catch (InterruptedException e) {}
    }
}

class RunImplEx10 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}