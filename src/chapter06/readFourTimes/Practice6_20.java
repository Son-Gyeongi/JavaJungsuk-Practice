package chapter06.readFourTimes;

import java.util.Arrays;

public class Practice6_20 {
    public static int max(int[] arr) {
        // 매개변수가 있으면 유효성 검사 꼭 하기!
        if (arr == null || arr.length == 0) {
            return -999999;
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            // max = Math.max(max, arr[i]);
            // max = max > arr[i] ? max : arr[i];
        }

        return max;
    }

    public static void main(String[] args) {
        int[] data = {3, 2, 9, 4, 7};
        System.out.println(Arrays.toString(data));
        System.out.println("최대값:" + max(data));
        System.out.println("최대값:" + max(null));
        System.out.println("최대값:" + max(new int[]{})); // 크기가 0인 배열
    }
}
