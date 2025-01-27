package chapter04.readFiveTimes;

public class Practice4_9_R5 {
    public static void main(String[] args) {
        int num = 12345;
        int sum = 0;

        // 각 자리의 합 구하기
        while (num != 0) {
            sum += num % 10; // num 에서 마지막 자리
            num /= 10; // 다음 계산할 num
        }

        System.out.println("sum = " + sum);
    }
}
