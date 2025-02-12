package chapter14.readFiveTimes;

import java.util.Arrays;
import java.util.OptionalInt;

/*
문자열 중에 가장 긴 것의 길이 출력
 */
public class Practice14_6_R5 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        // int 로 변환
        OptionalInt max = Arrays.stream(strArr).mapToInt(String::length).max();
        System.out.println("max = " + max);
        int maxAsInt = Arrays.stream(strArr).mapToInt(String::length).max().getAsInt();
        System.out.println("maxAsInt = " + maxAsInt);

        // int 변환없이 Integer 로 계산
        Integer reduceMax = Arrays.stream(strArr).map(String::length).reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println("reduceMax = " + reduceMax);
        Integer reduceMathMax = Arrays.stream(strArr).map(String::length).reduce(Integer.MIN_VALUE, Math::max);
        System.out.println("reduceMathMax = " + reduceMathMax);
    }
}
