package chapter11.readSevenTimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class BanNoAscending implements Comparator {
    // ArrayList 에 담긴 Student 인스턴스들이 반(ban)과 번호(no)로 오름차순 정렬(반이 같은 경우 번호를 비교해서 정렬)
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student11_4_R7 s1 && o2 instanceof Student11_4_R7 s2) {
            return s1.ban - s2.ban == 0 ? s1.no - s2.no : s1.ban - s2.ban;
        }

        return -1;
    }
}

public class Practice11_4_R7 {
    public static void main(String[] args) {
        ArrayList<Student11_4_R7> list = new ArrayList<>();
        list.add(new Student11_4_R7("이자바", 2, 1, 70, 90, 70));
        list.add(new Student11_4_R7("안자바", 2, 2, 60, 100, 80));
        list.add(new Student11_4_R7("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student11_4_R7("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student11_4_R7("김자바", 1, 2, 80, 80, 90));

        Collections.sort(list, new BanNoAscending()); // 정렬대상, 정렬기준 필요
        Iterator<Student11_4_R7> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
