package chapter11.readSixTimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Student11_4_R6 {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    public Student11_4_R6(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int getTotal() {
        return kor + eng + math;
    }

    float getAverage() {
        return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
    }

    @Override
    public String toString() {
        return name
                + "," + ban
                + "," + no
                + "," + kor
                + "," + eng
                + "," + math
                + "," + getTotal()
                + "," + getAverage();
    }
}

class BanNoAscending11_4_R6 implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student11_4_R6 && o2 instanceof Student11_4_R6) {
            Student11_4_R6 s1 = (Student11_4_R6) o1;
            Student11_4_R6 s2 = (Student11_4_R6) o2;

            // 반과 번호로 오름차순 정렬 (반이 같은 경우 번호를 비교해서 정렬)
            return s1.ban != s2.ban ? s1.ban - s2.ban : s1.no - s2.no;
        }

        return -1;
    }
}

public class Practice11_4_R6 {
    public static void main(String[] args) {
        ArrayList<Student11_4_R6> list = new ArrayList<>();
        list.add(new Student11_4_R6("이자바", 2, 1, 70, 90, 70));
        list.add(new Student11_4_R6("안자바", 2, 2, 60, 100, 80));
        list.add(new Student11_4_R6("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student11_4_R6("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student11_4_R6("김자바", 1, 2, 80, 80, 90));

        Collections.sort(list, new BanNoAscending11_4_R6());
        Iterator<Student11_4_R6> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
