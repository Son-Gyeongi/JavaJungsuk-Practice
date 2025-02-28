package chapter11.readSixTimes.example;

import java.util.*;

/*
페이지 395
List 인터페이스
removeAll() 사용방법
 */
public class Example11_2 {
    public static void main(String[] args) {
        System.out.println("===== ArrayList =====");
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        System.out.println(list1.removeAll(list2));
        System.out.println(list1); // [4,5]
        System.out.println();

        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(5);

        List<Integer> list4 = new ArrayList<>();
        list4.add(6);
        list4.add(7);
        list4.add(8);

        System.out.println(list3.removeAll(list4));
        System.out.println(list3); // [1,2,3,4,5]
    }
}
