package chapter07.readFiveTimes;

class Product7_3_R5 {
    int price; // 제품의 가격
    int bonusPoint; // 제품 구매 시 제공하는 보너스 점수

    public Product7_3_R5(int price) {
        this.price = price;
        this.bonusPoint = (int) (price / 10.0);
    }

    // 첫 번째 방법
//    public Product7_3_R5() {
//    }
}

class Tv7_3_R5 extends Product7_3_R5 {
    // 첫 번째 방법
//    Tv7_3_R5() {}

    // 두 번째 방법
    Tv7_3_R5() {
        super(100);
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

public class Practice7_3_R5 {
    public static void main(String[] args) {
        Tv7_3_R5 t = new Tv7_3_R5();
    }
}
