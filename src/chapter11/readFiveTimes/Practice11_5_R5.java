package chapter11.readFiveTimes;

import java.util.HashSet;

class SutdaCard11_5_R5 {
    int num;
    boolean isKwang;

    SutdaCard11_5_R5() {
        this(1, true);
    }

    public SutdaCard11_5_R5(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    /*
    HashSet 에 중복된 카드가 저장되지 않도록 hashCode() 오버라이딩
    해시 알고리즘을 사용하는 HashSet 에 담을 때는 반드시 hashCode()도 오버라이딩 해줘야 한다.
     */
    @Override
    public int hashCode() {
        return toString().hashCode(); // String 클래스의 hashCode()를 사용
    }

    /*
    HashSet 에 중복된 카드가 저장되지 않도록 equals() 오버라이딩
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SutdaCard11_5_R5) {
            SutdaCard11_5_R5 sutda = (SutdaCard11_5_R5) obj;
            return num == sutda.num && isKwang == sutda.isKwang;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

public class Practice11_5_R5 {
    public static void main(String[] args) {
        SutdaCard11_5_R5 c1 = new SutdaCard11_5_R5(3, true);
        SutdaCard11_5_R5 c2 = new SutdaCard11_5_R5(3, true);
        SutdaCard11_5_R5 c3 = new SutdaCard11_5_R5(1, true);

        HashSet<SutdaCard11_5_R5> set = new HashSet<>();
        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println(set);
    }
}
