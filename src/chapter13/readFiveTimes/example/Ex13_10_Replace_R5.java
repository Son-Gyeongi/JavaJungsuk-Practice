package chapter13.readFiveTimes.example;

/*
suspend(), resume(), stop() 은 Deprecated 된 메서드 실행할 수 없어서
다른 방법을 사용해보자.
 */
public class Ex13_10_Replace_R5 {
    public static void main(String[] args) {
        RunImplEx10_Replace r1 = new RunImplEx10_Replace();
        RunImplEx10_Replace r2 = new RunImplEx10_Replace();
        RunImplEx10_Replace r3 = new RunImplEx10_Replace();
        Thread th1 = new Thread(r1, "*");
        Thread th2 = new Thread(r2, "**");
        Thread th3 = new Thread(r3, "***");
        th1.start();
        th2.start();
        th3.start();

        try {
            // suspend(), resume(), stop() 은 Deprecated 되었다.
            Thread.sleep(2000); // main 쓰레드 중단
            r1.suspend(); // 쓰레드 th1을 잠시 중단시킨다.
            Thread.sleep(2000);
            r2.suspend();
            Thread.sleep(3000);
            r1.resume(); // 쓰레드 th1이 다시 동작하도록 한다.
            Thread.sleep(3000);
            r1.stop(); // 쓰레드 th1을 강제종료시킨다.
            /*
            코드 바뀌기 전 따라서 r2가 종료되지 않는 이유는
            r2.wait()에서 깨어나지 않았기 때문이며, 이를 해결하려면 notifyAll()을 적절히 사용해야 함.
             */
            r2.stop();
            Thread.sleep(2000);
            r3.stop();
        } catch (InterruptedException e) {}
    }
}

class RunImplEx10_Replace implements Runnable {
    private volatile boolean suspended = false; // 일시정지 상태
    private volatile boolean stopped = false; // 멈춤 상태

    public void suspend() {
        suspended = true;
    }

    public void resume() {
        synchronized (this) {
            suspended = false;
            notifyAll(); // 모든 대기 중인 쓰레드가 깨어남
        }
    }

    public void stop() {
        synchronized (this) {
            stopped = true;
            suspended = false; // 🔹 멈출 때 suspend를 false로 만들어 wait()에서 빠져나오게 함
            notifyAll();
        }
    }

    @Override
    public void run() {
        while (!stopped) {
            synchronized (this) {
                while (suspended && !stopped) { // 일시정지 ture  // 🔹 stopped 상태도 확인하도록 수정
                    try {
                        wait(); // suspend() 되면 대기
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (stopped) break; // 🔹 stopped가 true이면 루프 종료

            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 종료됨");
    }
}