package chapter10.readFourTimes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Practice10_3 {
    // 월급날이 21일인 회사, 두 날짜 사이에 월급날이 몇 번 있는지 계산해서 반환
    static int paycheckCount(Calendar from, Calendar to) {
        // 1. from 또는 to 가 null 이면 0을 반환한다.
        if (from == null || to == null) return 0;

        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        int fromDate = from.get(Calendar.DAY_OF_MONTH);
        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        int toDate = to.get(Calendar.DAY_OF_MONTH);

        // 2. from 과 to 가 같고 날짜가 21일이면 1을 반환한다.
        if (from.equals(to) && fromDate == 21) return 1;

        // 3. to 와 from 이 몇 개월 차이인지 계산해서 변수 monDiff 에 담는다.
        int monDiff = (toYear * 12 + toMonth) - (fromYear * 12 + fromMonth);

        // 4. monDiff 가 음수이면 0을 반환한다.
        if (monDiff < 0) return 0;

        /*
        5. 만일 from 의 일(DAY_OF_MONTH)이 21일이거나 이전이고
        to의 일(DAY_OF_MONTH)이 21일이거나 이후이면 monDiff 의 값을 1 증가시킨다.
         */
        if (fromDate <= 21 && toDate >= 21) monDiff++;

        /*
        6. 만일 from 의 일(DAY_OF_MONTH)이 21일 이후고
        to의 일(DAY_OF_MONTH)이 21일 이전이면 monDiff 의 값을 1 감소시킨다.
         */
        if (fromDate > 21 && toDate < 21) monDiff--;

        return monDiff;
    }

    static void printResult(Calendar from, Calendar to) {
        Date fromDate = from.getTime();
        Date toDate = to.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print(sdf.format(fromDate) + " ~ " + sdf.format(toDate) + ":");
        System.out.println(paycheckCount(from, to));
    }

    public static void main(String[] args) {
        Calendar fromCal = Calendar.getInstance();
        Calendar toCal = Calendar.getInstance();

        fromCal.set(2020, 0, 1);
        toCal.set(2020, 0, 1);
        printResult(fromCal, toCal);

        fromCal.set(2020, 0, 21);
        toCal.set(2020, 0, 21);
        printResult(fromCal, toCal);

        fromCal.set(2020, 0, 1);
        toCal.set(2020, 2, 1);
        printResult(fromCal, toCal);

        fromCal.set(2020, 0, 1);
        toCal.set(2020, 2, 23);
        printResult(fromCal, toCal);

        fromCal.set(2020, 0, 23);
        toCal.set(2020, 2, 21);
        printResult(fromCal, toCal);

        fromCal.set(2021, 0, 22);
        toCal.set(2020, 2, 21);
        printResult(fromCal, toCal);
    }
}
