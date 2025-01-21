package chapter13.readFourTimes.example;

public class Customer2 implements Runnable {
    private Table2 table;
    private String food;

    public Customer2(Table2 table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            String name = Thread.currentThread().getName();

            table.remove(food); // 음식 소비
            System.out.println(name + " ate a " + food);
        }
    }
}
