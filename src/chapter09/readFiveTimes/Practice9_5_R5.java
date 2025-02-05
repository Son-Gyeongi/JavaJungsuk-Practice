package chapter09.readFiveTimes;

public class Practice9_5_R5 {
    public static String delChar(String src, String delCh) {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < src.length(); i++) {
            int pos = delCh.indexOf(src.charAt(i));
            if (pos == -1) {
                // delCh 에 src 문자가 없어야지 StringBuffer 에 넣을 수 있다.
                stringBuffer.append(src.charAt(i));
            }
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println("(1!2@3^4~5)" + " -> "
                + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
        System.out.println("(1 2 3 4\t5)" + " -> "
                + delChar("(1 2 3 4\t5)", " \t"));
    }
}
