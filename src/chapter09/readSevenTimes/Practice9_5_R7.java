package chapter09.readSevenTimes;

public class Practice9_5_R7 {
    public static String delChar(String src, String delCh) {
        if (src == null || src.isEmpty() || delCh == null || delCh.isEmpty()) return src;

        StringBuffer stringBuffer = new StringBuffer(src.length());

        for (int i = 0; i < src.length(); i++) {
            if (delCh.indexOf(src.charAt(i)) == -1) {
                stringBuffer.append(src.charAt(i));
            }
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
        System.out.println("(1 2 3 4\t5)" + " -> " + delChar("(1 2 3 4\t5)", " \t"));
    }
}
