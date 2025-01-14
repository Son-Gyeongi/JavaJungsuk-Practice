package chapter07;

class Outer3 {
    int value = 10;

    class Inner {
        int value = 20;

        void method1() {
            int value = 30;

            System.out.println(value);
            System.out.println(this.value);
            System.out.println(Outer3.this.value);
        }
    }
}

public class Practice7_8 {
    public static void main(String[] args) {
        Outer3.Inner inner = new Outer3().new Inner();
        inner.method1();
    }
}
