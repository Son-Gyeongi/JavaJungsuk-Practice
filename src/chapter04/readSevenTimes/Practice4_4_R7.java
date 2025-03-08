package chapter04.readSevenTimes;

public class Practice4_4_R7 {
    public static void main(String[] args) {
        int sum = 0;

        int i = 1;
        for (int j = 1; sum < 100; i++, j *= -1) {
            sum += i * j;
        }

        System.out.println("i = " + i);
        System.out.println("sum = " + sum);
    }
}
