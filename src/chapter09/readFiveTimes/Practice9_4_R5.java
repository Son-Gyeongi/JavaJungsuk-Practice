package chapter09.readFiveTimes;

public class Practice9_4_R5 {
    public static boolean contains(String src, String target) {
        return src.indexOf(target) != -1 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(contains("12345", "23"));
        System.out.println(contains("12345", "67"));
    }
}
