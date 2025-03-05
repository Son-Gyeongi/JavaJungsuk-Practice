package chapter15.readSixTimes.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Ex15_14 {
    public static void main(String[] args) {
        PrintStream ps = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("test_R6.txt");
            ps = new PrintStream(fos);
            System.setOut(ps); // System.out 의 출력대상을 test_R6.txt 파일로 변경
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }

        System.out.println("Hello by System.out");
        System.err.println("Hello by System.err");
    }
}
