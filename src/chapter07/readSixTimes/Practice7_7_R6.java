package chapter07.readSixTimes;

class Outer7_7_R6 {
    static class Inner7_7_R6 {
        int iv = 200;
    }
}

public class Practice7_7_R6 {
    public static void main(String[] args) {
        Outer7_7_R6.Inner7_7_R6 oi = new Outer7_7_R6.Inner7_7_R6();
        System.out.println(oi.iv);
    }
}
