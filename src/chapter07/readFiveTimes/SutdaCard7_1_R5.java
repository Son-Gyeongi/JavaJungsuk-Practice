package chapter07.readFiveTimes;

public class SutdaCard7_1_R5 {
    int num;
    boolean isKwang;

    SutdaCard7_1_R5() {
        this(1, true);
    }

    public SutdaCard7_1_R5(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    // info() 대신 Object 클래스의 toString() 을 오버라이딩했다.
    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}
