package chapter11.readSevenTimes;

import java.util.*;

public class Practice11_6_R7 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        int[][] board = new int[5][5];

        for (int i = 0; set.size() < 25; i++) {
            // 중복되지 않게 1~30 사이의 숫자 랜덤으로 저장
            set.add((int) (Math.random() * 30) + 1 + "");
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.shuffle(list);
        Iterator<String> iterator = list.iterator();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(iterator.next());
                System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
            }
            System.out.println();
        }
    }
}
