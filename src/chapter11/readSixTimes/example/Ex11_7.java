package chapter11.readSixTimes.example;

import java.util.Arrays;
import java.util.Comparator;

/*
페이지 421
 */
public class Ex11_7 {
    public static void main(String[] args) {
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr); // String 의 Comparable 구현에 의한 정렬
        System.out.println("strArr=" + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분안함
        System.out.println("strArr=" + Arrays.toString(strArr));

        Arrays.sort(strArr, new Descending()); // 역순 정렬 (내림차순)
        System.out.println("strArr=" + Arrays.toString(strArr));
    }
}

/*
instanceof 를 String 이 아닌 Comparable 로 한 이유
- Comparable 을 사용하면 다양한 타입을 지원할 수 있다. (범용성)
    - String 뿐만 아니라, Integer, Double, LocalDate 같은 여러 클래스들도 Comparable 을 구현하고 있다.
    - 즉, Descending 클래스는 String 뿐만 아니라 Integer, Double 같은 다른 Comparable 객체도 비교할 수 있도록
    범용적으로 설계된 것이다.
- Comparable로 체크하면, compareTo()를 호출할 수 있는 객체들만 필터링할 수 있어서 안전한 코드가 된다.
 */
class Descending implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1; // -1 을 곱해서 기본 정렬방식의 역으로 변경
            // 또는 c2.compareTo(c1) 과 같이 순서를 바꿔도 된다.
        }

        return -1;
    }
}

/*
class Descending implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof String && o2 instanceof String) {
            String c1 = (String) o1;
            String c2 = (String) o2;
            return c1.compareTo(c2) * -1; // -1 을 곱해서 기본 정렬방식의 역으로 변경
            // 또는 c2.compareTo(c1) 과 같이 순서를 바꿔도 된다.
        }

        return -1;
    }
}*/
