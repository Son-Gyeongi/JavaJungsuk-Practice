package chapter14.readSevenTimes;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Practice14_4_R7 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 6);

        intStream.boxed()
                .flatMap(i1 -> IntStream.rangeClosed(1, 6)
                                                .mapToObj(i2 -> new int[]{i1, i2}))
                .filter(arr -> arr[0] + arr[1] == 6)
                .forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}
