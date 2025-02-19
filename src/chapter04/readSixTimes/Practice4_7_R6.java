package chapter04.readSixTimes;

public class Practice4_7_R6 {
    public static void main(String[] args) {
        String str = "12345";
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sum += c - '0';
        }

        System.out.println("sum=" + sum);
    }
}
