package chapter11.readSixTimes.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
페이지 395
List 인터페이스
toArray() 사용방법
 */
public class Example11_3 {
    public static void main(String[] args) {
        System.out.println("===== ArrayList<Integer> =====");
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        Object[] arrayList1 = list1.toArray();
        Object[] arrayList2 = list2.toArray();

        System.out.println(Arrays.toString(arrayList1));
        System.out.println(Arrays.toString(arrayList2));
        System.out.println();

        Integer[] integerArr1 = list1.toArray(new Integer[]{});
        Integer[] integerArr2 = list1.toArray(new Integer[]{});

        System.out.println(Arrays.toString(arrayList1));
        System.out.println(Arrays.toString(arrayList2));

        System.out.println();
        System.out.println("===== ArrayList<String> =====");
        ArrayList<String> listStr1 = new ArrayList<>();
        listStr1.add("a");
        listStr1.add("b");
        listStr1.add("c");
        listStr1.add("d");
        listStr1.add("e");

        List<String> listStr2 = new ArrayList<>();
        listStr2.add("a");
        listStr2.add("b");
        listStr2.add("c");

        Object[] arrayStrList1 = listStr1.toArray();
        Object[] arrayStrList2 = listStr2.toArray();

        System.out.println(Arrays.toString(arrayStrList1));
        System.out.println(Arrays.toString(arrayStrList2));
        System.out.println();

        String[] stringArr1 = listStr1.toArray(new String[]{});
        String[] stringArr2 = listStr2.toArray(new String[]{});

        System.out.println(Arrays.toString(stringArr1));
        System.out.println(Arrays.toString(stringArr2));
    }
}
