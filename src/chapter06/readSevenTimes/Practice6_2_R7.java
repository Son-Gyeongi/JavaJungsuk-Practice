package chapter06.readSevenTimes;

public class Practice6_2_R7 {
    public static void main(String[] args) {
        Student_C6_R7 student = new Student_C6_R7("홍길동", 1, 1, 100, 60, 76);

        String str = student.info();
        System.out.println(str);
    }
}
