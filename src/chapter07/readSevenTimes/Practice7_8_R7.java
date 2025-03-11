package chapter07.readSevenTimes;

class Outer7_8_R7 {
    int value = 10;

    class Inner7_8_R7 {
        int value = 20;

        void method1() {
            int value = 30;

            System.out.println(value);
            System.out.println(this.value);
            System.out.println(Outer7_8_R7.this.value);
        }
    }
}

public class Practice7_8_R7 {
    public static void main(String[] args) {
        Outer7_8_R7 outer = new Outer7_8_R7();
        Outer7_8_R7.Inner7_8_R7 inner = outer.new Inner7_8_R7();

        inner.method1();
    }
}
