package chapter03.readSevenTimes;

public class Practice3_4_R7 {
    public static void main(String[] args) {
        int numOfApples = 123; // 사과의 개수
        int sizeOfBucket = 10; // 바구니의 크기 (바구니에 담을 수 있는 사과의 개수)
        // 모든 사과를 담는데 필요한 바구니의 수
        int numOfBucket = numOfApples / sizeOfBucket + (numOfApples % sizeOfBucket == 0 ? 0 : 1);

        System.out.println("필요한 바구니의 수 :" + numOfBucket);
    }
}
