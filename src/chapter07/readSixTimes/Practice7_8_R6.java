package chapter07.readSixTimes;

class Outer7_8_R6 {
    int value = 10;

    class Inner7_8_R6 {
        int value = 20;

        void method1() {
            int value = 30;

            System.out.println(value);
            System.out.println(this.value);
            System.out.println(Outer7_8_R6.this.value);
        }
    }
}

public class Practice7_8_R6 {
    public static void main(String[] args) {
        Outer7_8_R6 outer = new Outer7_8_R6();
        Outer7_8_R6.Inner7_8_R6 inner = outer.new Inner7_8_R6();

        inner.method1();
    }
}
