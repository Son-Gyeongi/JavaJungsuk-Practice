package chapter11.readFourTimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Student11_4 {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    public Student11_4(String name, int ban, int no, int kor, int eng, int math) {
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

// ArrayList 에 담긴 Student 인스턴스들이
// 반(ban)과 번호(no)로 오름차순 정렬되게 하시오.
// (반이 같은 경우 번호를 비교해서 정렬한다.)
class BanNoAscending implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (!(o1 instanceof Student11_4 && o2 instanceof Student11_4)) return -1;

        Student11_4 s1 = (Student11_4) o1;
        Student11_4 s2 = (Student11_4) o2;

        return s1.ban - s2.ban != 0 ? s1.ban - s2.ban : s1.no - s2.no;
    }
}

public class Practice11_4 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student11_4("이자바", 2, 1, 70, 90, 70));
        list.add(new Student11_4("안자바", 2, 2, 60, 100, 80));
        list.add(new Student11_4("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student11_4("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student11_4("김자바", 1, 2, 80, 80, 90));

        Collections.sort(list, new BanNoAscending());
        Iterator it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
