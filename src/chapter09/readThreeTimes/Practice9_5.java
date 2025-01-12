package chapter09.readThreeTimes;

public class Practice9_5 {
    public static String delChar(String src, String delChar) {
        StringBuffer sb = new StringBuffer(src);

        for (int i = 0; i < delChar.length(); i++) {
            while (true) {
                int num = sb.indexOf(""+delChar.charAt(i));

                if (num == -1) break;
                else sb.deleteCharAt(num);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
        System.out.println(delChar("(1 2 3 4\t5)", " \t"));
    }
}
