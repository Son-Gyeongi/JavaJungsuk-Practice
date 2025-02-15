package chapter16.readFiveTimes.example;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

/*
TCP 소켓 프로그래밍 - 클라이언트 프로그램
 */
public class TcpIpClient16_7_R5 {
    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";

            System.out.println("서버에 연결중입니다. 서버 IP :" + serverIp);
            // 소켓을 생성하여 연결을 요청한다.
            // 연결하고자 하는 서버의 IP 와 포트 번호를 가지고 소켓을 생성하면 자동적으로 서버에 연결요청을 하게 된다.
            // 서버와 연결을 실패하면 ConnectException 발생
            Socket socket = new Socket(serverIp, 7777);

            // 소켓의 입력스트림을 얻는다.
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            // 소켓으로 부터 받은 데이터를 출력한다.
            System.out.println("서버로부터 받은 메시지 :" + dataInputStream.readUTF());
            System.out.println("연결을 종료합니다.");

            // 스트림과 소켓을 닫는다.
            dataInputStream.close();
            socket.close();
            System.out.println("연결이 종료되었습니다.");
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
