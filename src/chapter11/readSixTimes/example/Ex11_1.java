package chapter11.readSixTimes.example;

import java.util.ArrayList;
import java.util.Collections;

/*
페이지 396
List 인터페이스
Collections.sort(), list.sort() 사용방법
 */
public class Ex11_1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(0);
        list.add(1);
        list.add(3);

        ArrayList subList = new ArrayList(list.subList(1, 4));
        print(list, subList);

        System.out.println("List 정렬 : Collections.sort(list)");
        Collections.sort(list);
//        subList.sort(); // Comparator 인터페이스의 compare() 메서드를 구현한 클래스 필요
        Collections.sort(subList);
        print(list, subList);

        System.out.println("list 에 subList 의 모든 요소를 포함하고 있는가");
        System.out.println(list.containsAll(subList));

        ArrayList<Integer> diffList = new ArrayList<>();
        diffList.add(1);
        diffList.add(2);
        diffList.add(9);
        System.out.println("list 에 diffList 의 모든 요소를 포함하고 있는가");
        System.out.println(list.containsAll(diffList)); // 하나라도 다르면 false

        System.out.println();
        System.out.println("List 에 요소 추가");
        subList.add("B");
        subList.add("C");
        subList.add(3, "A"); // 인덱스가 3인 곳에 "A" 추가
        print(list, subList);

        subList.set(3, "AA"); // 인덱스가 3인 곳에 "AA"로 변경
        print(list, subList);

        System.out.println("list 에서 subList 와 겹치는 부분만 남기고 나머지는 삭제");
        System.out.println(list.retainAll(subList));

        print(list, subList);

        System.out.println("subList 에서 list 에 포함된 객체들을 삭제한다.");
        // 삭제의 경우 뒤에서 부터 탐색해서 삭제하기
        for (int i = subList.size() - 1; i >= 0; i--) {
            if (list.contains(subList.get(i)))
                subList.remove(i); // 인덱스 i 인 곳에 저장된 요소를 삭제
        }

        print(list, subList);

        /*
        ArrayList 에서 초기 용량을 설정하는 이유
        - 만약 데이터가 많이 추가될 게 확실하다면, 처음부터 충분한 용량을 주면 배열 확장(reallocation) 비용을 줄일 수 있다.
        - 초기 용량을 10으로 설정 (하지만 크기가 10인 건 아님!)
         */
        ArrayList<Integer> listCapacity = new ArrayList<>(10);
        System.out.println("listCapacity.size() = " + listCapacity.size()); // 0
    }

    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println();
    }
}
