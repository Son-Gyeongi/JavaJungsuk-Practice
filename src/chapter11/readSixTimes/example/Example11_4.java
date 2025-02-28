package chapter11.readSixTimes.example;

import java.util.HashSet;
import java.util.TreeSet;

/*
페이지 448
 */
public class Example11_4 {
    /*
        ✔ TreeSet = TreeMap의 Key만 따로 관리 (정렬 O)
        ✔ HashSet = HashMap의 Key만 따로 관리 (정렬 X)
        ✔ 내부적으로 TreeSet은 TreeMap, HashSet은 HashMap을 활용
     */
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
    }
}
