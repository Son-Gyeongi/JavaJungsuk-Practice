package chapter11.readSevenTimes.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/*
페이지 448
LinkedHashSet, LinkedHashMap
- 저장 순서가 유지된다는데 테스트 해보자
 */
public class Example11_6 {
    public static void main(String[] args) {
        System.out.println("===== 저장 순서 유지 되지 않음 =====");
        HashSet<Integer> set = new HashSet<>();
        set.add(50); set.add(20); set.add(33);
        set.add(70); set.add(5); set.add(45);
        set.add(67); set.add(23); set.add(9);
        set.add(100);
        System.out.println("HashSet : " + set);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(50, "a"); map.put(20, "b"); map.put(33, "c");
        map.put(70, "d"); map.put(5, "e"); map.put(45, "f");
        map.put(67, "g"); map.put(23, "h"); map.put(9, "i");
        map.put(100, "j");
        System.out.println("HashMap : " + map);
        System.out.println();

        System.out.println("===== 저장 순서 유지 됨 =====");
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(50); linkedHashSet.add(20); linkedHashSet.add(33);
        linkedHashSet.add(70); linkedHashSet.add(5); linkedHashSet.add(45);
        linkedHashSet.add(67); linkedHashSet.add(23); linkedHashSet.add(9);
        linkedHashSet.add(100);
        System.out.println("LinkedHashSet : " + linkedHashSet);

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(50, "a"); linkedHashMap.put(20, "b"); linkedHashMap.put(33, "c");
        linkedHashMap.put(70, "d"); linkedHashMap.put(5, "e"); linkedHashMap.put(45, "f");
        linkedHashMap.put(67, "g"); linkedHashMap.put(23, "h"); linkedHashMap.put(9, "i");
        linkedHashMap.put(100, "j");
        System.out.println("LinkedHashMap : " + linkedHashMap);
    }
}
