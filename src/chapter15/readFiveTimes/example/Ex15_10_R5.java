package chapter15.readFiveTimes.example;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Ex15_10_R5 {
    public static void main(String[] args) {
        String inputData = "ABCD";
        StringReader input = new StringReader(inputData); // String 으로 처리
        StringWriter output = new StringWriter();

        int data = 0; // 문자 1개 받아온다.

        try {
            while ((data = input.read()) != -1) {
                System.out.println(data);
                output.write(data); // void write(int b)
            }
        } catch (IOException e) {}

        System.out.println("Input Data  :" + inputData);
        System.out.println("Output Data :" + output.toString());
    }
}
