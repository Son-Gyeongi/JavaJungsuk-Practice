package chapter15.readSixTimes.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
페이지 632
 */
public class Ex15_3 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        System.out.println("Input Source :" + Arrays.toString(inSrc));

        try {
            while (input.available() > 0) {
                /*
                input.available() - 현재 읽을 수 있는 바이트 수를 반환
                ByteArrayInputStream 에서는 읽지 않은 남은 바이트의 개수를 알려줌
                 */
                System.out.println("input.available() : " + input.available());
                input.read(temp);
                output.write(temp);

                outSrc = output.toByteArray();
                printArrays(temp, outSrc);
                System.out.println();
            }
        } catch (IOException e) {}
    }

    static void printArrays(byte[] temp, byte[] outSrc) {
        System.out.println("temp          :" + Arrays.toString(temp));
        System.out.println("Output Source :" + Arrays.toString(outSrc));
    }
}
