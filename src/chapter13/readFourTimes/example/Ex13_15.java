package chapter13.readFourTimes.example;

public class Ex13_15 {
    public static void main(String[] args) throws Exception {
        Table2 table = new Table2();

        /*
        동기화를 더 효율적이게 하려면 wait() 과 notify() 를 사용한다.

        Cook 쓰레드와 Customer 쓰레드가 Table 인스턴스를 같이 공유한다.
        그래서 동기화가 필요하다.
         */
        new Thread(new Cook2(table), "COOK").start();
        new Thread(new Customer2(table, "donut"), "CUST1").start();
        new Thread(new Customer2(table, "burger"), "CUST2").start();
        Thread.sleep(2000);
        System.exit(0);
    }
}
