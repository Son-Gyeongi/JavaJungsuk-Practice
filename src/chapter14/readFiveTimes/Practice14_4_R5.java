package chapter14.readFiveTimes;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우 모두 출력
 */
public class Practice14_4_R5 {
    public static void main(String[] args) {
        int[] dice = {1, 2, 3, 4, 5, 6};

        Arrays.stream(dice)
                .forEach(d1 -> IntStream.rangeClosed(1, 6)
                        .filter(d2 -> d1 + d2 == 6)
                        .forEach(d2 -> System.out.println("[" + d1 + "," + d2 + "]")));
    }
}
