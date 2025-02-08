package chapter11.readFiveTimes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Student11_4_R5 {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    public Student11_4_R5(String name, int ban, int no, int kor, int eng, int math) {
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
}

class BanNoAscending implements Comparator {
    // 반(ban)과 번호(no)로 오름차순 정렬 - 반이 같은 경우 번호를 비교해서 정렬
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student11_4_R5 && o2 instanceof Student11_4_R5) {
            Student11_4_R5 student1 = (Student11_4_R5) o1;
            Student11_4_R5 student2 = (Student11_4_R5) o2;

            return student1.ban - student2.ban != 0 ? student1.ban - student2.ban : student1.no - student2.no;
        }

        return -1;
    }
}

public class Practice11_4_R5 {
    public static void main(String[] args) {
        ArrayList<Student11_4_R5> list = new ArrayList<>();
        list.add(new Student11_4_R5("이자바", 2, 1, 70, 90, 70));
        list.add(new Student11_4_R5("안자바", 2, 2, 60, 100, 80));
        list.add(new Student11_4_R5("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student11_4_R5("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student11_4_R5("김자바", 1, 2, 80, 80, 90));

        Collections.sort(list, new BanNoAscending());
        Iterator<Student11_4_R5> it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
