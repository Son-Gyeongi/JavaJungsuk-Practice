package chapter06.readSevenTimes;

public class Practice6_18_R7 {
    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;

        boolean b = true;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!('0' <= ch && ch <= '9')) {
                b = false;
                break;
            }
        }

        return b;
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println(str + "은/는 숫자입니까? " + isNumber(str));

        str = "1234o";
        System.out.println(str + "은/는 숫자입니까? " + isNumber(str));

        str = ""; // 빈 문자열인 경우
        System.out.println("빈문자열(\"\")은/는 숫자입니까? " + isNumber(str));

        str = null; // null 인 경우
        System.out.println(str + "은/는 숫자입니까? " + isNumber(str));
    }
}
