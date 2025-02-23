package chapter07.readSixTimes;

class Product_C6_R6 {
    int price; // 제품의 가격
    int bonusPoint; // 제품구매 시 제공하는 보너스 점수

    public Product_C6_R6(int price) {
        this.price = price;
        this.bonusPoint = (int) (price / 10.0);
    }
}

class Tv_C6_R6 extends Product_C6_R6 {
    Tv_C6_R6() {
        // 조상의 멤버는 조상의 생성자를 통해 초기화
        super(100);
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

public class Practice7_3_R6 {
    public static void main(String[] args) {
        Tv_C6_R6 t = new Tv_C6_R6();
    }
}
