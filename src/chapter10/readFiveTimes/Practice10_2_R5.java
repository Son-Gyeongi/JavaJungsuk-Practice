package chapter10.readFiveTimes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Practice10_2_R5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 날짜 패턴
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("입력하신 날짜는 E요일입니다.");
        Date date = null; // 입력 받은 문자열 날짜를 Date 로 변환

        do {
            System.out.println("날짜를 yyyy/MM/dd 의 형태로 입력해주세요.(입력예:2017/05/11)");
            System.out.print(">>");

            try {
                String input = scanner.nextLine();
                date = simpleDateFormat1.parse(input); // 입력예와 다른 경우 에러 발생
            } catch (Exception e) {
                continue;
            }

            System.out.println(simpleDateFormat2.format(date));
            break;
        } while (true);
    }
}
