package chapter15.readSevenTimes;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;

public class HexaViewer_R7 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: java HexaViewer_R7 CLASSFILENAME");
            System.exit(0);
        }

        String classFileName = args[0];
        File classFile = new File(classFileName);

        if (!classFile.exists() || classFile.isDirectory()) {
            System.out.println(classFileName + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
            System.exit(0);
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(classFile);
            PrintStream out = new PrintStream(System.out);

            int ch, count = 0;
            while ((ch = fileInputStream.read()) != -1) {
                out.printf("%02X ", ch);
                // 16개 출력 후 줄바꿈
                if ((++count) % 16 == 0) out.printf("%n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
    git bash 실행 시 한글 주석 에러
    javac HexaViewer_R7.java
    => 해결
    - 인코딩 문제 해결을 위해 컴파일할 때 다음과 같이 인코딩을 명시
    javac -encoding UTF-8 HexaViewer_R7.java
    => 이유
    - 한글 문자열 인코딩 문제: "16개 출력 후 줄바꿈" 부분에서
      한글 인코딩이 javac 컴파일러 설정과 맞지 않을 수 있습니다.
 */