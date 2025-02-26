package chapter09.readSixTimes;

public class Practice9_5_R6 {
    public static String delChar(String src, String delCh) {
        // src - 변환할 문자열, delCh - 제거할 문자들로 구성된 문자열

        StringBuffer str = new StringBuffer();

        for (int i = 0; i < src.length(); i++) {
            char ch = src.charAt(i);

            if (delCh.indexOf(ch) == -1) {
                str.append(ch);
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
        System.out.println("(1 2 3 4\t5)" + " -> " + delChar("(1 2 3 4\t5)", " \t")); // 공백, 탭 제거
    }
}
