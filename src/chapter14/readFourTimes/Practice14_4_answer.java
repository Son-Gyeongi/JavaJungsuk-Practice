package chapter14.readFourTimes;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice14_4_answer {
    public static void main(String[] args) {
        Stream<Integer> dice = IntStream.rangeClosed(1, 6).boxed();

        dice.flatMap(i1 -> Stream.of(1, 2, 3, 4, 5, 6).map(i2 -> new int[]{i1, i2}))
                // .peek(iArr -> System.out.println(Arrays.toString(iArr)))
                .filter(iArr -> iArr[0] + iArr[1] == 6)
                .forEach(iArr -> System.out.println(Arrays.toString(iArr)));
    }
}
