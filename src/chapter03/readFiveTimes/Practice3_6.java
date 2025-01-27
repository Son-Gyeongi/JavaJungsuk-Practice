package chapter03.readFiveTimes;

public class Practice3_6 {
    public static void main(String[] args) {
        int fahrenheit = 100;
        // 화씨(Fahrenheit) 에서 섭씨(Celcius)로 변환하는 공식 -> C = 5/9 * (F-32)
        // 소수점 셋째자리에서 반올림
        float celcius = (int) ((5 / (float) 9 * (fahrenheit - 32)) * 100 + 0.5) / 100f;

        System.out.println("Fahrenheit = " + fahrenheit);
        System.out.println("Celcius = " + celcius);
    }
}
