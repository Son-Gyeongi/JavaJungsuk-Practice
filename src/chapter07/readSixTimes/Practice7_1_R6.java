package chapter07.readSixTimes;

public class Practice7_1_R6 {
    public static void main(String[] args) {
        SutdaDeck_C7_R6 deck = new SutdaDeck_C7_R6();

        for (int i = 0; i < deck.cards.length; i++) {
            System.out.print(deck.cards[i] + ",");
        }
    }
}
