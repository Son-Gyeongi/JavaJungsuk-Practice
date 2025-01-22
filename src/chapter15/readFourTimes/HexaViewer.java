package chapter15.readFourTimes;

import java.io.*;

/*
지정된 이진파일(.class)의 내용을 16진수로 보여주는 프로그램
 */
public class HexaViewer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: java HexaViewer CLASSNAME");
            System.exit(0);
        }

        File file = new File(args[0]);

        if (!file.exists() || file.isDirectory()) {
            System.out.println(args[0] + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
            System.exit(0);
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int data = 0;

            int count = 0;
            while ((data = bufferedInputStream.read()) != -1) {
                count++;
                System.out.printf("%02X ", data);
                if (count == 16) {
                    count = 0;
                    System.out.println();
                }
            }
            bufferedInputStream.close();
        } catch (Exception e) {}
    }
}
