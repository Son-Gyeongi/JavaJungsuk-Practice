package chapter07.readSixTimes;

class Outer7_6_R6 {
    class Inner7_6_R6 {
        int iv = 100;
    }
}

public class Practice7_6_R6 {
    public static void main(String[] args) {
        Outer7_6_R6 outer = new Outer7_6_R6();
        Outer7_6_R6.Inner7_6_R6 inner = outer.new Inner7_6_R6();
        System.out.println(inner.iv);
    }
}
