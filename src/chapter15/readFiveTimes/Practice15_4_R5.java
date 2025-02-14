package chapter15.readFiveTimes;

import java.io.File;
import java.util.Scanner;

/*
콘솔 명령어 중에서 디렉토리를 변경하는 cd 명령을 구현한 것이다.
cd() 를 완성하시오.
 */
public class Practice15_4_R5 {
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
                String prompt = curDir.getCanonicalPath() + ">>";
                System.out.print(prompt);

                // 화면으로부터 라인단위로 입력받는다.
                String input = scanner.nextLine();

                input = input.trim(); // 입력받은 값에서 불필요한 앞뒤 공백을 제거한다.
                argArr = input.split(" +"); // 공백을 기준으로 문자열을 나눈다.

                String command = argArr[0].trim();

                if ("".equals(command)) continue;

                command = command.toLowerCase(); // 명령어를 소문자로 바꾼다.

                if (command.equals("q")) { // q 또는 Q 를 입력하면 실행종료한다.
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
        // 필요한 데이터 유효성 검사 필수
        if (argArr.length == 1) {
            System.out.println(curDir); // cd 만 입력된 경우 현재 경로만 보여준다.
            return;
        } else if (argArr.length > 2) {
            System.out.println("USAGE: cd directory"); // cd 명령어 다음에 한 개의 디렉토리만 입력 가능하다.
            return;
        }

        String subDir = argArr[1];

        // 1. 입력된 디렉토리(subDir)가 ".." 이면,
        //  1.1 현재 디렉토리의 조상 디렉토리를 얻어서 현재 디렉토리로 지정한다.
        if (subDir.equals("..")) {
            // 파일의 조상 디렉토리를 String 으로 반환
//            System.out.println("curDir.getParent() = " + curDir.getParent());
            // 파일의 조상 디렉토리를 File 로 반환
//            System.out.println("curDir.getParentFile() = " + curDir.getParentFile());

            File parentFile = curDir.getParentFile();
            curDir = parentFile;
        } else if (subDir.equals(".")) {
            // 2. 입력된 디렉토리(subDir)가 "." 이면, 단순히 현재 디렉토리의 경로를 화면에 출력한다.
            System.out.println(curDir);
        } else {
            // 3. 1 또는 2의 경우가 아니면,
            //  3.1 입력된 디렉토리(subDir)가 현재 디렉토리의 하위 디렉토리인지 확인한다.
            File checkDir = new File(curDir + subDir);

            if (checkDir.isDirectory()) {
                // 3.2 확인 결과가 true 이면, 현재 디렉토리(curDir)을 입력된 디렉토리(subDir)로 변경한다.
                curDir = checkDir;
            } else {
                // 3.3 확인 결과가 false 이면, "유효하지 않은 디렉토리입니다."를 화면에 출력한다.
                System.out.println("유효하지 않은 디렉토리입니다.");
            }
        }
    }
}
