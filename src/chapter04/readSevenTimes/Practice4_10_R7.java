package chapter04.readSevenTimes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice4_10_R7 {
    public static void main(String[] args) {
        // 1~100 사이의 임의의 값을 얻어서 answer 에 저장한다.
        int answer = (int) (Math.random() * 100) + 1;
        int input = 0; // 사용자입력을 저장할 공간
        int count = 0; // 시도횟수를 세기위한 변수

        // 화면으로부터 사용자입력을 받기 위해서 Scanner 클래스 사용
        Scanner scanner = new Scanner(System.in);

        do {
            count++;
            System.out.print("1과 100 사이의 값을 입력하세요 :");

            try {
                input = scanner.nextInt(); // 입력받은 값을 변수 input 에 저장한다.

                // 사용자입력 유효성 검사하기
                if (!(1 <= input && input < 100)) {
                    continue;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // 입력 후 nextInt() 에 남아있는 개행문자를 소비하기 위해 추가
                System.out.println("숫자를 입력해주세요.");
                System.out.println();
                continue;
            }

            if (input > answer) {
                System.out.println("더 작은 수를 입력하세요.");
            } else if (input < answer) {
                System.out.println("더 큰 수를 입력하세요.");
            } else {
                System.out.println("맞혔습니다.");
                System.out.println("시도횟수는 " + count + "번입니다.");
                break; // 프로그램 만들고 테스트 해보기
            }
        } while (true);
    }
}
