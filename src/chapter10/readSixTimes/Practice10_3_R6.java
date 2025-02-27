package chapter10.readSixTimes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Practice10_3_R6 {
    static int paycheckCount(Calendar from, Calendar to) {
        if (from == null || to == null) return 0;

        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        int fromDate = from.get(Calendar.DAY_OF_MONTH);

        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        int toDate = to.get(Calendar.DAY_OF_MONTH);

        if (from.equals(to) && fromDate == 21) return 1;

        int monDiff = 0; // from 과 to 의 개월 수 차이
        monDiff = (toYear * 12) + toMonth - (fromYear * 12) + fromMonth;

        if (monDiff < 0) return 0;

        if (fromDate <= 21 && toDate >= 21) monDiff++;

        if (fromDate > 21 && toDate < 21) monDiff--;

        return monDiff;
    }

    static void printResult(Calendar from, Calendar to) {
        Date fromDate = from.getTime();
        Date toDate = to.getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print(simpleDateFormat.format(fromDate) + " ~ " + simpleDateFormat.format(toDate) + ":");

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
