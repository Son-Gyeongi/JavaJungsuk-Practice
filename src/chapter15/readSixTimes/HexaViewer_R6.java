package chapter15.readSixTimes;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;

public class HexaViewer_R6 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: java HexaViewer.java CLASSNAME");
            System.exit(0);
        }

        File file = new File(args[0]);

        /*
        git bash 실행 시 에러
        javac HexaViewer_R6.java
        => 해결
        - 인코딩 문제 해결을 위해 컴파일할 때 다음과 같이 인코딩을 명시
        javac -encoding UTF-8 HexaViewer_R6.java
        => 이유
        - 한글 문자열 인코딩 문제: "은/는 디렉토리이거나, 존재하지 않는 파일입니다." 부분에서
          한글 인코딩이 javac 컴파일러 설정과 맞지 않을 수 있습니다.
         */
        if (!file.exists() || file.isDirectory()) {
            System.out.println(args[0] + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
            System.exit(0);
        }

        int data = 0;

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            PrintStream printStream = new PrintStream(System.out);

            int count = 0;
            while ((data = fileInputStream.read()) != -1) {
                printStream.printf("%02X ", data);
                count++;
                if (count % 16 == 0) printStream.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
