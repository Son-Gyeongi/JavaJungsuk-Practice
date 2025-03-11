package chapter07.readSevenTimes;

class Product7_3_R7 {
    int price; // 제품의 가격
    int bonusPoint; // 제품 구매 시 제공하는 보너스점수
    
    /*
    1. 해결
     */
    Product7_3_R7() {

    }

    public Product7_3_R7(int price) {
        this.price = price;
        this.bonusPoint = (int) (price / 10.0);
    }
}

class Tv7_3_R7 extends Product7_3_R7 {
    /*
    1. super() 로 조상 클래스의 생성자를 호출하는 코드를 컴파일러가 추가해준다.
    그런데 Product 에 기본 생성자가 없어서 에러가 발생
     */
    Tv7_3_R7() {

    }
    
    /*
    2. 조상 클래스에 기본 생성자를 주지 않는다면
    Tv 클래스에서 super(100) 으로 조상 클래스에 있는 생성자를 호출한다.
     */
//    Tv7_3_R7() {
//        super(100); // 2. 해결
//    }

    @Override
    public String toString() {
        return "Tv";
    }
}

public class Practice7_3_R7 {
    public static void main(String[] args) {
        Tv7_3_R7 tv = new Tv7_3_R7();
    }
}
