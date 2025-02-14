package chapter15.readFiveTimes.example;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
생성한 객체를 직렬화하여 파일(UserInfo_R5.ser)에 저장하는 예제
 */
public class Ex15_20_R5 {
    public static void main(String[] args) {
        try {
            /*
            .ser 파일(예: UserInfo_R5.ser)은 직렬화(Serialization)된 객체 데이터를 저장하는 파일
            Java에서 역직렬화(Deserialization)해서 읽기
            텍스트 파일이 아니라 바이너리 형식이라서 메모장에서 읽기 어려울 거다.
             */
            String fileName = "C:\\cheerup\\java-basic-test\\src\\chapter15\\readFiveTimes\\example\\UserInfo_R5.ser";
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            // 직렬화 - 객체를 스트림으로 만들어 준다.
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            UserInfo_Ex_R5 u1 = new UserInfo_Ex_R5("JavaMan", "1234", 30, new Object());
            UserInfo_Ex_R5 u2 = new UserInfo_Ex_R5("JavaWoman", "4321", 26, new Object());

            ArrayList<UserInfo_Ex_R5> list = new ArrayList<>();
            list.add(u1);
            list.add(u2);

            // 객체를 직렬화한다.
            objectOutputStream.writeObject(u1);
            objectOutputStream.writeObject(u2);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            System.out.println("직렬화가 잘 끝났습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
