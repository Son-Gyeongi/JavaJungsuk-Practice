package chapter11.readSixTimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Student11_3_R6 implements Comparable {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    public Student11_3_R6(String name, int ban, int no, int kor, int eng, int math) {
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
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student11_3_R6) {
            Student11_3_R6 s = (Student11_3_R6) o;
            return name.compareTo(s.name);
        }

        return -1;
    }
}

public class Practice11_3_R6 {
    public static void main(String[] args) {
        ArrayList<Student11_3_R6> list = new ArrayList<>();
        list.add(new Student11_3_R6("홍길동", 1, 1, 100, 100, 100));
        list.add(new Student11_3_R6("남궁성", 1, 2, 90, 70, 80));
        list.add(new Student11_3_R6("김자바", 1, 3, 80, 80, 90));
        list.add(new Student11_3_R6("이자바", 1, 4, 70, 90, 70));
        list.add(new Student11_3_R6("안자바", 1, 5, 60, 100, 80));

        Collections.sort(list);
        Iterator<Student11_3_R6> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
