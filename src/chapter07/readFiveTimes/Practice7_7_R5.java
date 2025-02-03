package chapter07.readFiveTimes;

class Outer7_7_R5 {
    static class Inner {
        int iv = 200;
    }
}

public class Practice7_7_R5 {
    public static void main(String[] args) {
        Outer7_7_R5.Inner oi = new Outer7_7_R5.Inner();
        System.out.println(oi.iv);
    }
}
