package chapter07.readSevenTimes;

public class Practice7_2_R7 {
    public static void main(String[] args) {
        SutdaDeck_C7_R7 deck = new SutdaDeck_C7_R7();

        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();

        for (int i = 0; i < deck.cards.length; i++) {
            System.out.print(i == 0 ? deck.cards[i] : "," + deck.cards[i]);
        }

        System.out.println();
        System.out.println(deck.pick(0));
    }
}
