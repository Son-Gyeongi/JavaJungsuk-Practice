package chapter14.readSevenTimes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Practice14_6_R7 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        int max = Stream.of(strArr).mapToInt(String::length).max().getAsInt();
        System.out.println(max);

        /*
        mapToInt(String::length) 는 IntStream(기본형 스트림) 으로
        IntStream 에는 Comparator.reverseOrder()를 적용할 수 없다.
        Comparator.reverseOrder()는 Comparator<T>로 객체 스트림에서만 사용 가능

        Arrays.stream(strArr)
                .mapToInt(String::length)
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .forEach(System.out::println);
        */

        Arrays.stream(strArr)
                .map(String::length)
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .forEach(System.out::println);

        Arrays.stream(strArr)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(1)
                .forEach(System.out::println);
    }
}
