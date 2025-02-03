package chapter07.readFiveTimes;

public class Practice7_2_R5 {
    public static void main(String[] args) {
        SutdaDeck7_1_R5 deck = new SutdaDeck7_1_R5();

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
