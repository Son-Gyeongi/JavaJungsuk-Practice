package chapter10.readSevenTimes.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
화면으로부터 날짜를 입력받아서 계산결과를 출력
 */
public class Ex10_10_DoWhile {
    public static void main(String[] args) {
        String pattern = "yyyy/MM/dd";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Scanner scanner = new Scanner(System.in);

        Date inDate = null;

        do {
            System.out.println("날짜를 " + pattern + "의 형태로 입력해주세요.(입력예:2019/12/31)");

            try {
                inDate = dateFormat.parse(scanner.nextLine());
                break;
            } catch (Exception e) {}

        } while (true);

        Calendar cal = Calendar.getInstance();
        cal.setTime(inDate);
        Calendar today = Calendar.getInstance();
        long time = (cal.getTimeInMillis() - today.getTimeInMillis()) / (60 * 60 * 1000);
        System.out.println("입력하신 날짜는 현재와 " + time + "시간 차이가 있습니다.");
    }
}
