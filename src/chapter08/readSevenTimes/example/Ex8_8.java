package chapter08.readSevenTimes.example;

class Ex8_8 {
    public static void main(String[] args) {
        try {
            method1(); // !!! 예외 발생
            System.out.println(6); // . 예외가 발생해서 실행되지 않는다
        } catch(Exception e) {
            System.out.println(7);
        }
    }
    static void method1() throws Exception {
        try {
            method2();
            System.out.println(1);
        } catch(NullPointerException e) {
            System.out.println(2);
            throw e; // . (re-throwing) 예외를 다시 발생시킨다 예외 되던지기

            // 중첩된 try-catch 구문 - 아래와 같이 할 수도 있다.
            /*try {
                throw e;
            } catch (Exception e2) {
                // 예외 처리
            }*/
        } catch(Exception e) {
            System.out.println(3);
        } finally {
            System.out.println(4);
        }
        System.out.println(5);
    } // method1()
    static void method2() {
        throw new NullPointerException(); // NullPointerException . 을 발생시킨다
    }
}

