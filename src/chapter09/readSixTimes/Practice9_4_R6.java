package chapter09.readSixTimes;

public class Practice9_4_R6 {
    public static boolean contains(String src, String target) {
//        return src.indexOf(target) != -1 ? true : false;
        return src.indexOf(target) != -1;
    }

    public static void main(String[] args) {
        System.out.println(contains("12345", "23"));
        System.out.println(contains("12345", "67"));
    }
}
