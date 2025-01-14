package chapter07;

public class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    public SutdaDeck() {
        for (int i = 0; i < cards.length; i++) {
            int num = i % 10 + 1;
            boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);

            cards[i] = new SutdaCard(num, isKwang);
        }

        /*
        for (int i = 0; i < CARD_NUM; i++) {
            if (i == 0 || i == 2 || i == 7) {
                cards[i] = new SutdaCard(i + 1, true);
            } else {
                cards[i] = new SutdaCard(i < 10 ? i + 1 : i + 1 - 10, false);
            }
        }
         */
    }

    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int j = (int) (Math.random() * cards.length);
            SutdaCard tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
    }

    public SutdaCard pick(int index) {
        // 매개변수가 있는 메서드는 반드시 작업 전에 유효성 검사하자
        if (!(0 <= index && index < cards.length)) {
            return null;
        }

        return cards[index];
    }

    public SutdaCard pick() {
        return pick((int) (Math.random() * cards.length));
    }
}
