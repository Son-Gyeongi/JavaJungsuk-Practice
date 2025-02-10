package chapter13.readFiveTimes.example;

import javax.swing.*;

/*
싱글 쓰레드
 */
public class Ex13_4_R5 {
    public static void main(String[] args) {
        // 작업 A - 입력 받기
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");

        // 작업 B - 카운트 다운
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000); // 1초간 시간을 지연한다.
            } catch (Exception e) {}
        }
    }
}
