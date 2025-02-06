package chapter10.readFiveTimes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Practice10_3_R5 {
    static int paycheckCount(Calendar from, Calendar to) {
        // 1. from 또는 to 가 null 이면 0 을 반환한다.
        if (from == null || to == null) return  0;

        int monDiff = 0;
        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        int fromDate = from.get(Calendar.DATE); // Calendar.DAY_OF_MONTH 와 같다.

        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        int toDate = to.get(Calendar.DATE);

        // 2. from 과 to 가 같고 날짜가 21 이면 1을 반환한다.
        if (from.equals(to) && fromDate == 21) return 1;

        // 3. to 와 from 이 몇 개월 차이인지 계산해서 변수 monDiff 에 담는다. (년도를 포함해서 계산해야 한다.)
        monDiff = (toYear * 12 + toMonth) - (fromYear * 12 + fromMonth);

        // 4. monDiff 가 음수이면 0 을 반환한다.
        if (monDiff < 0) return 0;

        // 5. 만일 from 의 일(DAY_OF_MONTH)이 21일 이거나 이전이고
        // to 의 일(DAY_OF_MONTH)이 21일 이거나 이후이면 monDiff 의 값을 1 증가시킨다.
        if (fromDate <= 21 && toDate >= 21) monDiff++;

        // 6. 만일 from 의 일(DAY_OF_MONTH)이 21일 이후고
        // to 의 일(DAY_OF_MONTH)이 21일 이전이면 monDiff 의 값을 1 감소시킨다.
        if (fromDate > 21 && toDate < 21) monDiff--;

        return monDiff;
    }

    static void printResult(Calendar from, Calendar to) {
        Date fromDate = from.getTime(); // Calendar 에서 Date 타입으로 변환
        Date toDate = to.getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print(simpleDateFormat.format(fromDate) + " ~ " + simpleDateFormat.format(toDate) + ":");
        System.out.println(paycheckCount(from, to));
    }

    public static void main(String[] args) {
        Calendar fromCal = Calendar.getInstance();
        Calendar toCal = Calendar.getInstance();

        // 2020-01-01 ~ 2020-01-01
        fromCal.set(2020, 0, 1);
        toCal.set(2020, 0, 1);
        printResult(fromCal, toCal);

        // 2020-01-21 ~ 2020-01-21
        fromCal.set(2020, 0, 21);
        toCal.set(2020, 0, 21);
        printResult(fromCal, toCal);

        // 2020-01-01 ~ 2020-03-01
        fromCal.set(2020, 0, 1);
        toCal.set(2020, 2, 1);
        printResult(fromCal, toCal);

        // 2020-01-01 ~ 2020-03-23
        fromCal.set(2020, 0, 1);
        toCal.set(2020, 2, 23);
        printResult(fromCal, toCal);

        // 2020-01-23 ~ 2020-03-21
        fromCal.set(2020, 0, 23);
        toCal.set(2020, 2, 21);
        printResult(fromCal, toCal);

        // 2021-01-22 ~ 2020-03-21
        fromCal.set(2021, 0, 22);
        toCal.set(2020, 2, 21);
        printResult(fromCal, toCal);
    }
}
