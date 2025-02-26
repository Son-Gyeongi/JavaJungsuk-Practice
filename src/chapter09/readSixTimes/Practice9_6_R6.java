package chapter09.readSixTimes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice9_6_R6 {
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
            System.out.print("번호를 입력해주세요.(프로그램 종료를 원하면 Q를 눌러주세요.)>>");
            String input = scanner.nextLine().trim(); // 사용자 입력 받을 시 양쪽 공백 제거

            // 사용자 입력 받을 시 유효성 검사 필수
            if (input.equals("")) {
                continue;
            } else if (input.equalsIgnoreCase("Q")) {
                System.exit(0);
            }

            // Pattern, Matcher 클래스 사용하기
            // 패턴 생성 - input 과 정확하게 일치하는 게 아닌 input 양쪽으로 다른 값이 올 수도 있다.
            Pattern pattern = Pattern.compile(".*" + input + ".*");
            // input 을 포함하는 모든 문자열
            // 정규식 .* - 어떤 문자든 0개 이상 존재할 수 있음, input - 입력값이 문자열에 존재해야 함
            // . 은 임의의 문자 1개, * 은 0 개 이상 문자 올 수 있다는 뜻

            for (int i = 0; i < phoneNumArr.length; i++) {
                String num = phoneNumArr[i].replace("-", "");

                Matcher matcher = pattern.matcher(num); // 주어진 패턴과 검사해야할 문자열이 일치하는지
                if (matcher.matches()) list.add(phoneNumArr[i]);
            }

            if (list.size() > 0) {
                System.out.println(list);
                list.clear();
            } else {
                System.out.println("일치하는 번호가 없습니다.");
            }
        }
    }
}
