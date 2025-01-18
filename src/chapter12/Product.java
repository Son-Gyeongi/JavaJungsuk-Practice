package chapter12;

public class Product {
    int price; // 제품의 가격
    int bonusPoint; // 제품 구매 시 제공하는 보너스점수

    Product() {}

    Product(int price) {
        this.price = price;
        this.bonusPoint = (int) (price / 10.0);
    }
}
