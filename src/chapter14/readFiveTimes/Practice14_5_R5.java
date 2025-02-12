package chapter14.readFiveTimes;

import java.util.Arrays;

/*
모든 문자열의 길이를 더하기
 */
public class Practice14_5_R5 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};
        // int 로 변환해서 더하기
        int lengthSum = Arrays.stream(strArr).mapToInt(String::length).sum();
        System.out.println("sum=" + lengthSum);

        // int 변환없이 Integer 로 더하기
        Integer reduceSum = Arrays.stream(strArr).map(String::length).reduce(0, Integer::sum);
        // Integer reduceSum = Arrays.stream(strArr).map(String::length).reduce(0, (a, b) -> a + b); 위와 같다.
        System.out.println("reduceSum=" + reduceSum);
    }
}
