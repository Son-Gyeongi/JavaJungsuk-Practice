package chapter07.readFiveTimes;

public class SutdaDeck7_1_R5 {
    final int CARD_NUM = 20;
    // 섯다카드 20장을 담는 SutdaCard 배열
    SutdaCard7_1_R5[] cards = new SutdaCard7_1_R5[CARD_NUM];

    SutdaDeck7_1_R5() {
        // SutdaCard 배열 초기화
        for (int i = 0; i < cards.length; i++) {
            int num = i + 1;

            if (num == 1 || num == 3 || num == 8) {
                cards[i] = new SutdaCard7_1_R5(num, true);
            } else {
                num = num > 10 ? num - 10 : num;
                cards[i] = new SutdaCard7_1_R5(num, false);
            }
        }
    }

    // 배열 cards 에 담긴 카드의 위치를 뒤섞는다.
    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int index = (int) (Math.random() * cards.length);

            SutdaCard7_1_R5 tmp = cards[i];
            cards[i] = cards[index];
            cards[index] = tmp;
        }
    }

    // 배열 cards 에서 지정된 위치의 SutdaCard 를 반환한다.
    public SutdaCard7_1_R5 pick(int index) {
        // index - 위치
        return cards[index];
    }

    // 배열 cards 에서 임의의 위치의 SutdaCard 를 반환한다.
    public SutdaCard7_1_R5 pick() {
        int index = (int) (Math.random() * cards.length);
        return pick(index);
    }
}
