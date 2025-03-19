package chapter14.readSevenTimes;

import java.util.Random;
import java.util.stream.IntStream;

public class Practice14_7_R7 {
    public static void main(String[] args) {
        IntStream infinity = new Random().ints(1, 46);

        infinity.distinct().limit(6).sorted().forEach(System.out::println);
    }
}
