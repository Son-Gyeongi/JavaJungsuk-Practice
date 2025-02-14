package chapter15.readFiveTimes.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex15_11_R5 {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("C:\\cheerup\\java-basic-test\\src\\chapter15\\readFiveTimes\\example\\Ex15_11_R5.java");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = ""; // 라인 단위로 읽어온다.
            for (int i = 1; (line = bufferedReader.readLine()) != null; i++) {
                // ";"를 포함한 라인을 출력한다.
                if (line.indexOf(";") != -1) { // line.contains(";") 더 좋을 거 같다.
                    System.out.println(i + ":" + line);
                }
            }

            bufferedReader.close(); // 자원 반환
        } catch (IOException e) {}
    }
}
