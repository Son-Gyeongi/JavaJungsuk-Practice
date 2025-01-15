package chapter09.readFourTimes;

public class Practice9_5 {
    public static String delChar(String src, String delCh) {
        // src - 변환할 문자열, delCh 제거할 문자들로 구성된 문자열
        StringBuffer stringBuffer = new StringBuffer(src);

        for (int i = src.length() - 1; i >= 0; i--) {
            if (delCh.indexOf(src.charAt(i)) != -1) {
                stringBuffer.deleteCharAt(i);
            }
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
        System.out.println("(1 2 3 4\t5)" + " -> " + delChar("(1 2 3 4\t5)", " \t"));
    }
}
