package chapter14.readThreeTimes;

import java.util.Comparator;
import java.util.stream.Stream;

public class Practice14_6 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};
        Stream<String> strStream = Stream.of(strArr);

        //  가장 긴 문자열 자체를 출력하려면
        strStream.sorted(Comparator.comparingInt(String::length).reversed())
                .limit(1).forEach(System.out::println);

        /*
        문제 답
        strStream.map(String::length)
                .sorted(Comparator.reverseOrder())
                .limit(1).forEach(System.out::println);
         */

        /*
        내가 푼거 - 나도 잘 풀었음
        int max = strStream.mapToInt(String::length).max().getAsInt();
        System.out.println("max = " + max);
         */
    }
}
