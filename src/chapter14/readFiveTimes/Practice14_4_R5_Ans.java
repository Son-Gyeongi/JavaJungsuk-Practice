package chapter14.readFiveTimes;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우 모두 출력
 */
public class Practice14_4_R5_Ans {
    public static void main(String[] args) {
        Stream<Integer> dice = IntStream.rangeClosed(1, 6).boxed();

        // flatMap 을 이용해서 Stream<int[]> 을 만든다.
        dice.flatMap(i -> Stream.of(1, 2, 3, 4, 5, 6)
                        .map(i2 -> new int[]{i, i2}))
                .filter(iArr -> iArr[0] + iArr[1] == 6)
                .forEach(iArr -> System.out.println(Arrays.toString(iArr)));
    }
}
