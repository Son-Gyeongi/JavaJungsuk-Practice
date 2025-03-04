package chapter15.readSixTimes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileHead_R6 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("USAGE: java FileHead.java 10 FILENAME");
            System.exit(0);
        }

        int count = Integer.parseInt(args[0]);
        String fileName = args[1];

        File file = new File(fileName);

        if (!file.exists() || file.isDirectory()) {
            System.out.println(fileName + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
            System.exit(0);
        }

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";

            for (int i = 1; i <= count; i++) {
                line = bufferedReader.readLine();

                if (line == null) break;

                System.out.println(i + ":" + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
