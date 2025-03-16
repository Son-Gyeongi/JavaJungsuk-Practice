package chapter11.readSevenTimes;

public class Sutda11_5_R7 {
    int num;
    boolean isKwang;

    public Sutda11_5_R7() {
        this(1, true);
    }

    public Sutda11_5_R7(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    // HashSet 에 중복된 카드가 저장되지 않도록 hashCode()를 오버라이딩
    @Override
    public int hashCode() {
        // String 클래스의 hashCode() 사용
        return toString().hashCode();
    }

    // HashSet 에 중복된 카드가 저장되지 않도록 equals()를 오버라이딩
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sutda11_5_R7 sutda) {
            return this.num == sutda.num && this.isKwang == sutda.isKwang;
        }

        return false;
    }

    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}
