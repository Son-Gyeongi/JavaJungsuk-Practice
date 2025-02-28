package chapter11.readSixTimes.example;

import java.util.*;

/*
페이지 390
List, Set, Map 컬렉션 프레임워크 핵심 인터페이스
equals() 사용방법
 */
public class Example11_1 {
    public static void main(String[] args) {
        System.out.println("===== List =====");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        System.out.println(list1.equals(list2)); // 값이 똑같은 경우 true, 아니면 false

        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(4);

        System.out.println(list1.equals(list3));

        System.out.println();
        System.out.println("===== Set =====");
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");

        Set<String> set2 = new HashSet<>();
        set2.add("a");
        set2.add("b");
        set2.add("c");

        System.out.println(set1.equals(set2)); // 값이 똑같은 경우 true, 아니면 false

        Set<String> set3 = new HashSet<>();
        set3.add("a");
        set3.add("b");
        set3.add("d");

        System.out.println(set1.equals(set3));

        System.out.println();
        System.out.println("===== Map =====");
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("a", 1);
        map2.put("b", 2);
        map2.put("c", 3);

        System.out.println(map1.equals(map2)); // 키,값 쌍이 완전 똑같아야 하는구나

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("a", 1);
        map3.put("b", 2);
        map3.put("d", 3); // 키가 다른 경우

        System.out.println("키가 다른 경우 : " + map1.equals(map3));

        Map<String, Integer> map4 = new HashMap<>();
        map4.put("a", 1);
        map4.put("b", 2);
        map4.put("c", 5); // 값이 다른 경우

        System.out.println("값이 다른 경우 : " + map1.equals(map4));
    }
}
