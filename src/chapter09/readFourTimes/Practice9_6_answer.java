package chapter09.readFourTimes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice9_6_answer {
    public static void main(String[] args) {
        String[] phoneNumber = {
                "012-3456-7890",
                "099-2456-7980",
                "088-2346-9870",
                "013-3456-7890"
        };

        ArrayList<String> list = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print(">>");
            String input = s.nextLine().trim();

            if (input.equals("")) {
                continue;
            } else if (input.equalsIgnoreCase("Q")) {
                System.exit(0);
            }

            // Pattern, Matcher 클래스 사용할 것
            // . 은 임의의 문자 1개, * 은 0 개 이상 문자 올 수 있다는 뜻
            String pattern = ".*" + input + ".*"; // input 을 포함하는 모든 문자열
            Pattern p = Pattern.compile(pattern); // 패턴 생성(컴파일된 패턴)

            for (int i = 0; i < phoneNumber.length; i++) {
                String phoneNum = phoneNumber[i];
                // '-' 없이 숫자 일치 검증
                String tmp = phoneNum.replace("-", ""); // phoneNum 에서 '-' 제거

                Matcher m = p.matcher(tmp); // 컴파일된 패턴을 사용해서 Matcher 객체 생성

                if (m.find()) list.add(phoneNum); // 패턴과 일치하면 list 에 phoneNum 추가
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
