package chapter11.readFiveTimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Student11_3_Generics_R5 implements Comparable<Student11_3_Generics_R5> {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    public Student11_3_Generics_R5(String name, int ban, int no, int kor, int eng, int math) {
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
        // 소수점 첫째 자리까지 보여주기 - 2번째 자리에서 반올림
        return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
    }

    @Override
    public String toString() {
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
    }

    /*
        Comparable 인터페이스 구현
        이름(name)이 기본 정렬 기준이 된다.
         */
    @Override
    public int compareTo(Student11_3_Generics_R5 o) {
        return name.compareTo(o.name); // 지네릭스를 사용하면 형변환이 필요없다.
    }
}

public class Practice11_3_Generics_R5 {
    public static void main(String[] args) {
        ArrayList<Student11_3_Generics_R5> list = new ArrayList<>();
        list.add(new Student11_3_Generics_R5("홍길동", 1, 1, 100, 100, 100));
        list.add(new Student11_3_Generics_R5("남궁성", 1, 2, 90, 70, 80));
        list.add(new Student11_3_Generics_R5("김자바", 1, 3, 80, 80, 90));
        list.add(new Student11_3_Generics_R5("이자바", 1, 4, 70, 90, 70));
        list.add(new Student11_3_Generics_R5("안자바", 1, 5, 60, 100, 80));

        Collections.sort(list);
        Iterator<Student11_3_Generics_R5> it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
