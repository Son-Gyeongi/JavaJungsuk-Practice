package chapter15.readFourTimes;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
커맨드라인으로 부터 파일명과 숫자를 입력받아서,
입력받은 파일의 내용을 처음부터 입력 받은 숫자만큼의 라인을 출력하는 프로그램
 */
public class FileHead {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("USAGE: java FileHead LINE_NUMBER FILENAME");
            System.exit(0);
        }

        int lineNumber = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        if (!file.exists() || file.isDirectory()) {
            System.out.println(args[1] + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
            System.exit(0);
        }

        try {
            // FileReader 는 따로 인코딩하는 설정이 없어서 한글이 깨져서 나올 수 있다.
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            FileInputStream fileInputStream = new FileInputStream(file);
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = ""; // 입력
            int count = 0; // 라인 수
            
            // 파일의 라인 수가 LINE_NUMBER 보다 적을 경우 : bufferedReader.readLine() != null 활용
            // 파일의 라인 수가 LINE_NUMBER 보다 많을 경우 : LINE_NUMBER 사용
            while ((line = bufferedReader.readLine()) != null) {
                count++;
                if (count > lineNumber) break;
                System.out.println(count + ":" + line);
            }
            bufferedReader.close();
        } catch (Exception e) {}
    }
}
