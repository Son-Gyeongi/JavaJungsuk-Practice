package chapter10.readSixTimes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Practice10_1_R6 {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일입니다.");
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, 2020);

        for (int i = 0; i < 12; i++) {
            date.set(Calendar.MONTH, i);
            date.set(Calendar.DAY_OF_MONTH, 1); // == Calendar.DATE

            // 월의 1일은 무슨 요일일까?
            int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
            /*
            1이면 일요일이고 2번째 일요일 날짜는 8일이다.
            나머지 요일들은 16-dayOfWeek 하면 2번째 일요일 날짜가 나온다.
             */
            int secondSunday = dayOfWeek == 1 ? 8 : 16 - dayOfWeek;

            date.set(Calendar.DAY_OF_MONTH, secondSunday);

            // Calendar -> Date 로 변경
            Date changeDate = new Date(date.getTimeInMillis());
            System.out.println(simpleDateFormat.format(changeDate));
        }
    }
}
