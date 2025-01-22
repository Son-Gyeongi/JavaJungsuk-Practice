package chapter15.readFourTimes;

import java.io.File;
import java.util.Scanner;

/*
콘솔 명령어 중에서 디렉토리를 변경하는 cd 명령을 구현
 */
public class Practice15_4 {
    static String[] argArr; // 입력한 매개변수를 담기위한 문자열배열
    static File curDir; // 현재 디렉토리
    
    // 클래스(static) 변수 초기화 블럭
    static {
        try {
            curDir = new File(System.getProperty("user.dir"));
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String prompt = curDir.getCanonicalPath() + ">>"; // 현재 정규 경로
                System.out.print(prompt);

                // 화면으로부터 라인단위로 입력받는다.
                String input = scanner.nextLine();

                input = input.trim(); // 입력받은 값에서 불필요한 앞뒤 공백을 제거한다.
                argArr = input.split(" +"); // 1개 이상 공백을 기준으로 input 을 나눈다.

                String command = argArr[0].trim();

                if ("".equals(command)) continue;

                command = command.toLowerCase(); // 명령어를 소문자로 바꾼다.

                if (command.equals("q")) { // q 또는 Q 를 입력하면 실행종료된다.
                    System.exit(0);
                } else if (command.equals("cd")) {
                    cd();
                } else {
                    for (String arg : argArr) {
                        System.out.println(arg);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("입력오류입니다.");
            }
        } // while(true)
    } // main

    public static void cd() {
        if (argArr.length == 1) {
            System.out.println(curDir);
            return;
        } else if (argArr.length > 2) {
            System.out.println("USAGE : cd directory");
            return;
        }

        String subDir = argArr[1];

        /*
        1. 입력된 디렉토리(subDir)가 ".." 이면,
            1.1 현재 디렉토리의 조상 디렉토리를 얻어서 현재 디렉토리로 지정한다.
            (File 클래스의 getParentFile()을 사용)
         */
        if (subDir.equals("..")) {
//            String parentPath = curDir.getParent();
//            curDir = new File(parentPath);

            // 내가 한 거
//            curDir = curDir.getParentFile();

            // null 검사 - 책 답
            File newDir = curDir.getParentFile();
            if (newDir == null) {
                System.out.println("유효하지 않은 디렉토리입니다.");
            } else {
                curDir = newDir;
            }
        } else if (subDir.equals(".")) {
            /*
            2. 입력된 디렉토리(subDir)가 "."이면,
            단순히 현재 디렉토리의 경로를 화면에 출력한다.
             */
            System.out.println(curDir);
        } else {
            /*
            3. 1 또는 2의 경우가 아니며,
                3.1 입력된 디렉토리(subDir)가 현재 디렉토리의 하위 디렉토리인지 확인한다.
             */
            File subDirCheck = new File(curDir, subDir);

            if (subDirCheck.isDirectory() && subDirCheck.exists()) {
                /*
                3.2 확인 결과가 true 이면,
                현재 디렉토리(curDir)를 입력된 디렉토리(subDir)로 변경한다.
                 */
                curDir = subDirCheck;
            } else {
                /*
                3.3 확인 결과가 false 이면,
                "유효하지 않은 디렉토리입니다."를 화면에 출력한다.
                 */
                System.out.println("유효하지 않은 디렉토리입니다.");
            }
        }
    }
}
