package chapter05.readSevenTimes;

import java.util.Scanner;

public class Practice5_6_R7 {
    public static void main(String[] args) {
        String[] words = {"television", "computer", "mouse", "phone"};

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < words.length; i++) {
            char[] question = words[i].toCharArray(); // String 을 char[] 로 변환

            for (int j = 0; j < question.length; j++) {
                int index = (int) (Math.random() * question.length);

                char tmp = question[j];
                question[j] = question[index];
                question[index] = tmp;
            }

            System.out.printf("Q%d. %s의 정답을 입력하세요.>", i + 1, new String(question));
            String answer = scanner.nextLine();

            // trim() 으로 answer 의 좌우 공백을 제거한 후, equals 로 word[i] 와 비교
            if (answer.trim().equals(words[i])) {
                System.out.printf("맞았습니다.%n%n");
            } else {
                System.out.printf("틀렸습니다.%n%n");
            }
        }
    }
}
