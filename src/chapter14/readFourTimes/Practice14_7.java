package chapter14.readFourTimes;

import java.util.Random;
import java.util.stream.IntStream;

public class Practice14_7 {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints(1, 46);
        intStream.distinct().limit(6).sorted().forEach(System.out::println);
//        intStream.limit(6).sorted().forEach(System.out::println);
    }
}
