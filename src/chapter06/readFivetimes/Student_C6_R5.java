package chapter06.readFivetimes;

public class Student_C6_R5 {
    String name; // 학생이름
    int ban; // 반
    int no; // 번호
    int kor; // 국어점수
    int eng; // 영어점수
    int math; // 수학점수

    public Student_C6_R5() {
    }

    public Student_C6_R5(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public int getTotal() {
        return kor + eng + math;
    }

    public float getAverage() {
        return (int) ((getTotal() / 3f) * 10 + 0.5f) / 10f; // 소수점 둘째자리에서 반올림
    }

    public String info() {
        return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math + ", "
                + getTotal() + ", " + getAverage();
    }
}
