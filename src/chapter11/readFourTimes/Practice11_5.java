package chapter11.readFourTimes;

import java.util.HashSet;
import java.util.Objects;

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    public SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    /*
    HashSet 에 중복된 카드가 저장되지 않도록 SutdaCard 의 hashCode() 를 오버라이딩

    HashSet 의 경우 중복된 값을 비교할 때 equals() 와 hashCode() 로 비교한다.
     */
    @Override
    public int hashCode() {
        return toString().hashCode();
        //return ("" + num + isKwang).hashCode(); // String 의 hashCode() 를 사용
//        return Objects.hash(num, isKwang);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SutdaCard) {
            SutdaCard sutdaCard = (SutdaCard) obj;

            return this.num == sutdaCard.num && this.isKwang == sutdaCard.isKwang;
        }

        return false;
    }

    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

/*
SutdaCard 클래스를 HashSet 에 저장하고 출력하는 예제
 */
public class Practice11_5 {
    public static void main(String[] args) {
        SutdaCard c1 = new SutdaCard(3, true);
        SutdaCard c2 = new SutdaCard(3, true);
        SutdaCard c3 = new SutdaCard(1, true);

        HashSet set = new HashSet();
        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println(set);
    }
}
