package chapter07.readSixTimes;

/*
SutdaDeck Chapter06 Read 6th
 */
public class SutdaDeck_C6_R6 {
    // SutdaCard 20장을 포함하는 섯다카드 한 벌(SutdaDeck 클래스)
    final int CARD_NUM = 20;
    SutdaCard_C6_R6[] cards = new SutdaCard_C6_R6[CARD_NUM];

    SutdaDeck_C6_R6() {
        // SutdaCard 초기화
        for (int i = 0; i < cards.length; i++) {
            int num = i % 10 + 1;
            boolean isKwang = false;

            if (i < 10 && (num == 1 || num == 3 || num == 8)) {
                isKwang = true;
            }

            cards[i] = new SutdaCard_C6_R6(num, isKwang);
        }
    }

    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int index = (int) (Math.random() * cards.length);

            SutdaCard_C6_R6 temp = cards[i];
            cards[i] = cards[index];
            cards[index] = temp;
        }
    }

    public SutdaCard_C6_R6 pick(int index) {
        // 매개변수가 있는 메서드 반드시 유효성 검사하기
        if (!(0 <= index && index < cards.length)) return null;

        return cards[index];
    }

    public SutdaCard_C6_R6 pick() {
        int index = (int) (Math.random() * cards.length);
        return pick(index);
    }
}
