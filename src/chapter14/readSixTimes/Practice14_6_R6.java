package chapter14.readSixTimes;

import java.util.Comparator;
import java.util.stream.Stream;

public class Practice14_6_R6 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        int maxSize = Stream.of(strArr).mapToInt(String::length).max().getAsInt();
        System.out.println(maxSize);

        Stream.of(strArr)
                .map(String::length)
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .forEach(System.out::println);

        // 가장 긴 문자열 자체 출력
        Stream.of(strArr)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(1)
                .forEach(System.out::println);
    }
}
