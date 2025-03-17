package chapter12.readSevenTimes;

import java.util.ArrayList;

/*
메서드는 두 개의 ArrayList 를 매개변수로 받아서,
하나의 새로운 ArrayList 로 병합하는 메서드
지네릭 메서드로 만들어보기
 */
public class Practice12_4_R7 {
    public static <T extends Product12_4_R7> ArrayList<T> merge(
            ArrayList<T> list, ArrayList<T> list2
    ) {
        ArrayList<T> newList = new ArrayList<>(list);

        newList.addAll(list2);

        return newList;
    }
}

class Product12_4_R7 {}