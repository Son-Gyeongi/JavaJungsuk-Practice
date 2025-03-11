package chapter07.readSevenTimes;

class Outer7_6_R7 {
    class Inner7_6_R7 {
        int iv = 100;
    }
}

public class Practice7_6_R7 {
    public static void main(String[] args) {
        Outer7_6_R7 outer = new Outer7_6_R7();
        Outer7_6_R7.Inner7_6_R7 inner = outer.new Inner7_6_R7();
        System.out.println(inner.iv);
    }
}
