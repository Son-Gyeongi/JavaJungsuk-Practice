package chapter06.readFourTimes;

public class Practice6_18 {
    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // 숫자외 문자 다 검색됨
            if (!('0' <= ch && ch <= '9')) {
                return false;
            }

            /*
            영문자만 검색됨
            if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
                return false;
            }
             */
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));

        str = "123o";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));
    }
}
