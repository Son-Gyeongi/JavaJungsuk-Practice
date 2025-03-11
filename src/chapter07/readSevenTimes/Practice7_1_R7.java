package chapter07.readSevenTimes;

public class Practice7_1_R7 {
    public static void main(String[] args) {
        SutdaDeck_C7_R7 deck = new SutdaDeck_C7_R7();

        for (int i = 0; i < deck.cards.length; i++) {
            System.out.print(i == 0 ? deck.cards[i] : "," + deck.cards[i]);
        }
    }
}
