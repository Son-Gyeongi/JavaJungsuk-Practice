package chapter15.readFiveTimes.example;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex15_6_Buffer_Flush_R5 {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\cheerup\\java-basic-test\\src\\chapter15\\readFiveTimes\\example\\123_flush_R5.txt");
            // BufferedOutputStream 의 버퍼 크기를 5로 한다.
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 5);
            // 파일 123_flush_R5.txt 에 1 부터 9까지 출력한다.
            for (int i = '1'; i <= '9'; i++) { // 아스키 코드로 저장되고 텍스트 파일로 열 때 기대하는 문자가 보인다.
                bufferedOutputStream.write(i); // write(i);는 정수 i 값을 그대로 파일에 기록
            }

            bufferedOutputStream.close(); // BufferedOutputStream 을 닫는다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
