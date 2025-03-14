package chapter10.readSevenTimes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Practice10_2_R7 {
    public static void main(String[] args) {
        // 화면으로부터 날짜를 입력받을 때 패턴
        String pattern = "yyyy/MM/dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String pattern2 = "입력하신 날짜는 E요일입니다.";
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);

        Date inputDate = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("날짜를 " + pattern + "의 형태로 입력해주세요.(입력예:2017/05/11)");
            System.out.print(">>");

            try {
                inputDate = simpleDateFormat.parse(scanner.nextLine());
                break;
            } catch (Exception e) {}
        }

        System.out.println(simpleDateFormat2.format(inputDate));
    }
}
