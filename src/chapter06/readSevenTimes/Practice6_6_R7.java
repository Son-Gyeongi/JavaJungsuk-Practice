package chapter06.readSevenTimes;

public class Practice6_6_R7 {
    public static void main(String[] args) {
        MyPoint_C6_R7 myPoint = new MyPoint_C6_R7(1, 1);

        // myPoint 와 (2,2)의 거리를 구한다.
        System.out.println(myPoint.getDistance(2, 2));
    }
}
