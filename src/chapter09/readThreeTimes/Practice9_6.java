package chapter09.readThreeTimes;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice9_6 {
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
            String input = s.nextLine().trim();

            if (input.equals("")) {
                continue;
            } else if (input.equalsIgnoreCase("Q")) {
                System.exit(0);
            }

            for (int i = 0; i < phoneNumArr.length; i++) {
                String str = phoneNumArr[i];
                String[] strArr = str.split("-");
                String joinStr = String.join("", strArr);

                if (joinStr.contains(input)) list.add(str);
            }

            if (!list.isEmpty()) {
                System.out.println(list);
                list.clear();
            } else {
                System.out.println("일치하는 번호가 없습니다.");
            }
        }
    }
}
