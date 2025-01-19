package chapter13.readFourTimes.exercise;

import java.util.ArrayList;

public class Table2 {
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    /*
    테이블에 음식 추가
    요리사는 테이블이 가득 차면 대기(wait())하고, 음식을 추가하고 나면 손님에게 통보(notify())한다.
     */
    public synchronized void add(String dish) {
        // 테이블에 음식이 꽉찬 경우
        while (dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is wating.");
            try {
                wait(); // COOK 쓰레드를 기다리게 한다.
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }

        // 테이블에 음식을 추가한다.
        dishes.add(dish);
        notify(); // 기다리고 있는 CUST 를 깨운다.
        System.out.println("Dishes:" + dishes.toString());
    }

    /*
    테이블에 음식 소비
    손님은 음식이 없으면 대기(wait())하고, 음식을 먹고나면 요리사에게 통보(notify())한다.
    원하는 음식이 없는 경우에도 대기(wait())
     */
    public void remove(String dishName) {
        synchronized (this) {
            String name = Thread.currentThread().getName();

            // 테이블에 음식이 없는 경우
            while (dishes.isEmpty()) { // dishes.size() == 0
                System.out.println(name + "is waiting");
                try {
                    // 음식이 없으면 쓰레드는 lock 을 반납하고 대기실에 들어간다.
                    wait(); // CUST 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }

            // 테이블에 음식이 있는 경우
            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i); // 음식 소비
                        notify(); // 잠자고 있는 COOK 을 깨운다.
                        return;
                    }
                }

                // 원하는 음식이 없는 경우
                try {
                    System.out.println(name + " is waiting.");
                    wait(); // 원하는 음식이 없는 CUST 쓰레드를 기다리게 한다.
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
        }
    }

    public int dishNum() {
        return dishNames.length;
    }
}
