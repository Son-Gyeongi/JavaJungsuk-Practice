package chapter04.readFourTimes;

public class Practice4_3 {
    public static void main(String[] args) {
        int sum = 0, totalSum = 0;

        for (int i = 1; i <= 10; i++) {
            sum += i;
            totalSum += sum;
        }

        System.out.println("totalSum = " + totalSum);
    }
}
