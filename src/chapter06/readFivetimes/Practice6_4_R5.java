package chapter06.readFivetimes;

public class Practice6_4_R5 {
    // 두 점 (x,y)와 (x1,x2)간의 거리를 구한다.
    static double getDistance(int x, int y, int x1, int y1) {
        // a제곱+b제곱 = c제곱 활용
        return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
    }

    public static void main(String[] args) {
        System.out.println(getDistance(1, 1, 2, 2));
    }
}
