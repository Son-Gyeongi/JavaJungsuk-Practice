package chapter09.readSevenTimes;

public class Practice9_3_R7 {
    public static int count(String src, String target) {
        if (src == null || src.isEmpty() || target == null || target.isEmpty()) return 0;

        int count = 0; // 찾은 횟수
        int pos = 0; // 찾기 시작할 위치

        while ((pos = src.indexOf(target, pos)) != -1) {
            count++;
            pos += target.length(); // target 을 찾은 후에 target 길이만큼 pos 에 더해주기
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(count("12345AB12AB345AB", "AB"));
        System.out.println(count("12345", "AB"));
    }
}
