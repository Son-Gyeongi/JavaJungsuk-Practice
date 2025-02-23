package chapter07.readSixTimes;

public class Practice7_2_R6 {
    public static void main(String[] args) {
        SutdaDeck_C6_R6 deck = new SutdaDeck_C6_R6();

        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();

        for (int i = 0; i < deck.cards.length; i++) {
            System.out.print(deck.cards[i] + ",");
        }

        System.out.println();
        System.out.println(deck.pick(0));
    }
}
