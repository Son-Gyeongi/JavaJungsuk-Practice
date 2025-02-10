package chapter13.readFiveTimes;

public class Practice13_5_R5 {
    static boolean stopped = false;

    public static void main(String[] args) {
        Thread13_5_R5 th1 = new Thread13_5_R5();
        th1.start();
        
        // 쓰레드 th1 을 생성해서 실행시킨 다음 6초 후에 정지시키는 코드
        try {
            Thread.sleep(6 * 1000); // 6초
        } catch (Exception e) {}

        stopped = true; // 쓰레드를 정지시킨다.
        th1.interrupt(); // sleep() 일시정지 상태에 있는 쓰레드를 깨운다.
        System.out.println("stopped");
    }
}

class Thread13_5_R5 extends Thread {
    @Override
    public void run() {
        // Practice13_5_R5.stopped 의 값이 false 인 동안 반복한다.
        for (int i = 0; !Practice13_5_R5.stopped; i++) {
            System.out.println(i);
            
            try {
                Thread.sleep(3 * 1000); // 3초
            } catch (Exception e) {}
        }
    }
}