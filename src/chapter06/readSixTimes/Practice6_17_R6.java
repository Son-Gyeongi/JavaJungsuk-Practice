package chapter06.readSixTimes;

import java.util.Arrays;

public class Practice6_17_R6 {
    public static int[] shuffle(int[] arr) {
        // 매개변수가 있는 메서드의 경우 유효성 검사하기
        if (arr == null || arr.length == 0) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            int index = (int) (Math.random() * arr.length);

            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(original));

        int[] result = shuffle(original);
        System.out.println(Arrays.toString(result));
    }
}
