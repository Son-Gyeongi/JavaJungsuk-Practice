package chapter10.readFiveTimes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Practice10_1_R5 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 0, 1); // 2020년 1월 1일

        // SimpleDateFormat 을 사용하려면 Date 필요
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일입니다.");

        for (int i = 0; i < 12; i++) {
            // 계산을 하기 위해 초기화
            calendar.set(Calendar.MONTH, i);
            calendar.set(Calendar.DATE, 1); // Calendar.DAY_OF_MONTH 같다.

            // 해당 월의 1일은 무슨 요일
            int dayOfTheWeek = calendar.get(Calendar.DAY_OF_WEEK);
            int secondSunday = dayOfTheWeek == 1 ? 8 : 16 - dayOfTheWeek;
            calendar.set(Calendar.DAY_OF_MONTH, secondSunday); // Calendar.DATE 같다.

            Date date = new Date(calendar.getTimeInMillis());
            String strDate = simpleDateFormat.format(date);
            System.out.println(strDate);
        }
    }
}
