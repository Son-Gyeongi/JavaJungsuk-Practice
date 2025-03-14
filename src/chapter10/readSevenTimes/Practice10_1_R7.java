package chapter10.readSevenTimes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Practice10_1_R7 {
    public static void main(String[] args) {
        // 출력할 날짜 패턴
        String pattern = "yyyy-MM-dd은 F번째 E요일입니다.";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        // Calendar 인스턴스 생성
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, 2020);

        for (int i = 0; i < 12; i++) {
            date.set(Calendar.MONTH, i);
            date.set(Calendar.DAY_OF_MONTH, 1); // Calendar.DATE 와 같다.

            // 해당하는 월의 1일은 무슨 요일일까?
            int dayOfTheWeek = date.get(Calendar.DAY_OF_WEEK);
            // 두 번째 일요일 날짜 구하기
            int secondSunday = dayOfTheWeek == 1 ? 8 : (16 - dayOfTheWeek);
            // 날짜 설정
            date.set(Calendar.DAY_OF_MONTH, secondSunday);

            // Calendar 를 Date 로 변경
            Date date1 = new Date(date.getTimeInMillis());
            System.out.println(simpleDateFormat.format(date1));
        }
    }
}
