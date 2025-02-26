package chapter09.readSixTimes;

public class Practice9_1_R6 {
    public static void main(String[] args) {
        SutdaCard9_1_R6 c1 = new SutdaCard9_1_R6(3, true);
        SutdaCard9_1_R6 c2 = new SutdaCard9_1_R6(3, true);

        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c1.equals(c2):" + c1.equals(c2));
    }
}

class SutdaCard9_1_R6 {
    int num;
    boolean isKwang;

    SutdaCard9_1_R6() {
        this(1, true);
    }

    public SutdaCard9_1_R6(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SutdaCard9_1_R6) {
            SutdaCard9_1_R6 sutda = (SutdaCard9_1_R6) obj;
            return this.num == sutda.num && this.isKwang == sutda.isKwang;
        }

        return false;
    }

    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}