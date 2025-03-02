package chapter14.readSixTimes;

import java.util.stream.Stream;

public class Practice14_5_R6 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        int sum = Stream.of(strArr).mapToInt(String::length).sum();
//        Integer sum = Stream.of(strArr).map(String::length).reduce(0, Integer::sum);
//        Integer sum = Stream.of(strArr).map(String::length).reduce(0, (a, b) -> a + b);
        System.out.println("sum=" + sum);
    }
}
