package chapter10.readFourTimes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Practice10_2 {
    public static void main(String[] args) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("입력하신 날짜는 E요일입니다.");
        Scanner scanner = new Scanner(System.in);

        Date date = null;

        while (true) {
            try {
                System.out.println("날짜를 yyyy/MM/dd 의 형태로 입력해주세요.(입력예:2017/05/11)");
                System.out.print(">>");
                date = sdf1.parse(scanner.nextLine());
                System.out.println(sdf2.format(date));
                break;
            } catch (Exception e) {
            }
        }
    }
}
