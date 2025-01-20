package chapter14.readFourTimes;

import java.util.Arrays;

public class Practice14_6 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        int maxLength = Arrays.stream(strArr)
                .mapToInt(String::length).max().getAsInt();

        System.out.println(maxLength);
    }
}
