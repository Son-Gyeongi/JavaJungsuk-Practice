package chapter09.readSixTimes.example;

/*
페이지 336 에서 substring() 테스트
 */
public class Example9_1 {
    public static void main(String[] args) {
        String s = "java.lang.Object";

        String c = s.substring(10);
        String p = s.substring(5, 9);
        /*
        end 인덱스를 문자열 길이보다 더 크게 주면 어떻게 될까?
        String test = s.substring(10, 20);

        -> 에러가 나는구나
        Exception in thread "main" java.lang.StringIndexOutOfBoundsException:
        Range [10, 20) out of bounds for length 16
         */

        System.out.println(c);
        System.out.println(p);
//        System.out.println(test);
    }
}
