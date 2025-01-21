package chapter14.readFourTimes;

import java.util.Arrays;

public class Practice14_4 {
    public static void main(String[] args) {
        int[] dice1 = {1, 2, 3, 4, 5, 6};
        int[] dice2 = {1, 2, 3, 4, 5, 6};

        /*
        1. 일단 2개를 엮어 [1,1][1,2][1,3]...[6,5][6,6]
        2. [1,1] 하나씩 요소를 가져와서 1+1 값을 더하고 6이랑 같은지 필터링해
        3. 그리고 출력해
         */

        // 스트림과 람다
        Arrays.stream(dice1)
                .mapToObj(d1 -> Arrays.stream(dice2)
                        .mapToObj(d2 -> d1 + " " + d2)
                        .toArray(String[]::new))
                .flatMap(Arrays::stream)
                .filter(s -> (Integer.parseInt(s.split(" ")[0]) + Integer.parseInt(s.split(" ")[1])) == 6)
                .forEach(s -> System.out.println("[" + s.split(" ")[0] + "," + s.split(" ")[1] + "]"));

        // stream 안에 String[] 이 있다. -> flatMap 으로 Stream<String> 으로 만들어서 요소 하나씩 검사해야 한다.
        Arrays.stream(dice1)
                .mapToObj(d1 -> Arrays.stream(dice2)
                        .mapToObj(d2 -> d1 + " " + d2)
                        .toArray(String[]::new))
                .forEach(arr -> System.out.println(Arrays.toString(arr)));

        /*
        이중 for 문
        for (int i = 0; i < dice1.length; i++) {
            for (int j = 0; j < dice2.length; j++) {
                if (dice1[i] + dice2[j] == 6) {
                    System.out.println("[" + dice1[i] + "," + dice2[j] + "]");
                }
            }
        }
         */
    }
}
