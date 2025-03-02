package chapter14.readSixTimes;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice14_4_R6 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 6);
        intStream.forEach(i -> IntStream.rangeClosed(1, 6)
                .filter(i2 -> i + i2 == 6)
                .forEach(i2 -> System.out.println("[" + i + ", " + i2 + "]")));

        System.out.println();

        Stream<Integer> dice = IntStream.rangeClosed(1, 6).boxed();
        dice.flatMap(i -> Stream.of(1, 2, 3, 4, 5, 6).map(i2 -> new int[]{i, i2}))
                .filter(iArr -> iArr[0] + iArr[1] == 6)
                .forEach(iArr -> System.out.println(Arrays.toString(iArr)));
    }
}
