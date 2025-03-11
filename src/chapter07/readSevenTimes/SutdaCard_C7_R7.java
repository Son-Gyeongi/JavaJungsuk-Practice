package chapter07.readSevenTimes;

/*
SutdaCard Chapter07 Read 7th
 */
public class SutdaCard_C7_R7 {
    int num;
    boolean isKwang;

    public SutdaCard_C7_R7() {
        this(1, true);
    }

    public SutdaCard_C7_R7(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    // info() 대신 Object 클래스의 toString()을 오버라이딩했다.
    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}
