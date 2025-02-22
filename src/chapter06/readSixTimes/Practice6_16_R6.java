package chapter06.readSixTimes;

public class Practice6_16_R6 {
    public static void change(String str) {
        str += "456"; // 새로운 String 인스턴스의 주소를 지역변수 str 에 저장한다.
        System.out.println("change() 메서드 str = " + str);
    }

    public static void main(String[] args) {
        String str = "ABC123";
        System.out.println(str);
        change(str);
        System.out.println("main() 메서드 str = " + str);
        System.out.println("After change:" + str);
    }
}
