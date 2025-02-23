package chapter07.readSixTimes;

public class Practice7_2_R6 {
    public static void main(String[] args) {
        SutdaDeck_C6_R6 deck = new SutdaDeck_C6_R6();

        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        System.out.println(deck.pick(30)); // 유효하지 않은 인덱스 값이 주어질 경우
        deck.shuffle();

        for (int i = 0; i < deck.cards.length; i++) {
            System.out.print(deck.cards[i] + ",");
        }

        System.out.println();
        System.out.println(deck.pick(0));
    }
}
