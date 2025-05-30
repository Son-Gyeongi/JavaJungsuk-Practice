package chapter06.readSevenTimes;

public class Practice6_4_R7 {
    // 두 점 (x,y) 와 (x1,y1) 간의 거리를 구한다.
    public static double getDistance(int x, int y, int x1, int y1) {
        return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
    }

    public static void main(String[] args) {
        System.out.println(getDistance(1, 1, 2, 2));
    }
}
