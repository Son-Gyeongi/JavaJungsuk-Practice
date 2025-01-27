package chapter04.readFiveTimes;

public class Practice4_4_R5 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1, op = 1; true; i++, op *= -1) {
            int num = i * op;
            sum += num;

            if (sum >= 100) {
                System.out.println("i = " + i);
                break;
            }
        }
    }
}
