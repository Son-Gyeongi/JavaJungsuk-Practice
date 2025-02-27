package chapter10.readSixTimes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Practice10_4_R6 {
    public static void main(String[] args) {
        Calendar birthday = Calendar.getInstance();
        birthday.set(2000, 0, 1);
        Calendar today = Calendar.getInstance();
//        today.set(2016, 0, 29); // 예제

        // 차이 계산
        long diffDate = (today.getTimeInMillis() - birthday.getTimeInMillis()) / (24 * 60 * 60 * 1000);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = birthday.getTime();
        Date todayDate = today.getTime();

        System.out.println("birth day=" + simpleDateFormat.format(birthdayDate));
        System.out.println("today =" + simpleDateFormat.format(todayDate));
        System.out.println(diffDate + " days");
    }
}
