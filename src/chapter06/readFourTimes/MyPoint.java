package chapter06.readFourTimes;

public class MyPoint {
    int x;
    int y;

    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 두 점 (x,y) 와 (x1,y1) 간의 거리를 구한다.
    double getDistance(int x1, int y1) {
        return Math.sqrt((this.x - x1) * (this.x - x1) + (this.y - y1) * (this.y - y1));
//        return Math.sqrt(Math.pow(this.x - x1, 2) + Math.pow(this.y - y1, 2));
    }
}
