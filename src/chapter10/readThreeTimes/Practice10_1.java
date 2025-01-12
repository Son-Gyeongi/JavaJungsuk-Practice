package chapter10.readThreeTimes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Practice10_1 {
    public static void main(String[] args) {
        String pattern = "yyyy-MM-dd은 F번째 E요일입니다";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        Calendar date = Calendar.getInstance();
        date.set(2020, 0, 1);

        for (int i = 0; i < 12; i++) {
            date.set(Calendar.MONTH, i);

            for (int j = 1; j <= date.getActualMaximum(Calendar.DATE); j++) {
                date.set(Calendar.DATE, j);
                int week = date.get(Calendar.DAY_OF_WEEK_IN_MONTH);
                int day = date.get(Calendar.DAY_OF_WEEK);

                if (week == 2 && day == 1) {
                    System.out.println(sdf.format(date.getTime()));
                    break;
                }
            }
        }
    }
}
