package chapter10.readSixTimes.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex10_10 {
    public static void main(String[] args) {
        String pattern = "yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Scanner scanner = new Scanner(System.in);

        Date inDate = null;

        System.out.println("날짜를 " + pattern + "의 형태로 입력해주세요.(입력예:2019/12/31)");

        /*
        hasNextLine()
        입력 스트림에서 새로운 줄(line)이 있는지 확인하는 메서드
        사용자가 입력을 할 때까지 계속 대기하고, 새로운 줄이 들어오면 실행
         */
        while (scanner.hasNextLine()) {
            try {
                inDate = simpleDateFormat.parse(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("날짜를 " + pattern + "의 형태로 다시 입력해주세요.(입력예:2019/12/31)");
            }
        }

        Calendar cal = Calendar.getInstance();
        // Date -> Calendar 로 변경
        cal.setTime(inDate);
        Calendar today = Calendar.getInstance(); // 현재
        long time = (cal.getTimeInMillis() - today.getTimeInMillis()) / (60 * 60 * 1000); // 60분*60초*1000ms
        System.out.println("입력하신 날짜는 현재와 " + time + "시간 차이가 있습니다.");

        long day = time / 24; // 24시간
        System.out.println("입력하신 날짜는 현재와 " + day + "일 차이가 있습니다.");
    }
}
