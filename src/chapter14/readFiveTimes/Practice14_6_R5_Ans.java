package chapter14.readFiveTimes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.Stream;

/*
문자열 중에 가장 긴 것의 길이 출력 Answer
 */
public class Practice14_6_R5_Ans {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        Stream<String> strStream = Arrays.stream(strArr);

        strStream.map(String::length)
                .sorted(Comparator.reverseOrder()) // 문자열 길이로 역순 정렬
                .limit(1)
                .forEach(System.out::println); // 제일 긴 문자열의 길이 출력
    }
}
