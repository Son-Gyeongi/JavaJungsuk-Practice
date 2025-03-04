package chapter15.readSixTimes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

// TODO 파일마다 한줄씩 띄우기
public class FileMergeTest_R6 {
    public static void main(String[] args) {
        if (args.length <= 2) {
            System.out.println("USAGE: java FileMergeTest_R6.java MERGE_FILENAME FILENAME1 FILENAME2 ...");
        }

        File mergeFileName = new File(args[0]);

        Vector<FileInputStream> vector = new Vector<>();

        try {
            for (int i = 1; i < args.length; i++) {
                vector.add(new FileInputStream(args[i]));
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
