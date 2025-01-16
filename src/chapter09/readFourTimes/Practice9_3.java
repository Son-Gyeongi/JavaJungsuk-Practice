package chapter09.readFourTimes;

public class Practice9_3 {
    public static int count(String src, String target) {
        int count = 0; // 찾은 횟수
        int pos = 0; // 찾기 시작할 위치

        while (src.indexOf(target, pos) != -1) {
            count++;
            pos = src.indexOf(target, pos) + 1; // 1 보다는 target.length 가 좋겠다.
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(count("12345AB12AB345AB", "AB"));
        System.out.println(count("12345", "AB"));
    }
}
