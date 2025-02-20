package chapter05.readSixTimes.example;

/*
길이가 0인 배열
 */
public class Ex5_7 {
    public static void main(String[] args) {
        System.out.println("매개변수의 개수:" + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = \"" + args[i] + "\"");
        }

        String[] strArr = new String[0];
        System.out.println("strArr 매개변수의 개수:" + strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            System.out.println("strArr[" + i + "] = \"" + strArr[i] + "\"");
        }

        if (strArr == null) {
            // 배열 자체를 가리키지 않는다. 배열이 생성되지 않았다.
            System.out.println("strArr 은 null 입니다.");
        } else {
            // 배열 객체가 존재하기 때문에 strArr.length를 호출해도 오류 없이 0을 출력한다.
            System.out.println("strArr 은 null 이 아닙니다. 배열 객체를 가리킵니다.");
        }
    }
}
