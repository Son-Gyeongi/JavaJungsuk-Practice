package chapter11.readSevenTimes.example;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/*
페이지 432
TreeSet 클래스의 descendingSet() 메서드 사용해보기
 */
public class Example11_4 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(9);
        set.add(6);
        set.add(3);
        set.add(5);
        set.add(2);

        System.out.println("===== TreeSet =====");
        System.out.println(set);

        NavigableSet<Integer> navigableSet = set.descendingSet();

        System.out.println("===== TreeSet 클래스의 descendingSet() 역순 =====");
        System.out.println(navigableSet);

        System.out.println("===== TreeSet 클래스의 descendingSet() 역순 =====");
        System.out.println("Set 으로 참조변수 변경");
        Set<Integer> descSet = set.descendingSet();
        System.out.println(descSet);

        System.out.println("===== TreeSet 클래스의 descendingSet() 역순 =====");
        System.out.println("참조변수 저장없이 그냥 출력");
        System.out.println(set.descendingSet());
    }
}
