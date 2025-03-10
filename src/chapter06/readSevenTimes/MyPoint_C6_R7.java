package chapter06.readSevenTimes;

/*
MyPoint Chapter06 Read 7th
 */
public class MyPoint_C6_R7 {
    int x;
    int y;

    public MyPoint_C6_R7(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(int x, int y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }
}
