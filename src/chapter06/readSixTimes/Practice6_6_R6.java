package chapter06.readSixTimes;

public class Practice6_6_R6 {
    public static void main(String[] args) {
        MyPoint_C6_R6 p = new MyPoint_C6_R6(1, 1);

        // p 와 (2,2)의 거리를 구한다.
        System.out.println(p.getDistance(2, 2));
    }
}
