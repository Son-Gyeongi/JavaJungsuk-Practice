package chapter15.readFiveTimes;

import java.io.*;

/*
커맨드라인으로 부터 파일명과 숫자를 입력받아서,
입력받은 파일의 내용의 처음부터 입력 받은 숫자만큼의
라인을 출력하는 프로그램(FileHead15_1_R5.java)를 작성
 */
public class FileHead15_1_R5 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("USAGE: java FileHead15_1_R5.java 10 FILENAME");
            System.exit(0);
        }

        int lineNum = Integer.parseInt(args[0]); // 줄 수
        String fileName = args[1]; // 파일명

        File file = new File(fileName);

        if (!file.exists() || file.isDirectory()) {
            System.out.println(fileName + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
            System.exit(0);
        }

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            for (int i = 1; i <= lineNum; i++) {
                line = bufferedReader.readLine();

                if (line == null) break; // 더이상 읽어올 값이 없으면 반복문 종료

                System.out.println(i + ":" + line);
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
