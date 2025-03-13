package chapter09.readSevenTimes;

public class Practice9_4_R7 {
    public static boolean contains(String src, String target) {
        if (src == null || src.isEmpty() || target == null || target.isEmpty()) return false;

        return src.indexOf(target) != -1;
    }

    public static void main(String[] args) {
        System.out.println(contains("12345", "23"));
        System.out.println(contains("12345", "67"));
    }
}
