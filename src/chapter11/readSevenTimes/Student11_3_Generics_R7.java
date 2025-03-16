package chapter11.readSevenTimes;

public class Student11_3_Generics_R7 implements Comparable<Student11_3_Generics_R7> {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    public Student11_3_Generics_R7(String name, int ban, int no, int kor, int eng, int math) {
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
        return (int) (getTotal() / 3f * 10 + 0.5f) / 10f;
    }

    @Override
    public String toString() {
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
    }

    // Comparable 인터페이스를 구현해서 이름(name)이 [기본 정렬 기준]이 되도록 하기
    // 지네릭스 설정하면 형변환 코드 사용하지 않아도 됨
    @Override
    public int compareTo(Student11_3_Generics_R7 student) {
        // String 클래스의 compareTo() 호출
        return this.name.compareTo(student.name);
    }
}
