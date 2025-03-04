package chapter15.readSixTimes;

import java.io.File;
import java.util.Scanner;

public class Practice15_4_R6 {
    static String[] argArr; // 입력한 매개변수를 담기위한 문자열배열
    static File curDir; // 현재 디렉토리

    static {
        try {
            curDir = new File(System.getProperty("user.dir"));
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String prompt = curDir.getCanonicalPath() + ">>";
                System.out.print(prompt);

                // 화면으로부터 라인단위로 입력받는다.
                String input = scanner.nextLine();

                input = input.trim(); // 입력받은 값에서 불필요한 앞뒤 공백을 제거한다.
                argArr = input.split(" +"); // 공백을 기준으로 input 을 배열로 저장한다.

                String command = argArr[0].trim();

                if ("".equals(command)) continue;

                command = command.toLowerCase(); // 명령어를 소문자로 바꾼다.

                if (command.equals("q")) { // q 또는 Q 를 입력하면 실행종료된다.
                    System.exit(0);
                } else if (command.equals("cd")) {
                    cd();
                } else {
                    for (int i = 0; i < argArr.length; i++) {
                        System.out.println(argArr[i]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("입력오류입니다.");
            }
        }
    }

    public static void cd() {
        if (argArr.length == 1) {
            System.out.println(curDir);
            return;
        } else if (argArr.length > 2) {
            System.out.println("USAGE: cd directory");
            return;
        }

        String subDir = argArr[1];

        if (subDir.equals("..")) {
            File parentFile = curDir.getParentFile();

            // 유효성 검사 - parentFile 가 존재하지 않을 수 있다.
            if (parentFile.exists() && parentFile.isDirectory()) curDir = parentFile;
        } else if (subDir.equals(".")) {
            System.out.println(curDir);
        } else {
            File subDirectory = new File(curDir, subDir);

            if (subDirectory.exists() && subDirectory.isDirectory()) {
                curDir = subDirectory;
            } else {
                System.out.println("유효하지 않은 디렉토리입니다.");
            }
        }
    }
}
