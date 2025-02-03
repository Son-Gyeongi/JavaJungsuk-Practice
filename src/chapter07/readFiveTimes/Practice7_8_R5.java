package chapter07.readFiveTimes;

class Outer7_8_R5 {
    int value = 10;

    class Inner {
        int value = 20;

        void method1() {
            int value = 30;

            System.out.println(value);
            System.out.println(this.value);
            System.out.println(Outer7_8_R5.this.value);
        }
    }
}

public class Practice7_8_R5 {
    public static void main(String[] args) {
        Outer7_8_R5 o = new Outer7_8_R5();
        Outer7_8_R5.Inner inner = o.new Inner();
        inner.method1();
    }
}
