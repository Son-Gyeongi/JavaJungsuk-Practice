package chapter14.readFiveTimes.example;

/*
함수형 인터페이스
추상 메서드 한 개
 */
@FunctionalInterface
interface MyFunction14_1_R5 {
    void run(); // public abstract void run();
}

public class Ex14_1_R5 {
    static void execute(MyFunction14_1_R5 f) { // 매개변수의 타입이 MyFunction 인 메서드
        f.run();
    }

    static MyFunction14_1_R5 getMyFunction() { // 반환 타입이 MyFunction 인 메서드
        MyFunction14_1_R5 f = () -> System.out.println("f3.run()");
        return f;
    }

    public static void main(String[] args) {
        // 람다식으로 MyFunction 의 run() 을 구현
        MyFunction14_1_R5 f1 = () -> System.out.println("f1.run()");

        MyFunction14_1_R5 f2 = new MyFunction14_1_R5() { // 익명클래스로 run() 을 구현
            @Override
            public void run() { // public 을 반드시 붙여야 함
                System.out.println("f2.run()");
            }
        };

        MyFunction14_1_R5 f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute(() -> System.out.println("run()"));
    }
}
