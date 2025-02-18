package chapter03.readSixTimes;

public class Practice3_6_R6 {
    public static void main(String[] args) {
        int fahrenheit = 100; // 화씨
        float celcius = (int) ((5 / (float) 9 * (fahrenheit - 32)) * 100 + 0.5) / 100f; // 섭씨

        System.out.println("Fahrenheit:" + fahrenheit);
        System.out.println("Celcius:" + celcius);
    }
}
