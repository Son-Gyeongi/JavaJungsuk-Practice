package chapter11.readSixTimes.example;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

/*
페이지 409
 */
public class Ex11_4 {
    static Queue<String> queue = new LinkedList<>();
    static final int MAX_SIZE = 5; // Queue 에 최대 5개까지만 저장되도록 한다.

    public static void main(String[] args) {
        System.out.println("help 를 입력하면 도움말을 볼 수 있습니다.");

        while (true) {
            System.out.print(">>");

            try {
                // 화면으로부터 라인단위로 입력받는다.
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine().trim();

                if ("".equals(input)) continue;

                if (input.equalsIgnoreCase("q")) {
                    System.exit(0); // 프로그램 종료
                } else if (input.equalsIgnoreCase("help")) {
                    System.out.println(" help - 도움말을 보여줍니다.");
                    System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
                    System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
                } else if (input.equalsIgnoreCase("history")) {
                    int i = 0;
                    //입력받은 명령어를 저장
                    save(input);

                    // LinkedList 의 내용을 보여준다.
                    LinkedList list = (LinkedList) queue;
                    ListIterator listIterator = list.listIterator();

                    while (listIterator.hasNext()) {
                        System.out.println(++i + "." + listIterator.next());
                    }
                } else {
                    save(input);
                    System.out.println(input);
                }
            } catch (Exception e) {
                /*
                try 에서 입력오류가 생길 수 있나? -> 어차피 else 에서 다 명령어로 저장될텐데

                코드 자체에서 사용자가 정상적으로 입력하는 한 try 블록에서 예외가 발생할 가능성은 낮다.
                하지만 입력 스트림이 비정상적으로 종료될 가능성이 있기 때문에, 예외 처리를 넣어둔 것이다.

                scanner.nextLine().trim(); 에서 ctrl + d 키보드를 누르니깐 입력오류가 난다.
                입력 스트림이 강제로 종료되거나 끊기는 경우 NoSuchElementException이 발생
                 */
                System.out.println("입력오류입니다.");
            }
        }
    }

    public static void save(String input) {
        // queue 에 저장
        if (!"".equals(input))
            queue.offer(input);

        // queue 의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
        if (queue.size() > MAX_SIZE) // size() 는 Collection 인터페이스에 정의
            queue.poll();
    }
}
