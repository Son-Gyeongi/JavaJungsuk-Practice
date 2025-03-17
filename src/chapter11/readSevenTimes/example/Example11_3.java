package chapter11.readSevenTimes.example;

import java.util.HashSet;

/*
페이지 424
HashSet 에서 addAll() 메서드에서 하나라도 중복이면 전부 다 추가 안 되려나?
- 중복 제외하고 중복되지 않은 값은 저장된다.
 */
public class Example11_3 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(6);
        set2.add(7);
        set2.add(8);
        set2.add(9);
        set2.add(10);

        System.out.println(set.addAll(set2));
        System.out.println(set);
    }
}
