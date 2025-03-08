package chapter04.readSevenTimes;

public class Practice4_3_R7 {
    public static void main(String[] args) {
        int sum = 0, totalSum = 0;

        for (int i = 1; i <= 10; i++) {
            sum += i;
            totalSum += sum;
        }

        System.out.println("totalSum = " + totalSum);
    }
}
