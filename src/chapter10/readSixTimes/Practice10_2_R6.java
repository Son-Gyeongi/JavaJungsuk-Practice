package chapter10.readSixTimes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Practice10_2_R6 {
    public static void main(String[] args) {
        String pattern = "yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("입력하신 날짜는 E요일입니다.");
        Date date;

        do {
            System.out.println("날짜를 " + pattern + "의 형태로 입력해주세요.(입력예:2017/05/11)");
            System.out.print(">>");
            String input = new Scanner(System.in).nextLine();

            try {
                date = simpleDateFormat1.parse(input);
                break;
            } catch (Exception e) {}
        } while (true);

        System.out.println(simpleDateFormat2.format(date));
    }
}
