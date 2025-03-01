package chapter12.readSixTimes.example;

import java.util.HashMap;

/*
페이지 465

HashMap 에서 get(), remove() 매개변수는 Object 타입을 사용할까?

K 타입이 아니어도 equals() 비교가 가능하면 동작하지만, K 타입이 아니라면 일반적으로 null을 반환함.

데이터를 찾거나 삭제할 때(get, remove)는 유연성(Object) 을 고려하고,
추가할 때(put)는 타입 안정성(K, V) 을 유지하는 설계
 */
public class Example12_1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        System.out.println(map.get("a"));
        System.out.println(map.get(1));

        System.out.println(map.remove("b"));
        System.out.println(map.remove(1));
    }
}
