package chapter13.readSevenTimes;

/*
Runnable 인터페이스 구현하는 방법
 */
public class Practice13_1_Runnable_R7 {
    public static void main(String[] args) {
//        Runnable runnable = new Thread13_1_R_R7();
//        Thread th1 = new Thread(runnable);
        Thread th1 = new Thread(new Thread13_1_R_R7()); // 위 두 줄을 한 줄로 변경
        th1.start();
    }
}

class Thread13_1_R_R7 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print('-');
        }
    }
}