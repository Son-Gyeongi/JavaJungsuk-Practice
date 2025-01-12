package chapter15.readThreeTimes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
내가 한 답 - 잘 나옴
 */
public class Practice15_1 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("USAGE: java Practice15_1 10 FILENAME");
            System.exit(0);
        }

        File file = new File(args[1]);
        if (!file.exists() || file.isDirectory()) {
            System.out.println(args[1] + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
            System.exit(0);
        }

        try {
            FileReader fileReader = new FileReader(args[1]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            for (int i = 1; (line = bufferedReader.readLine()) != null;) {
                if (i==(Integer.parseInt(args[0])+1)) break;
                System.out.println(i + ":" + line);
                /*
                예제 답에 import 문이 없어서 뺀 버전도 만들었다.
                if (!line.startsWith("import")){
                    System.out.println(i + ":" + line);
                    i++;
                }
                 */
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
