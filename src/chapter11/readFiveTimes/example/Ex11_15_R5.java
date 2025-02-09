package chapter11.readFiveTimes.example;

import java.util.TreeSet;

public class Ex11_15_R5 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

        for (int i = 0; i < score.length; i++)
            set.add(score[i]);

        System.out.println("50보다 작은 값 :" + set.headSet(50)); // 끝 숫자 포함 안함
        System.out.println("50보다 작은 값 :" + set.headSet(50, true));
        System.out.println("50보다 큰 값 :" + set.tailSet(50)); // 시작 숫자 포함
        System.out.println("50보다 큰 값 :" + set.tailSet(50, false));
    }
}
