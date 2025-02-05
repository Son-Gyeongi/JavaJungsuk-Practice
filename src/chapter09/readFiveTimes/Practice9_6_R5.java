package chapter09.readFiveTimes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice9_6_R5 {
    public static void main(String[] args) {
        String[] phoneNumArr = {
                "012-3456-7890",
                "099-2456-7980",
                "088-2346-9870",
                "013-3456-7890"
        };

        ArrayList<String> list = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print(">>");
            String input = s.nextLine().trim(); // 사용자에게 값을 받아올 때 유효성 검사 필수

            if (input.equals("")) {
                continue;
            } else if (input.equalsIgnoreCase("Q")) {
                System.exit(0); // 프로그램 종료
            }

            // 입력받은 전화번호와 일치하는 번화번호를 찾아서 출력
            // Pattern, Matcher 클래스 사용
            // 정규식 .* - 어떤 문자든 0개 이상 존재할 수 있음, input - 입력값이 문자열에 존재해야 함
            Pattern pattern = Pattern.compile(".*(" + input + ").*"); // 패턴 생성
            // ".*(" + input + ").*" 도 가능 (입력값을 그룹으로 묶어 매칭)
            // ".*" + input + ".*" 도 가능 (입력값이 문자열 어디에든 포함되면 매칭)

            for (int i = 0; i < phoneNumArr.length; i++) {
                String checkValue = phoneNumArr[i].replace("-", "");
                // matcher()[Pattern 클래스] - 패턴에 매칭할 문자열을 입력해 Matcher 를 생성
                Matcher matcher = pattern.matcher(checkValue);
                // 만약에 패턴이 일치하면 list 에 값을 저장
                // matches()[Matcher 클래스] - 패턴에 전체 문자열이 일치한 경우 true 를 반환
                if (matcher.matches()) list.add(phoneNumArr[i]);
            }

            if (!list.isEmpty()) { // list.size() > 0
                System.out.println(list);
                list.clear();
            } else {
                System.out.println("일치하는 번호가 없습니다.");
            }
        }
    }
}
