package chapter09.readSevenTimes;

public class Practice9_1_R7 {
    public static void main(String[] args) {
        SutdaCard9_1_R7 c1 = new SutdaCard9_1_R7(3, true);
        SutdaCard9_1_R7 c2 = new SutdaCard9_1_R7(3, true);

        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c1.equals(c2):" + c1.equals(c2));
    }
}

class SutdaCard9_1_R7 {
    int num;
    boolean isKwang;

    public SutdaCard9_1_R7() {
        this(1, true);
    }

    public SutdaCard9_1_R7(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SutdaCard9_1_R7 sutda) { // SutdaCard9_1_R7 sutda = (SutdaCard9_1_R7) obj
            return this.num == sutda.num && this.isKwang == sutda.isKwang;
        }

        return false;
    }

    @Override
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}