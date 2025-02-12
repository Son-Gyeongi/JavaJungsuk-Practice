package chapter14.readFiveTimes;

import java.util.Random;
import java.util.stream.IntStream;

/*
임의의 로또번호(1~45)를 정렬해서 출력
 */
public class Practice14_7_R5 {
    public static void main(String[] args) {
        /*
        난수 스트림에서 먼저 사이즈 6을 제시하면 중복된 값이 들어올 수 있다.
        IntStream lotto1 = new Random().ints(6,1, 46);
        lotto1.distinct().sorted().forEach(System.out::println);
         */

        IntStream lotto2 = new Random().ints(1, 46);
        lotto2.distinct().limit(6).sorted().forEach(System.out::println);
    }
}
