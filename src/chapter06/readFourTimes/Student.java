package chapter06.readFourTimes;

public class Student {
    String name; // 학생 이름
    int ban; // 반
    int no; // 번호
    int kor; // 국어 점수
    int eng; // 영어 점수
    int math; // 수학 점수

    Student() {}

    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public String info() {
        int totalSum = this.kor + this.eng + this.math;

        return String.format("%s,%d,%d,%d,%d,%d,%d,%.1f",
                this.name, this.ban, this.no, this.kor, this.eng, this.math,
                totalSum, Math.round((totalSum / 3f) * 10) / 10f);
    }

    public int getTotal() {
        return this.kor + this.eng + this.math;
    }

    public float getAverage() {
        return Math.round((getTotal() / 3f) * 10) / 10f;
    }
}
