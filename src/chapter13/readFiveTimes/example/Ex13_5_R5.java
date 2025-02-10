package chapter13.readFiveTimes.example;

import javax.swing.*;

/*
멀티 쓰레드
작업을 효율적으로 빨리 끝낼 수 있다.
 */
public class Ex13_5_R5 {
    public static void main(String[] args) {
        ThreadEx13_5_R5 th1 = new ThreadEx13_5_R5();
        th1.start();

        // 작업 A - 입력 받기
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
    }
}

class ThreadEx13_5_R5 extends Thread {
    // 작업 B - 카운트 다운
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (Exception e) {}
        }
    }
}