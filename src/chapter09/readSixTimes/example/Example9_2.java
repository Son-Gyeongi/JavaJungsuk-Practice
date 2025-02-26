package chapter09.readSixTimes.example;

/*
페이지 348
반올림이 필요하지 않다면 round() 를 사용하지 않고
단순히 1000 으로 곱하고 1000.0 으로 나누면 된다.
라는 말이 이해가 안된다. 그냥 계산 안 한거랑 같지 않나?
 */
public class Example9_2 {
    public static void main(String[] args) {
        // round() 계산
        double num = 90.7552;
        System.out.println("Math.round(" + num + ") = " + Math.round(num));

        // 소수점 넷째자리에서 반올림된 소수점 세 자리 값을 얻는다.
        num *= 1000;
        System.out.println("Math.round(" + num + ") = " + Math.round(num));
        System.out.println("Math.round(" + num + ")/1000.0 = " + Math.round(num) / 1000.0);

        System.out.println("Math.round(" + num + ")/1000 = " + Math.round(num) / 1000);

        // 반올림이 필요하지 않다면? -> 계산해도 그냥 주어진 val 값이랑 똑같은데...
        double val = 90.7552;
        val = val * 1000 / 1000.0;
        System.out.println("val = " + val);
    }
}
