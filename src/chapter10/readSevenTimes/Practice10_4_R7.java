package chapter10.readSevenTimes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Practice10_4_R7 {
    public static void main(String[] args) {
        Calendar birthday = Calendar.getInstance();
        birthday.set(2000, 0, 1);
        Calendar today = Calendar.getInstance();
        // today.set(2016, 0, 29);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // 날짜 계산
        long diffMillis = today.getTimeInMillis() - birthday.getTimeInMillis();
        long diffDate = diffMillis / (24 * 60 * 60 * 1000);

        System.out.println("birth day=" + simpleDateFormat.format(birthday.getTime()));
        System.out.println("today =" + simpleDateFormat.format(today.getTime()));
        System.out.println(diffDate + " days");
    }
}
