package chapter15.readThreeTimes;

import java.io.*;

public class Practice15_2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: java Practice15_2 FILENAME");
            System.exit(0);
        }

        try {
            FileInputStream input = new FileInputStream(args[0]);
            PrintStream output = new PrintStream(System.out);

            int data = 0;
            int i = 0;

            while ((data = input.read()) != -1) {
                output.printf("%02X ", data);
                if (++i % 16 == 0) {
                    output.println();
                }
            }

            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
