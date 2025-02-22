package chapter06.readSixTimes;

/*
Student Chapter06 Read 6th
 */
public class Student_C6_R6 {
    String name; // 학생이름
    int ban; // 반
    int no; // 번호
    int kor; // 국어점수
    int eng; // 영어점수
    int math; // 수학점수

    public Student_C6_R6() {
    }

    public Student_C6_R6(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public String info() {
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math
                + "," + getTotal() + "," + getAverage();
    }

    public int getTotal() {
        return kor + eng + math;
    }

    public float getAverage() {
        return (int) (getTotal() / 3f * 10 + 0.5) / 10f;
    }
}
