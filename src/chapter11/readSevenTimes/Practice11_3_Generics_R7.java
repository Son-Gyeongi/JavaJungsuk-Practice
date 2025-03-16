package chapter11.readSevenTimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Practice11_3_Generics_R7 {
    public static void main(String[] args) {
        ArrayList<Student11_3_Generics_R7> list = new ArrayList<>();
        list.add(new Student11_3_Generics_R7("홍길동", 1, 1, 100, 100, 100));
        list.add(new Student11_3_Generics_R7("남궁성", 1, 2, 90, 70, 80));
        list.add(new Student11_3_Generics_R7("김자바", 1, 3, 80, 80, 90));
        list.add(new Student11_3_Generics_R7("이자바", 1, 4, 70, 90, 70));
        list.add(new Student11_3_Generics_R7("안자바", 1, 5, 60, 100, 80));

        Collections.sort(list);
        Iterator<Student11_3_Generics_R7> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
