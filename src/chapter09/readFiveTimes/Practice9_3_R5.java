package chapter09.readFiveTimes;

public class Practice9_3_R5 {
    public static int count(String src, String target) {
        // 주어진 문자열(src)에 찾으려는 문자열(target)이 몇 번 나오는지 세어서 반환한다.
        int count = 0; // 찾은 횟수
        int pos = 0; // 찾기 시작할 위치

        while (src.indexOf(target, pos) != -1) {
            count++;
            pos = src.indexOf(target, pos) + target.length();
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(count("12345AB12AB345AB", "AB"));
        System.out.println(count("12345", "AB"));
    }
}
