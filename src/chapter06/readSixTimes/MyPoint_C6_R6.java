package chapter06.readSixTimes;

/*
MyPoint Chapter06 Read 6th
 */
public class MyPoint_C6_R6 {
    int x;
    int y;

    public MyPoint_C6_R6(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(int x1, int y1) {
        // 인스턴스 메서드는 인스턴스 변수를 사용한다.
        return Math.sqrt((this.x - x1) * (this.x - x1) + (this.y - y1) * (this.y - y1));
    }
}
