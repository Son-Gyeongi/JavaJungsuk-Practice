package chapter07.readFiveTimes.example;

public class Ex7_7_R5 {
    public static void main(String[] args) {
        Car_7_7_R5 car = null;
        FireEngine7_7_R5 fe = new FireEngine7_7_R5();
        FireEngine7_7_R5 fe2 = null;

        fe.water();
        // 사용할 수 있는 멤버의 개수 조절
        car = fe;
//        car.water(); // Car 타입의 참조변수로 water() 호출할 수 없다.
        fe2 = (FireEngine7_7_R5) car;
        fe2.water();
    }
}

class Car_7_7_R5 {
    String color;
    int door;

    void drive() { // 운전하는 기능
        System.out.println("drive, Brrrrr~");
    }

    void stop() { // 멈추는 기능
        System.out.println("stop!!!");
    }
}

class FireEngine7_7_R5 extends Car_7_7_R5 { // 소방차
    void water() {
        // 물 뿌리는 기능
        System.out.println("water!!!");
    }
}
