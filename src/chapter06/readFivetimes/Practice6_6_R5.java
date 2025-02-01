package chapter06.readFivetimes;

class MyPoint_C6_R5 {
    int x;
    int y;

    public MyPoint_C6_R5() {
    }

    public MyPoint_C6_R5(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(int x, int y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }
}

public class Practice6_6_R5 {
    public static void main(String[] args) {
        MyPoint_C6_R5 p = new MyPoint_C6_R5(1, 1);

        // p 와 (2,2)의 거리를 구한다.
        System.out.println(p.getDistance(2, 2));
    }
}
