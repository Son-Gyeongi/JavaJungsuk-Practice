package chapter11.readSixTimes.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/*
페이지 446
 */
public class Ex11_19 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list);

        System.out.println();

        System.out.println("Collections.addAll(list, 1, 2, 3, 4, 5)");
        Collections.addAll(list, 1, 2, 3, 4, 5);
        System.out.println(list);

        System.out.println();

        System.out.println("Collections.rotate(list, 2)");
        Collections.rotate(list, 2); // 오른쪽으로 두 칸씩 이동
        System.out.println(list);

        System.out.println();

        System.out.println("Collections.swap(list, 0, 2)");
        Collections.swap(list, 0, 2); // 0 인덱스와 2 인덱스를 교환(swap)
        System.out.println(list);

        System.out.println();

        System.out.println("Collections.shuffle(list)");
        Collections.shuffle(list);
        System.out.println(list);

        System.out.println();

        System.out.println("Collections.sort(list, Collections.reverseOrder());");
        Collections.sort(list, Collections.reverseOrder()); // 역순 정렬
        System.out.println(list);

        System.out.println("== 오름차순 정렬 ==");
        Collections.sort(list);
        System.out.println(list);

        System.out.println("Collections.reverse(list)");
        Collections.reverse(list);
        System.out.println(list);

        System.out.println("== 오름차순 정렬 ==");
        Collections.sort(list);
        System.out.println(list);

        System.out.println("list.reversed() // 새로운 리스트를 생성");
        List<Integer> reversedList = list.reversed();
        System.out.println(reversedList);

        System.out.println();

        System.out.println("Collections.sort(list)");
        Collections.sort(list);
        System.out.println(list);

        System.out.println("Collections.binarySearch(list, 3) 사용하기 전에 반드시 정렬 필수");
        int idx = Collections.binarySearch(list, 3);// 3 이 저장된 위치(index)를 반환
        System.out.println("index of 3 = " + idx);

        System.out.println();

        System.out.println("max=" + Collections.max(list));
        System.out.println("min=" + Collections.min(list));
        System.out.println("min=" + Collections.max(list, Collections.reverseOrder()));

        System.out.println();

        System.out.println("Collections.fill(list, 9)");
        Collections.fill(list, 9); // list 를 9로 채운다.
        System.out.println(list);

        System.out.println();

        System.out.println("list 와 같은 크기의 새로운 list 를 생성하고 2로 채운다. 단, 결과 변경불가");
        System.out.println("Collections.nCopies(list.size(), 2)");
        List<Integer> newList = Collections.nCopies(list.size(), 2);
        System.out.println("newList = " + newList);

        System.out.println("사이즈 10으로 정하고 5로 채운다.");
        List<Integer> newList2 = Collections.nCopies(10, 5);
        System.out.println("newList2 = " + newList2);

        /*
        Exception in thread "main" java.lang.UnsupportedOperationException 에러난다.
        System.out.println("newList.add(7) 추가해보기");
        newList.add(7);
        System.out.println(newList);
        System.out.println("newList.set(1, 5) 변경해보기");
        newList.set(1, 5);
        System.out.println(newList);
        */

        System.out.println();

        System.out.println("공통 요소가 없으면 true");
        System.out.println("Collections.disjoint(list, newList)");
        System.out.println(Collections.disjoint(list, newList));

        System.out.println();

        /*
        src 리스트의 요소를 dest 리스트의 동일한 인덱스 위치에 복사
            ✔ Collections.copy(dest, src);는 값(데이터)을 복사하는 메서드
            ✔ 참조 변수를 복사하는 게 아니라, dest 리스트의 기존 값을 src 값으로 덮어씀
            ✔ dest의 크기가 src보다 작으면 에러 발생 → 크기를 미리 확보해야 함
         */
        System.out.println("newList 에 있는 걸 list 로 복사");
        Collections.copy(list, newList);
        System.out.println("newList = " + newList);
        System.out.println("list = " + list);
        System.out.println("참조변수가 아닌 값을 복사한 건가?");
        System.out.println("System.identityHashCode(newList) = " + System.identityHashCode(newList));
        System.out.println("System.identityHashCode(list) = " + System.identityHashCode(list));

        System.out.println();

        System.out.println("Collections.replaceAll(list, 2, 1) - list 에서 2를 1로 바꾼다.");
        Collections.replaceAll(list, 2, 1);
        System.out.println("list = " + list);

        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(1);
        tempList.add(2);
        tempList.add(5);
        tempList.add(5);
        tempList.add(5);
        System.out.println("tempList = " + tempList);
        System.out.println("정해진 특정값만 변경되는 건가? - Collections.replaceAll(tempList, 5, 8)");
        Collections.replaceAll(tempList, 5, 8);
        System.out.println("change tempList = " + tempList);

        System.out.println();

        /*
        Collections.enumeration(list), Collections.list(e)
            ✔ 요즘 코드에서는 직접 사용할 일이 거의 없음
            ✔ 하지만 옛날 API와 호환할 때 사용
            ✔ Enumeration<T>을 반환하는 레거시 API에서 → List<T>로 변환하고 싶을 때 활용
            // Enumeration<Integer> e = vector.elements(); // Vector의 요소를 Enumeration으로 가져옴

            💡 요즘은 Iterator와 List를 직접 쓰는 게 더 자연스러워!
         */
        System.out.println("Collections.enumeration() 을 이용해서 새로운 list2 만들고 출력");
        Enumeration<Integer> e = Collections.enumeration(list);
        ArrayList<Integer> list2 = Collections.list(e);

        System.out.println("list2 = " + list2);
    }
}
