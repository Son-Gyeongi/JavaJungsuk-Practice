package chapter11.readSevenTimes.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/*
페이지 393 에서 Map 인터페이스의 values() 테스트
반환값이 Collection 인데 어떻게 나오는지 궁금
List, Set 둘 중 하나 사용은 어떻게 해야 할까?
 */
public class Example11_1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);

        Collection<Integer> values = map.values();
        System.out.println("values = " + values);
        ArrayList<Integer> valueList = new ArrayList<>(values);
        System.out.println("valueList = " + valueList);
        System.out.println();

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("c", 2);
        map2.put("d", 3);
        map2.put("e", 3);
        map2.put("f", 3);
        map2.put("g", 4);
        map2.put("h", 5);
        map2.put("a", 1);
        map2.put("b", 1); // 저장순서 없다.

        Collection<Integer> values2 = map2.values();
        System.out.println("values2 = " + values2);
        ArrayList<Integer> value2List = new ArrayList<>(values2);
        System.out.println("value2List = " + value2List);
        HashSet<Integer> value2Set = new HashSet<>(values2);
        System.out.println("value2Set = " + value2Set);
    }
}
