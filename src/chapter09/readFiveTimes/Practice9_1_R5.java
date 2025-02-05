package chapter09.readFiveTimes;

public class Practice9_1_R5 {
    public static void main(String[] args) {
        SutdaCard9_1_R5 c1 = new SutdaCard9_1_R5(3, true);
        SutdaCard9_1_R5 c2 = new SutdaCard9_1_R5(3, true);

        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c1.equals(c2):" + c1.equals(c2));
    }
}

class SutdaCard9_1_R5 {
    int num;
    boolean isKwang;

    SutdaCard9_1_R5() {
        this(1, true);
    }

    public SutdaCard9_1_R5(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SutdaCard9_1_R5) {
            SutdaCard9_1_R5 sutda = (SutdaCard9_1_R5) obj;
            return num == sutda.num && isKwang == sutda.isKwang;
        }

        return false;
    }

    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}