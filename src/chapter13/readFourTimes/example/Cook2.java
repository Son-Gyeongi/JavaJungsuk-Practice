package chapter13.readFourTimes.example;

public class Cook2 implements Runnable {
    private Table2 table;

    public Cook2(Table2 table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            int idx = (int) (Math.random() * table.dishNum());
            table.add(table.dishNames[idx]);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
    }
}
