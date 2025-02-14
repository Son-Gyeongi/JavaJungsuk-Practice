package chapter15.readFiveTimes.example;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/*
생성한 객체를 직렬화하여 파일(UserInfo_R5.ser)에 저장한 것을
다시 역직렬화하여 보여주는 예제
 */
public class Ex15_21_R5 {
    public static void main(String[] args) {
        try {
            String fileName = "C:\\cheerup\\java-basic-test\\src\\chapter15\\readFiveTimes\\example\\UserInfo_R5.ser";
            FileInputStream fileInputStream = new FileInputStream(fileName);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            // 역직렬화 - 스트림을 객체로 만들어 준다.
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

            // 객체를 읽을 때는 출력한 순서와 일치해야한다.
            UserInfo_Ex_R5 u1 = (UserInfo_Ex_R5) objectInputStream.readObject();
            UserInfo_Ex_R5 u2 = (UserInfo_Ex_R5) objectInputStream.readObject();
            ArrayList list = (ArrayList) objectInputStream.readObject();

            // 객체에 transient 키워드로 지정한 필드는
            // 직렬화에서 제외되었으니 역직렬화 해서 객체 만들면 타입의 기본값이 들어온다.
            // password 와 Object 에 null 이 들어온다.
            System.out.println(u1);
            System.out.println(u2);
            System.out.println(list);
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
