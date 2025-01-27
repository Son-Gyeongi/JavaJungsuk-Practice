package chapter04.readFiveTimes;

public class Practice4_2_R5 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 20; i++) {
            // 2 또는 3의 배수가 아닌 수의 총합
            if (!(i % 2 == 0 || i % 3 == 0))
                sum += i;
        }

        System.out.println("sum = " + sum);
    }
}
