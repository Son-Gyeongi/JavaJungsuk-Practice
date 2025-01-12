package chapter06.readFourTimes;

public class Practice6_6 {

    public static void main(String[] args) {
        MyPoint p = new MyPoint(1, 1);

        // p 와 (2,2) 의 거리를 구한다.
        System.out.println(p.getDistance(2, 2));
    }
}
