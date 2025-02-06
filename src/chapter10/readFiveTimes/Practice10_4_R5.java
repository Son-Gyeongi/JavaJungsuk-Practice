package chapter10.readFiveTimes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Practice10_4_R5 {
    public static void main(String[] args) {
        // 날짜 패턴
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // 생일
        Calendar birthDay = Calendar.getInstance();
        birthDay.set(1995, 0, 31);
        // birthDay.set(1995, Calendar.JANUARY, 31); 같다.

        // 오늘 날짜
        Calendar today = Calendar.getInstance();

        long diff = today.getTimeInMillis() - birthDay.getTimeInMillis();
        long diffDays = diff / (24 * 60 * 60 * 1000); // 24시간 60분 60초 1000ms 를 나누면 일(days)이 나온다.

        System.out.println("birth day=" + simpleDateFormat.format(birthDay.getTime()));
        System.out.println("today =" + simpleDateFormat.format(today.getTime()));
        System.out.println(diffDays + " days");
    }
}
