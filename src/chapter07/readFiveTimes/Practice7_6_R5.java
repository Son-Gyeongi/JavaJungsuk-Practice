package chapter07.readFiveTimes;

class Outer7_6_R5 {
    class Inner {
        int iv = 100;
    }
}

public class Practice7_6_R5 {
    public static void main(String[] args) {
        Outer7_6_R5 o = new Outer7_6_R5();
        Outer7_6_R5.Inner i = o.new Inner();
        System.out.println(i.iv);
    }
}
