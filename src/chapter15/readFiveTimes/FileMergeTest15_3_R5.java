package chapter15.readFiveTimes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.Vector;

/*
커맨드라인으로 부터 여러 파일의 이름을 입력받고,
이 파일들을 순서대로 합쳐서 새로운 파일을 만들어 내는 프로그램(FileMergeTest15_3_R5) 작성
단, 합친 파일의 개수에는 제한을 두지 않는다.
 */
public class FileMergeTest15_3_R5 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("USAGE: java FileMergeTest15_3_R5 MERGE_FILENAME FILENAME1 FILENAME2 ...");
            System.exit(0);
        }

        try {
            String currentDir = System.getProperty("user.dir"); // 현재 프로그램이 실행중인 디렉토리
            String fileName = args[0];
            File resultFile = new File(currentDir, fileName);

            Vector<FileInputStream> vector = new Vector<>();
            for (int i = 1; i < args.length; i++) {
                File file = new File(args[i]);

                // file 이 존재하는지 확인
                // 사용자로 부터 입력받은 값은 항상 유효성체크를 해주어야한다.
                // 입력받은 파일이 존재하지 않을 수도 있기 때문이다.
                if (file.exists()) {
                    vector.add(new FileInputStream(args[i]));
                } else {
                    System.out.println(args[i] + " - 존재하지 않는 파일입니다.");
                    System.exit(0);
                }
            }

            /*
            여러 개의 파일을 하나로 연결하기 위해서 SequenceInputStream 사용
             */
            SequenceInputStream sequenceInputStream = new SequenceInputStream(vector.elements());
            FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
            // FileOutputStream(파일이름, 이어쓰기) 이어쓰기가 기본으로 false 그러므로 덮어쓴다.

            int data = 0;
            for (int i = 0; (data = sequenceInputStream.read()) != -1; i++) {
                fileOutputStream.write(data);
            }

            sequenceInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
