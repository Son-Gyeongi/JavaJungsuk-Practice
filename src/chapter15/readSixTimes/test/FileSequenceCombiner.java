package chapter15.readSixTimes.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileSequenceCombiner {
    public static void combineFilesWithNewlines(List<File> files, File outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int i = 0; i < files.size(); i++) {
                try (BufferedReader reader = new BufferedReader(new FileReader(files.get(i)))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine(); // 각 라인 후 줄바꿈 추가
                    }
                }
            }
        }
    }

    // 직접 SequenceInputStream을 사용하는 대안 메서드
    public static void combineFilesWithSequenceInputStream(List<File> files, File outputFile) throws IOException {
        List<InputStream> inputStreams = new ArrayList<>();
        byte[] newline = System.lineSeparator().getBytes();
        // System.out.println(Arrays.toString(newline)); // [13, 10]
        /*
        `System.lineSeparator().getBytes()`는 운영 체제에 따라 다른 줄바꿈 문자를 바이트 배열로 변환하는 역할을 합니다.
        운영 체제별로 줄바꿈 문자가 다르기 때문에 이 메서드를 사용하면 플랫폼 독립적인 줄바꿈을 처리할 수 있습니다.

        구체적으로:
        - Windows 에서는 `\r\n` (Carriage Return + Line Feed)
        - Unix/Linux/macOS 에서는 `\n` (Line Feed)

        예를 들어:
        - Windows 에서 `System.lineSeparator().getBytes()`는 `[13, 10]` (CR, LF)를 반환
        - Unix 계열 시스템에서는 `[10]` (LF)를 반환

        코드에서 이 줄은 시스템에 맞는 줄바꿈 바이트를 생성하여, 파일을 병합할 때 해당 시스템의 표준 줄바꿈 문자를 사용하도록 보장합니다.
        이를 통해 운영 체제에 상관없이 일관된 줄바꿈을 유지할 수 있습니다.
         */

        for (int i = 0; i < files.size(); i++) {
            inputStreams.add(new FileInputStream(files.get(i)));

            // 마지막 파일이 아니라면 줄바꿈 스트림 추가
            if (i < files.size() - 1) {
                inputStreams.add(new ByteArrayInputStream(newline));
            }
        }

        try (SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(inputStreams));
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = sequenceInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) {
        try {
            List<File> files = Arrays.asList(
                    new File("C:\\cheerup\\java-basic-test\\src\\chapter15\\readSixTimes\\1_R6.txt"),
                    new File("C:\\cheerup\\java-basic-test\\src\\chapter15\\readSixTimes\\2_R6.txt"),
                    new File("C:\\cheerup\\java-basic-test\\src\\chapter15\\readSixTimes\\3_R6.txt")
            );
            File outputFile = new File("C:\\cheerup\\java-basic-test\\src\\chapter15\\readSixTimes\\test\\combined.txt");

            // 두 가지 방법 중 선택 가능
//            combineFilesWithNewlines(files, outputFile);
            // 또는
             combineFilesWithSequenceInputStream(files, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}