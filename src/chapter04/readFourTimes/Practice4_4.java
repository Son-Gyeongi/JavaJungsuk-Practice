package chapter04.readFourTimes;

public class Practice4_4 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;

        while (sum < 100) {
            sum += i % 2 == 1 ? i : -i;
            i++;
        }

//        int num = 0;
//        for (int i = 1; sum < 100; i++) {
//            sum += i % 2 == 1 ? i : -i;
//            num = i;
//        }

        System.out.println("i = " + (i-1)); // while 문에서 마지막에 i++을 해서 -1을 해줬다.
//        System.out.println("num = " + num);
        System.out.println("sum = " + sum);
    }
}
