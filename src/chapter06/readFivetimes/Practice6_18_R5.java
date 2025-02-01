package chapter06.readFivetimes;

public class Practice6_18_R5 {
    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;

        for (int i = 0; i < str.length(); i++) {
            // 문자가 숫자가 아니면 if문 true
            if (!('0' <= str.charAt(i) && str.charAt(i) <= '9'))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));

        str = "1234o";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));
    }
}
