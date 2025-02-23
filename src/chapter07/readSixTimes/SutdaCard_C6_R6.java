package chapter07.readSixTimes;

/*
SutdaCard Chapter06 Read 6th
 */
public class SutdaCard_C6_R6 {
    int num;
    boolean isKwang;

    SutdaCard_C6_R6() {
        this(1, true);
    }

    public SutdaCard_C6_R6(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    // info() 대신 Object 클래스의 toString() 을 오버라이딩했다.

    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}
