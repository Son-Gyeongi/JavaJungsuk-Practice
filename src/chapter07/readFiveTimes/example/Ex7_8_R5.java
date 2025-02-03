package chapter07.readFiveTimes.example;

class Product7_8_R5 {
    int price; // 제품의 가격
    int bonusPoint; // 제품 구매 시 제공하는 보너스 점수

    public Product7_8_R5(int price) {
        this.price = price;
        this.bonusPoint = (int) (price / 10.0); // 보너스 점수는 제품 가격의 10%
    }
}

class Tv7_8_R5 extends Product7_8_R5 {
    Tv7_8_R5() {
        // 조상클래스의 생성자 Product7_8_R5(int price) 를 호출한다.
        super(100); // Tv 가격을 100만원으로 한다.
    }

    // Object 클래스의 toString()을 오버라이딩한다.
    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer_7_8_R5 extends Product7_8_R5 {
    Computer_7_8_R5() {
        super(200); // Computer 가격을 200만원으로 한다.
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Buyer_7_8_R5 { // 고객, 물건을 사는 사람
    int money = 1000; // 소유금액
    int bonusPoint = 0; // 보너스점수

    // 매개변수의 다형성 예제
    void buy(Product7_8_R5 p) {
        if (money < p.price) {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }

        money -= p.price; // 가진 돈에서 구입한 제품의 가격을 뺀다.
        bonusPoint += p.bonusPoint; // 제품의 보너스 점수를 추가한다.
        System.out.println(p + "을/를 구입하셨습니다.");
    }
}

public class Ex7_8_R5 {
    public static void main(String[] args) {
        Buyer_7_8_R5 b = new Buyer_7_8_R5();

        b.buy(new Tv7_8_R5());
        b.buy(new Computer_7_8_R5());
        System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
        System.out.println("현재 보너스 점수는 " + b.bonusPoint + "점입니다.");
    }
}
