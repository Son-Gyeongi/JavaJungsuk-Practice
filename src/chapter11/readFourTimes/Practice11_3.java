package chapter11.readFourTimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Student11_3 implements Comparable {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    public Student11_3(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int getTotal() {
        return this.kor + this.eng + this.math;
    }

    float getAverage() {
        return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
    }

    @Override
    public String toString() {
        // this. - 자기자신의 주소값을 참조하는 참조 변수 생략
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
    }

    // Student 클래스가 Comparable 인터페이스를 구현하도록 해서
    // 이름(name)이 기본 정렬기준이 되도록 하기
    @Override
    public int compareTo(Object o) { // Comparable<Student> 로 해주면 매개변수 타입이 Student 로 받는다.
        if (o instanceof Student11_3) {
            Student11_3 s = (Student11_3) o;

            // String 타입의 기본 정렬기준을 사용한다.
            return this.name.compareTo(s.name); // 이름으로 오름차순 정렬
        }

        return -1;
    }
}

public class Practice11_3 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student11_3("홍길동", 1, 1, 100, 100, 100));
        list.add(new Student11_3("남궁성", 1, 2, 90, 70, 80));
        list.add(new Student11_3("김자바", 1, 3, 80, 80, 90));
        list.add(new Student11_3("이자바", 1, 4, 70, 90, 70));
        list.add(new Student11_3("안자바", 1, 5, 60, 100, 80));

        Collections.sort(list);
        Iterator it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
