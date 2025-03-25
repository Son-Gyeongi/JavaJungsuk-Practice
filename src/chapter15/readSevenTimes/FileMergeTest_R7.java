package chapter15.readSevenTimes;

import java.io.*;
import java.util.Vector;

public class FileMergeTest_R7 {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("USAGE: java FileMergeTest_R7.java MERGE_FILENAME FILENAME1 FILENAME2 ...");
            System.exit(0);
        }

        String mergeFileName = args[0];
        File mergeFile = new File(mergeFileName);

        if (!mergeFile.exists() || mergeFile.isDirectory()) {
            System.out.println(mergeFileName + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
            System.exit(0);
        }

        Vector<InputStream> inputStreamList = new Vector<>(); // 연결할 파일들 저장할 곳
        byte[] lineSeparator = System.lineSeparator().getBytes(); // 운영체제 줄바꿈

        try {
            for (int i = 1; i < args.length; i++) {
                String fileName = args[i];
                File file = new File(fileName);

                if (!file.exists() || file.isDirectory()) {
                    System.out.println(fileName + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
                    System.exit(0);
                }

                FileInputStream fileInputStream = new FileInputStream(file);
                inputStreamList.add(fileInputStream);

                // 줄바꿈 추가
                if (i != args.length - 1) {
                    inputStreamList.add(new ByteArrayInputStream(lineSeparator));
                }
            }
        } catch (Exception e) {
            System.out.println("FileInputStream 진행 중 에러 발생");
            e.printStackTrace();
            System.exit(0);
        }

        // 여러 파일 합치기
        try {
            SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStreamList.elements());
            FileOutputStream fileOutputStream = new FileOutputStream(mergeFile);

            int ch;

            while ((ch = sequenceInputStream.read()) != -1) {
                fileOutputStream.write(ch);
            }

            sequenceInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
