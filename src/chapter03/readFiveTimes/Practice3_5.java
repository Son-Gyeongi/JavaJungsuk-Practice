package chapter03.readFiveTimes;

public class Practice3_5 {
    public static void main(String[] args) {
        int num = 10;
        // 삼항 연산자
        System.out.println(num > 0 ? "양수" : (num == 0 ? "0" : "음수"));
    }
}
