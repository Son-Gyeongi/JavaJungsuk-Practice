package chapter07.readFourTimes;

class Outer2 {
    static class Inner {
        int iv = 200;
        static int iv2 = 300;
    }
}

public class Practice7_7 {
    public static void main(String[] args) {
        Outer2.Inner oi = new Outer2.Inner();
        System.out.println(oi.iv);
        System.out.println(Outer2.Inner.iv2);
//        System.out.println(Outer2.Inner.iv); // 에러. iv 는 인스턴스변수이므로 인스턴스를 생성해야함
    }
}
