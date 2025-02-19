package chapter04.readSixTimes;

public class Practice4_4_R6 {
    public static void main(String[] args) {
        int i = 0, sum = 0;

        while (sum < 100) {
            i++;
            int temp = i % 2 == 0 ? -i : i;
            sum += temp;
        }

        System.out.println("i = " + i);
        System.out.println("sum = " + sum);
    }
}
