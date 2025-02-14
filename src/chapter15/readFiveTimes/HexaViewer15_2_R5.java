package chapter15.readFiveTimes;

import java.io.File;
import java.io.FileInputStream;

/*
지정된 이진파일의 내용을 16진수로 보여주는 프로그램(HexaViewer15_2_R5) 작성
 */
public class HexaViewer15_2_R5 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: java HexaViewer15_2_R5.java CLASSFILE");
            System.exit(0);
        }
        
        String className = args[0];

        File classFile = new File(className);

        if (!classFile.exists() || classFile.isDirectory()) {
            System.out.println(className + "은/는 디렉토리이거나 존재하지 않는 클래스 파일입니다.");
            System.exit(0);
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(classFile);
            
            int data = 0;
            for (int i = 1; (data = fileInputStream.read()) != -1; i++) {
                System.out.printf("%02X", data);
                // 16개 문자 출력 후 다음 줄에 작성
                System.out.printf("%s", (i % 16 == 0 ? "\n" : " "));
            }

            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
