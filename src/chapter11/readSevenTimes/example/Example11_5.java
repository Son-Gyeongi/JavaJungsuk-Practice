package chapter11.readSevenTimes.example;

import java.util.HashMap;

/*
페이지 440
HashMap 은 null 저장으 허용
map.put(null,null) 이 허용되면 null 은 한 개만 등록 가능한가?
 */
public class Example11_5 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(null, null);
        map.put(null, 5);

        System.out.println(map); // {null=5, 1=1}
        // => HashMap 은 null 키를 하나만 가질 수 있으며, 이 경우 해당 키의 값은 마지막으로 지정된 값인 5
    }
}
