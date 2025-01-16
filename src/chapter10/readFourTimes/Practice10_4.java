package chapter10.readFourTimes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Practice10_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = null; // 생일 입력

        while (true) {
            try {
                System.out.println("생일을 입력해주세요.(예시 2020-01-01)");
                System.out.print("birth day=");
                birthDate = sdf.parse(scanner.nextLine());
                break;
            } catch (Exception e) {}
        }

        Date today = new Date();
        System.out.println("today =" + sdf.format(today));

        // 차이 계산하기
        Calendar c1 = Calendar.getInstance();
        c1.setTime(birthDate);
        Calendar c2 = Calendar.getInstance();
//        c2.set(2016, 0, 29); 예제
        c2.setTime(today);
        // 날짜 차이
        long days = (c2.getTimeInMillis() - c1.getTimeInMillis()) / (24 * 60 * 60 * 1000);
        System.out.println(days + " days");
    }
}
