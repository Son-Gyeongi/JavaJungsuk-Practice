package chapter11.readSixTimes;

import java.util.*;

/*
Set은 저장 순서를 유지하지 않는다는 특징이 있지만,
HashSet의 경우 내부적으로 해시 테이블(Hash Table)을 이용하여 요소를 저장하므로
각 요소의 저장 위치가 해시 값에 따라 결정된다. 따라서 특정한 경우에는 입력된 순서가 유지되는 것처럼 보일 수도 있다.
하지만 실제로는 해시 값에 따라 저장되는 위치가 정해질 뿐이며, 항상 같은 순서로 저장되거나 출력된다는 보장은 없다.

매번 다른 순서를 주기 위해 list 에 set 요소를 저장하고
shuffle() 로 자리를 바꿔주었다.
 */
public class Practice11_6_R6 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        int[][] board = new int[5][5];

        for (int i = 0; set.size() < 25; i++) {
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
