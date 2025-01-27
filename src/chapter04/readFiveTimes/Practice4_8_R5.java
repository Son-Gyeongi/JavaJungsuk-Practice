package chapter04.readFiveTimes;

public class Practice4_8_R5 {
    public static void main(String[] args) {
        // 1부터 6 사이의 임의의 정수를 변수 value 에 저장
        int value = (int) (Math.random() * 6) + 1;

        System.out.println("value:" + value);
    }
}
