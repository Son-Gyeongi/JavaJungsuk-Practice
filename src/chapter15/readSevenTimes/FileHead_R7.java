package chapter15.readSevenTimes;

import java.io.*;

public class FileHead_R7 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("USAGE: java FileHead_R7 10 FILENAME");
            System.exit(0);
        }

        int count = 0;

        try {
            count = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("USAGE: java FileHead_R7 10 FILENAME");
            System.exit(0);
        }

        String fileName = args[1];
        File file = new File(fileName);

        if (!file.exists() || file.isDirectory()) {
            System.out.println(fileName + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
            System.exit(0);
        }

        try {
            FileReader fileInputStream = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileInputStream);

            String line;

            for (int i = 1; (line = bufferedReader.readLine()) != null && i <= count; i++) {
                System.out.printf("%d:%s%n", i, line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
