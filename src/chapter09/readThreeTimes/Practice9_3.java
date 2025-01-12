package chapter09.readThreeTimes;

public class Practice9_3 {
    public static int count(String src, String target) {
        int count = 0; // 찾은 횟수
        int pos = 0; // 찾기 시작할 위치

        while (true) {
            pos = src.indexOf(target, pos);

            if (pos != -1) {
                count++;
                pos += target.length();
            } else break;

            // indexOf() 에서 범위를 벗어나는 위치는 -1 반환
            // if (pos == 16) System.out.println("df"+src.indexOf(target,pos));
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(count("12345AB12AB345AB", "AB"));
        System.out.println(count("12345", "AB"));
    }
}
