package chapter04.readFiveTimes;

public class Practice4_7_R5_answer {
    public static void main(String[] args) {
        String str = "12345";
        int sum = 0;

        // 숫자로 이루어진 문자열 str 의 각 자리의 합 출력
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }

        System.out.println("sum=" + sum);
    }
}
