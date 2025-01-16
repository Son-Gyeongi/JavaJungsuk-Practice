package chapter10.readFourTimes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Practice10_1 {
    public static void main(String[] args) {
        /*
        F : 이 달의 몇 번째 요일
        E : 요일
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일입니다.");

        Calendar cal = Calendar.getInstance();
        cal.set(2020, 0, 1);

        for (int i = 0; i < 12; i++) {
            cal.set(Calendar.MONTH, i);
            cal.set(Calendar.DATE, 1); // Calendar.DAY_OF_MONTH 같다.

            // 각 달의 1일이 무슨 요일인지 확인
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);// 요일(1~7), 1:일요일
            /*
            일요일이면 두 번째 일요일은 8일
            월요일이면 두 번째 일요일은 14일
            화요일이면 두 번째 일요일은 13일
            수요일이면 두 번째 일요일은 12일
            목요일이면 두 번째 일요일은 11일
            금요일이면 두 번째 일요일은 10일
            토요일이면 두 번째 일요일은 9일
             */
            int day = dayOfWeek == 1 ? 8 : dayOfWeek + (2 * (8 - dayOfWeek));
            cal.set(Calendar.DATE, day);

            System.out.println(simpleDateFormat.format(cal.getTimeInMillis()));
//            System.out.println(simpleDateFormat.format(cal.getTime()));
//            System.out.println(simpleDateFormat.format(new Date(cal.getTimeInMillis())));
        }
    }
}
