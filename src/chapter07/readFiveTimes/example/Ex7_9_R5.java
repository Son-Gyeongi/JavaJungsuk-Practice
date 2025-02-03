package chapter07.readFiveTimes.example;

class Product7_9_R5 {
    int price; // 제품의 가격
    int bonusPoint; // 제품 구매 시 제공하는 보너스 점수

    public Product7_9_R5(int price) {
        this.price = price;
        this.bonusPoint = (int) (price / 10.0); // 보너스 점수는 제품 가격의 10%
    }

    // 기본 생성자
    public Product7_9_R5() {
    }
}

class Tv7_9_R5 extends Product7_9_R5 {
    Tv7_9_R5() {
        // 조상클래스의 생성자 Product7_9_R5(int price) 를 호출한다.
        super(100); // Tv 가격을 100만원으로 한다.
    }

    // Object 클래스의 toString()을 오버라이딩한다.
    @Override
    public String toString() {
        return "Tv";
    }
}

class Computer_7_9_R5 extends Product7_9_R5 {
    Computer_7_9_R5() {
        super(200); // Computer 가격을 200만원으로 한다.
    }

    @Override
    public String toString() {
        return "Computer";
    }
}

class Audio_7_9_R5 extends Product7_9_R5 {
    Audio_7_9_R5() {
        super(50); // Audio 가격을 50만원으로 한다.
    }

    @Override
    public String toString() {
        return "Audio";
    }
}

class Buyer_7_9_R5 { // 고객, 물건을 사는 사람
    int money = 1000; // 소유금액
    int bonusPoint = 0; // 보너스점수
    Product7_9_R5[] cart = new Product7_9_R5[10]; // 구입한 제품을 저장하기 위한 배열(장바구니)
    int i = 0;

    // 매개변수의 다형성 예제
    void buy(Product7_9_R5 p) {
        if (money < p.price) {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }

        money -= p.price; // 가진 돈에서 구입한 제품의 가격을 뺀다.
        bonusPoint += p.bonusPoint; // 제품의 보너스 점수를 추가한다.
        cart[i++] = p; // 제품을 Product7_9_R5[] cart 에 저장한다.
        System.out.println(p + "을/를 구입하셨습니다.");
    }

    void summary() { // 구매한 물품에 대한 정보를 요약해서 보여준다.
        int sum = 0; // 구입한 물품의 가격 합계
        String itemList = ""; // 구입한 물품 목록

        // 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
        for (int i = 0; i < cart.length; i++) {
            if (cart[i] == null) break;
            sum += cart[i].price;
            itemList += (i == 0) ? "" + cart[i] : ", " + cart[i];
        }

        System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
        System.out.println("구입하신 제품은 " + itemList + "입니다.");
    }
}

public class Ex7_9_R5 {
    public static void main(String[] args) {
        Buyer_7_9_R5 b = new Buyer_7_9_R5();

        b.buy(new Tv7_9_R5());
        b.buy(new Computer_7_9_R5());
        b.buy(new Audio_7_9_R5());
        b.summary();
    }
}
