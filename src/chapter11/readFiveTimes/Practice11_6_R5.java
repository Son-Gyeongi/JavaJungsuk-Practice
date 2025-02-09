package chapter11.readFiveTimes;

import java.util.*;

public class Practice11_6_R5 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        int[][] board = new int[5][5];

        for (int i = 0; set.size() < 25; i++) {
            set.add((int) (Math.random() * 30) + 1 + "");
        }

        /*
        Set 은 순서가 정해져 있지 않지만 각 자리는 이미 정해져 있기 때문에 위치가 섞이지 않는다.
        - 아무리 임의의 순서로 저장해도 *해싱 알고리즘 특성상* 한 숫자가 고정된 위치에 저장된다.
        Iterator<String> it = set.iterator();
         */

        List<String> list = new ArrayList<>(set); // List 인터페이스는 저장 순서를 유지한다.
        Collections.shuffle(list);

        Iterator<String> it = list.iterator();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(it.next());
                System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
            }
            System.out.println();
        }
    }
}
