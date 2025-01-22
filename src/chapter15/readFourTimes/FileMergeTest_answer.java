package chapter15.readFourTimes;

import java.io.*;
import java.util.Vector;

public class FileMergeTest_answer {
    public static void main(String[] args) {
        // 입력값이 2보다 작으면, 메시지를 출력하고 종료한다.
        if (args.length < 2) {
            System.out.println("USAGE: java FileMergeTest MERGE_FILENAME FILENAME1 FILENAME2 ...");
            System.exit(0);
        }

        try {
            Vector vector = new Vector();

            for (int i = 1; i < args.length; i++) {
                File file = new File(args[i]);

                if (file.exists()) {
                    vector.add(new FileInputStream(file));
                } else {
                    System.out.println(args[i] + " - 존재하지 않는 파일입니다.");
                    System.exit(0);
                }
            }

            // SequenceInputStream 를 활용해서 여러 스트림을 하나의 스트림처럼 다룰 수 있다.
            SequenceInputStream sequenceInputStream = new SequenceInputStream(vector.elements());
            FileOutputStream fileOutputStream = new FileOutputStream(args[0]);

            int data = 0;

            while ((data = sequenceInputStream.read()) != -1) {
                fileOutputStream.write(data);
            }
        } catch (IOException e) {}
    }
}
