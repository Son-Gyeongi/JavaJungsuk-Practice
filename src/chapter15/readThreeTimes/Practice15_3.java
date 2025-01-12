package chapter15.readThreeTimes;

import java.io.*;
import java.util.Vector;

public class Practice15_3 {
    public static void main(String[] args){
        if (args.length < 2) {
            System.out.println("USAGE: java Practice15_3 MERGE_FILENAME FILENAME1 FILENAME2");
            System.exit(0);
        }

        try {
            Vector<FileInputStream> vector = new Vector<>();

            for (int i = 0; i < args.length; i++) {
                File file = new File(args[i]);

                if (file.exists()) {
                    vector.add(new FileInputStream(args[i]));
                } else {
                    System.out.println(args[i] + " - 존재하지 않는 파일입니다.");
                    System.exit(0);
                }
            }

            // SequenceInputStream 생성 - 책에 없는 파일마다 줄바꿈 추가
            try (SequenceInputStream input = new SequenceInputStream(vector.elements());
                 FileOutputStream output = new FileOutputStream(args[0]);
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output))) {

                int data;
                for (int i = 0; i < vector.size(); i++) {
                    InputStream fileStream = vector.get(i);

                    // 파일 내용 복사
                    while ((data = fileStream.read()) != -1) {
                        writer.write(data);
                    }

                    // 파일마다 줄바꿈 추가
                    writer.newLine();

                    fileStream.close(); // 개별 파일 스트림 닫기
                }

                System.out.println("파일 병합이 완료되었습니다: " + args[0]);
            }

            /*
            책 답 - 줄바꿈이 안된다.
            SequenceInputStream input = new SequenceInputStream(vector.elements());
            FileOutputStream output = new FileOutputStream(args[0]);

            int data = 0;

            while ((data = input.read()) != -1) {
                output.write(data);
            }
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
