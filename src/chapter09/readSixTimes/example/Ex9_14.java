package chapter09.readSixTimes.example;

/*
Integer, Double, Character 같은 래퍼 클래스 자체가 Deprecated(비추천) 된 것은 아니다.
하지만 몇 가지 주요 메서드들이 Deprecated 되었다.
 */
public class Ex9_14 {
    public static void main(String[] args) {
        // Deprecated 코드 - 불필요한 객체 생성을 방지하고 성능을 최적화하기 위해
        Integer i = new Integer(100);
        Double d = new Double(100.0);
        Character c = new Character('a');

        // 권장 코드 - 정적 팩토리 메서드 사용
        // 같은 값을 가진 객체가 이미 있으면 새로 만들지 않고 기존 객체를 반환
        // 불필요한 객체 생성을 줄여서 메모리 사용량을 최적화
        Integer i2 = Integer.valueOf(100);
        Double d2 = Double.valueOf(100.0);
        Character c2 = Character.valueOf('a');
    }
}
