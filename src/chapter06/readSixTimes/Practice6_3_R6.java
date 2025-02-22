package chapter06.readSixTimes;

public class Practice6_3_R6 {
    public static void main(String[] args) {
        Student_C6_R6 s = new Student_C6_R6();
        s.name = "홍길동";
        s.ban = 1;
        s.no = 1;
        s.kor = 100;
        s.eng = 60;
        s.math = 76;

        System.out.println("이름:" + s.name);
        System.out.println("총점:" + s.getTotal());
        System.out.println("평균:" + s.getAverage());
    }
}
