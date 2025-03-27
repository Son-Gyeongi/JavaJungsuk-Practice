package chapter15.readSevenTimes.example;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

/*
페이지 626, 628
LineNumberReader 사용해보기
 */
public class Example15_1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: java Example15_1 FILENAME");
            System.exit(0);
        }

        String fileName = args[0];
        File file = new File(fileName);

        if (!file.exists() || file.isDirectory()) {
            System.out.println(fileName + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
            System.exit(0);
        }

        try {
            FileReader fileReader = new FileReader(file);
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

            String line;

            while ((line = lineNumberReader.readLine()) != null) {
                System.out.println(lineNumberReader.getLineNumber() + ": " + line);
            }

            lineNumberReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
