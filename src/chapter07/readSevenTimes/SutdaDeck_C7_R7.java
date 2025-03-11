package chapter07.readSevenTimes;

/*
SutdaDeck Chapter07 Read 7th
섯다카드 20장을 포함하는 섯다카드 한 벌
 */
public class SutdaDeck_C7_R7 {
    final int CARD_NUM = 20;
    SutdaCard_C7_R7[] cards = new SutdaCard_C7_R7[CARD_NUM];

    public SutdaDeck_C7_R7() {
        // 섯다카드 20장을 담는 SutdaCard 배열을 초기화

        for (int i = 0; i < CARD_NUM; i++) {
            int num = (i % 10) + 1;
            boolean isKwang = i < 10 && (num == 1 || num == 3 || num == 8);

            cards[i] = new SutdaCard_C7_R7(num, isKwang);
        }
    }

    // 배열 cards 에 담긴 카드의 위치를 뒤섞는다.
    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int index = (int) (Math.random() * cards.length);

            SutdaCard_C7_R7 tmp = cards[i];
            cards[i] = cards[index];
            cards[index] = tmp;
        }
    }

    // 배열 cards 에서 지정된 위치의 SutdaCard 를 반환한다.
    public SutdaCard_C7_R7 pick(int index) {
        // 매개변수가 있는 메서드 유효성 검사 필수!!
        if (!(0 <= index && index < cards.length)) return null;

        return cards[index];
    }

    // 배열 cards 에서 임의의 위치의 SutdaCard 를 반환한다.
    public SutdaCard_C7_R7 pick() {
        return pick((int) (Math.random() * cards.length));
    }
}
