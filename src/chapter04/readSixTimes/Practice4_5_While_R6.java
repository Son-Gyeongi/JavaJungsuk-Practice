package chapter04.readSixTimes;

public class Practice4_5_While_R6 {
    public static void main(String[] args) {
        int i=0;

        while (i <= 10) {
            int j=0;

            while (j <= i) {
                System.out.print("*");
                j++;
            }

            System.out.println();
            i++;
        }
    }
}
