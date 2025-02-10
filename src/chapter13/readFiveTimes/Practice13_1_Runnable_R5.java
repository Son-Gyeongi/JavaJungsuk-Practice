package chapter13.readFiveTimes;

public class Practice13_1_Runnable_R5 {
    public static void main(String[] args) {
        Thread th1 = new Thread(new Runnable13_1_R5());
        th1.start();
    }
}

class Runnable13_1_R5 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++)
            System.out.print('|');
    }
}