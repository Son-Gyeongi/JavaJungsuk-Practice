package chapter14.readSevenTimes;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice14_4_R7 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 6);

        intStream.boxed()
                .flatMap(i1 -> IntStream.rangeClosed(1, 6)
                                                .mapToObj(i2 -> new int[]{i1, i2}))
                .filter(arr -> arr[0] + arr[1] == 6)
                .forEach(arr -> System.out.println(Arrays.toString(arr)));

        System.out.println();

        IntStream.rangeClosed(1, 6).boxed()
                .flatMap(i1 -> Stream.of(1, 2, 3, 4, 5, 6).map(i2 -> new int[]{i1, i2}))
                .filter(iArr -> iArr[0] + iArr[1] == 6)
                .forEach(iArr -> System.out.println(Arrays.toString(iArr)));
    }
}
