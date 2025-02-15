package chapter16.readFiveTimes.example;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/*
자바에서 IP 주소를 다루기 위한 클래스 - InetAddress
 */
public class Ex16_1_R5 {
    public static void main(String[] args) {
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try {
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("getHostName() :" + ip.getHostName());
            System.out.println("getHostAddress() :" + ip.getHostAddress());
            System.out.println("toString() :" + ip.toString());

            /*
            IPv4 주소는 4바이트로 구성되며, 각 바이트는 0~255 범위의 값을 가집니다.
            하지만 Java의 byte 타입은 -128 ~ 127 범위를 가지므로, 128~255 값은 음수로 변환됩니다.
            부호 있는 byte 타입
             */
            byte[] ipAddr = ip.getAddress();
            System.out.println("getAddress() :" + Arrays.toString(ipAddr));

            // 바이트 값을 0~255 범위의 부호 없는 정수로 변환하려면, b & 0xFF 연산을 사용
            // 네트워크 관련 작업할 때는 항상 b & 0xFF를 활용하는 습관을 들이면 좋습니다!
            // 비트 AND 연산 - 이 연산을 수행하면 Java의 부호 있는 byte를 부호 없는 int로 변환
            // IP 주소 등에서 byte 값을 다룰 때는 b & 0xFF를 써야 제대로 된 값이 나온다!
            // 0xFF       =  00000000 00000000 00000000 11111111
            String r = "";
            for (int i = 0; i < ipAddr.length; i++) {
                r += (ipAddr[i] & 0xFF) + ".";
            }
            System.out.println("바이트 값을 0~255 범위의 부호 없는 정수로 변환 : " + r);

            String result = "";
            for (int i = 0; i < ipAddr.length; i++) {
                result += (ipAddr[i] < 0 ? ipAddr[i] + 256 : ipAddr[i]) + ".";
            }
            System.out.println("getAddress()+256 :" + result);
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ip = InetAddress.getLocalHost();
            System.out.println("getHostName() = " + ip.getHostName());
            System.out.println("getHostAddress() = " + ip.getHostAddress());
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ipArr = InetAddress.getAllByName("www.naver.com");

            for (int i = 0; i < ipArr.length; i++) {
                System.out.println("ipArr[" + i + "] :" + ipArr[i]);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
