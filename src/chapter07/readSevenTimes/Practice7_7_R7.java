package chapter07.readSevenTimes;

class Outer7_7_R7 {
    static class Inner7_7_R7 {
        int iv = 200;
    }
}

public class Practice7_7_R7 {
    public static void main(String[] args) {
        Outer7_7_R7.Inner7_7_R7 staticInner = new Outer7_7_R7.Inner7_7_R7();
        System.out.println(staticInner.iv);
    }
}
