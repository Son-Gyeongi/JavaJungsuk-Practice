package chapter04.readFiveTimes;

public class Practice4_5_R5 {
    public static void main(String[] args) {
        // 이중 while 문
        int i = 0;

        while (i <= 10) {
            int j = 0;

            while (j <= i) {
                System.out.print("*");

                j++;
            }

            System.out.println();
            i++;
        }

        /*
        이중 for 문
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
         */
    }
}
