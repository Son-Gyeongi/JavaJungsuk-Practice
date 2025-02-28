package chapter11.readSixTimes;

import java.util.HashSet;

class SutdaCard11_5_R6 {
    int num;
    boolean isKwang;

    SutdaCard11_5_R6() {
        this(1, true);
    }

    public SutdaCard11_5_R6(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    @Override
    public int hashCode() {
        /*
        String 클래스의 hashCode() 를 사용

        String 클래스의 hashCode() 는 객체의 주소가 아닌 문자열의 내용을 기반으로
        해시코드를 생성하므로 문자열의 내용이 같으면 항상 같은 값의 해시코드를 반환한다.

        인스턴스 변수들의 값을 결합한 문자열을 만들고,
        그 문자열에 대한 hashCode() 를 호출
         */
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SutdaCard11_5_R6) {
            SutdaCard11_5_R6 sutda = (SutdaCard11_5_R6) obj;
            return num == sutda.num && isKwang == sutda.isKwang;
        }

        return false;
    }

    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

public class Practice11_5_R6 {
    public static void main(String[] args) {
        SutdaCard11_5_R6 s1 = new SutdaCard11_5_R6(3, true);
        SutdaCard11_5_R6 s2 = new SutdaCard11_5_R6(3, true);
        SutdaCard11_5_R6 s3 = new SutdaCard11_5_R6(1, true);

        /*
        Set 에 저장할 때 중복되지 않은 값을 확인해야 하므로
        equals(), hashCode() 를 호출한다. 그러므로 오버라이딩 필수
         */
        HashSet<SutdaCard11_5_R6> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);

        System.out.println(set);
    }
}
