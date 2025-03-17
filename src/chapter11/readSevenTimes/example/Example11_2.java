package chapter11.readSevenTimes.example;

import java.util.Arrays;

/*
페이지 415
Arrays 클래스의 binarySearch()로 중복된 값 찾을 때
 */
public class Example11_2 {
    public static void main(String[] args) {
        // 3이 2번 들어간다.
        int[] arr = {1, 2, 3, 6, 3, 5};

        // binarySearch() 사용전 정렬 필수
        Arrays.sort(arr);
        int findIndex = Arrays.binarySearch(arr, 3);
        System.out.println("findIndex = " + findIndex);
    }
}
