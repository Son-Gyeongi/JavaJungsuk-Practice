package chapter10.readThreeTimes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Practice10_4 {
    public static void main(String[] args) throws ParseException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Scanner s = new Scanner(System.in);

        System.out.print("생년월일을 입력해주세요.(예 1999-01-01) >> ");
        String birth = s.nextLine().trim();
        Date bDate = sdf.parse(birth);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(bDate);

        long diff = cal.getTimeInMillis() - cal2.getTimeInMillis();

        System.out.println("birth day=" + birth);
        System.out.println("today =" + sdf.format(new Date(cal.getTimeInMillis())));
        System.out.println(diff/(24*60*60*1000)+"days");
    }
}
