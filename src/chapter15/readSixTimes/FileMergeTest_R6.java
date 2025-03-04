package chapter15.readSixTimes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

// TODO 파일마다 한줄씩 띄우기
public class FileMergeTest_R6 {
    public static void main(String[] args) {
        // file 을 합치는 거라서 파일이 2개 이상은 와야할 거 같아서 2를 포함했다.
        if (args.length <= 2) {
            System.out.println("USAGE: java FileMergeTest_R6.java MERGE_FILENAME FILENAME1 FILENAME2 ...");
            System.exit(0);
        }

        File mergeFileName = new File(args[0]);

        Vector<FileInputStream> vector = new Vector<>();

        try {
            for (int i = 1; i < args.length; i++) {
                /*
                사용자로 부터 입력받은 값은 항상 유효성 체크하기!!
                파일이 존재하는지 유효성 검사
                 */
                File f = new File(args[i]);

                if (f.exists()) vector.add(new FileInputStream(args[i]));
                else {
                    System.out.println(args[i] + " - 존재하지 않는 파일입니다.");
                    System.exit(0);
                }
            }

            SequenceInputStream sequenceInputStream = new SequenceInputStream(vector.elements());
            FileOutputStream fileOutputStream = new FileOutputStream(mergeFileName);

            int data = 0;

            while ((data = sequenceInputStream.read()) != -1) {
                fileOutputStream.write(data);
            }

            sequenceInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {}
    }
}
