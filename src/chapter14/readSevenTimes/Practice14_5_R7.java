package chapter14.readSevenTimes;

import java.util.Arrays;

public class Practice14_5_R7 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        // s -> s.length() == String::length
        int sum = Arrays.stream(strArr).mapToInt(String::length).sum();
        System.out.println("sum=" + sum);
    }
}
