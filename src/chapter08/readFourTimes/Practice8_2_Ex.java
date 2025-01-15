package chapter08.readFourTimes;

public class Practice8_2_Ex {
}

class NumberException extends Exception {}
class InvalidNumberException extends NumberException {}
class NotANumberException extends NumberException {}

class Parent {
    int a;
    int b;

    Parent() {
        this(0,0);
    }

    Parent(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void add(int a, int b)
            throws InvalidNumberException, NotANumberException {}
}
class Child extends Parent {
    Child() {}
    Child(int a, int b) {
        super(a,b);
    }

    @Override
    void add(int a, int b)
            throws InvalidNumberException, NotANumberException {}
}