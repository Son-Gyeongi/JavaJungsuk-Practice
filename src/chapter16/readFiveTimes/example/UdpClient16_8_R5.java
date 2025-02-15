package chapter16.readFiveTimes.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/*
UDP 소켓 프로그래밍 - 클라이언트 프로그램
 */
public class UdpClient16_8_R5 {
    public void start() throws IOException, UnknownHostException {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

        // 데이터가 저장될 공간으로 byte 배열을 생성한다.
        byte[] msg = new byte[100];
        /*
        for (byte i = 0; i <= 10; i++) {
            msg[i] = i;
        }
        System.out.println(Arrays.toString(msg));
         */

        // byte[] msg 길이가 100이지만 길이가 1만 전송되서 byte[0] 만 전송이 된다.
        DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7777);
        DatagramPacket inPacket = new DatagramPacket(msg, msg.length);

        // DatagramPacket 을 전송하면 DatagramPacket 에 지정된 주소(호스트의 포트)의 DatagramSocket 에 도착한다.
        datagramSocket.send(outPacket); // DatagramPacket 을 전송한다.
        datagramSocket.receive(inPacket); // DatagramPacket 을 수신한다.

        System.out.println("current server time :" + new String(inPacket.getData()));

        datagramSocket.close();
    }

    public static void main(String[] args) {
        try {
            new UdpClient16_8_R5().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
