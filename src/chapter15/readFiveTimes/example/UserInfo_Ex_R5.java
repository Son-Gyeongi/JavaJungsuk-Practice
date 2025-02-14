package chapter15.readFiveTimes.example;

import java.io.Serializable;

/*
java.io.Serializable - 직렬화 가능한 클래스로 만들어준다.
 */
public class UserInfo_Ex_R5 implements Serializable {
    String name;
    transient String password; // transient - 직렬화에서 제외
    int age;
    transient Object o = new Object(); // Object 객체는 직렬화할 수 없다.

    public UserInfo_Ex_R5() {
        this("Unknown", "1111", 0, new Object());
    }

    public UserInfo_Ex_R5(String name, String password, int age, Object o) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.o = o;
    }

    @Override
    public String toString() {
        return "(" + name + "," + password + "," + age + "," + o + ")";
    }
}
