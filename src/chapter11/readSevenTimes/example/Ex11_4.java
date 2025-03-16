package chapter11.readSevenTimes.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
페이지 409 에서 입력 오류가 생길 때가 있나?
 */
public class Ex11_4 {
    static Queue queue = new LinkedList();
    static final int MAX_SIZE = 5; // Queue 에 최대 5개까지만 저장되도록 한다.
    // history - 최근 5개의 명령어만 보여준다.

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
                    System.exit(0); // 프로그램 정상 종료
                } else if (input.equalsIgnoreCase("help")) {
                    System.out.println(" help - 도움말을 보여줍니다.");
                    System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
                    System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
                } else if (input.equalsIgnoreCase("history")) {
                    int i = 0;
                    // 입력받은 명령어를 저장하고,
                    save(input);

                    // LinkedList 의 내용을 보여준다.
                    LinkedList tmp = (LinkedList) queue;
                    Iterator iterator = tmp.iterator();

                    while (iterator.hasNext()) {
                        System.out.println((++i + "." + iterator.next()));
                    }
                } else {
                    save(input);
                    System.out.println(input);
                }
            } catch (Exception e) {
                System.out.println("입력오류입니다.");
            }
        }
    }

    public static void save(String input) {
        // queue 에 저장한다.
        if (!"".equals(input))
            queue.offer(input);
        
        // queue 의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
        if (queue.size() > MAX_SIZE) // size()는 Collection 인터페이스에 정의
            queue.poll(); // queue.remove() 를 사용하면 Exception 이 날 수 있다.
    }
}
