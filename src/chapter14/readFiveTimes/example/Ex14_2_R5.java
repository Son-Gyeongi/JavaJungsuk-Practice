package chapter14.readFiveTimes.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
java.util.function 패키지 - 함수형 인터페이스
 */
public class Ex14_2_R5 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1; // 1~100 난수
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i % 2 == 0; // 짝수인지 검사
        Function<Integer, Integer> f = i -> i / 10 * 10; // i 의 일의 자리를 없앤다.

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list); // list 를 랜덤값으로 채운다.
        System.out.println(list);
        printEvenNum(p, c, list);
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);
    }

    // 지네릭 메서드
    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());

        for (T i : list) {
            newList.add(f.apply(i)); // 일의 자리를 없애서 새로운 list 에 저장
        }

        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i)) // 짝수인지 검사
                c.accept(i); // i -> System.out.print(i + ", ") 화면에 i 출력
        }
        System.out.println("]");
    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get()); // Supplier 로 부터 1~100 사이의 난수를 받아서 list 에 추가
        }
    }
}
