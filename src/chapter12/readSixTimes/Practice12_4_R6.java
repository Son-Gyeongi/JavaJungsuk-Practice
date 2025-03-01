package chapter12.readSixTimes;

import java.util.ArrayList;

public class Practice12_4_R6 {
    /*
    지네릭 메서드 작성
    2개의 ArrayList 를 매개변수로 받아서, 하나의 새로운 ArrayList로 병합하는 메서드
     */
    public static <T extends Product12_4_R6> ArrayList<T> merge(
            ArrayList<T> list, ArrayList<T> list2
    ) {
        ArrayList<T> newList = new ArrayList<>(list);

        newList.addAll(list2);

        return newList;
    }
}

class Product12_4_R6 {}

class Tv12_4_R6 extends Product12_4_R6 {}

class Computer12_4_R6 extends Product12_4_R6 {}