package chapter09.readSevenTimes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice9_6_R7 {
    public static void main(String[] args) {
        String[] phoneNumArr = {
                "012-3456-7890",
                "099-2456-7980",
                "088-2346-9870",
                "013-3456-7890"
        };

        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(">>");
            String input = scanner.nextLine().trim();

            if (input.equals("")) {
                continue;
            } else if (input.equalsIgnoreCase("Q")) {
                System.exit(0);
            }

            // Pattern, Matcher 클래스를 사용할 것
            String pattern = ".*" + input + ".*"; // 입력받은 문자열(input)을 모두 포함하는 문자열
            Pattern compilePattern = Pattern.compile(pattern);

            for (int i = 0; i < phoneNumArr.length; i++) {
                String num = phoneNumArr[i].replace("-", ""); // phoneNum 에서 "-"를 제거
                Matcher matcher = compilePattern.matcher(num);

                /*
                Matcher 클래스의 find()
                - 패턴이 일치하는 다음 문자열을 찾는다. 다음 문자열이 있다면 true
                - 한 문자열에서 여러 패턴을 찾을 수 있다.
                 */
                if (matcher.find()) // 패턴과 일치하면 list 에 phoneNum 추가
                    list.add(phoneNumArr[i]);

                /*
                Matcher 클래스의 matches()
                - 패턴에 전체 문자열이 일치한 경우 true 를 반환
                - 문자열 전체가 패턴과 일치하는지 확인한다.
                 */
//                if (matcher.matches())
//                    list.add(phoneNumArr[i]);
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
