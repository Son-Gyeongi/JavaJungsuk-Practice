package chapter15.readFourTimes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
커맨드 라인으로 부터 여러 파일의 이름을 입력받고,
이 파일들을 순서대로 합쳐서 새로운 파일을 만들어 내는 프로그램
단, 합칠 파일의 개수에는 제한을 두지 않는다.
 */
public class FileMergeTest {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("USAGE: java FileMergeTest MERGE_FILENAME FILENAME1 FILENAME2 ...");
            System.exit(0);
        }

        // MERGE_FILENAME 이 없는 경우 만들기
        File mergeFile = new File(args[0]);
        try {
            if (mergeFile.exists()) {
                // 기존에 파일에 있는 내용 삭제하기 위해서 파일을 삭제하고 새로 생성하기
                mergeFile.delete();
            }

            mergeFile.createNewFile();
        } catch (Exception e) {}

//        Vector<FileInputStream> fileList = new Vector<>();
        List<FileInputStream> fileList = new ArrayList<>();

        try {
            for (int i = 1; i < args.length; i++) {
                File file = new File(args[i]);

                if (!file.exists() || file.isDirectory()) {
                    System.out.println(args[i] + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
                    continue;
                }

                fileList.add(new FileInputStream(file));
            }
        } catch (Exception e) {}

        // 매개변수로 받은 파일이 없는 경우
        if (fileList.isEmpty()) {
            System.out.println("USAGE: java FileMergeTest MERGE_FILENAME FILENAME1 FILENAME2 ...");
            System.exit(0);
        }

        // List 사용 - 파일마다 한 줄 띄우기
        try {
            for (FileInputStream fileInputStream : fileList) {
                // 입력
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

                // 출력
                // FileOutputStream(실제 파일, 기존의 파일 내용 덮어쓰기(true)/기본값 false)
                FileOutputStream fileOutputStream = new FileOutputStream(mergeFile, true);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                int data = 0;

                while ((data = bufferedInputStream.read()) != -1) {
                    bufferedOutputStream.write(data);
                }
                bufferedOutputStream.write(new byte[]{'\n'}); // 파일마다 한 줄 띄우기

                // 리소스 닫기
                bufferedOutputStream.close();
                bufferedInputStream.close();
            }
        } catch (Exception e) {}

        // Vector 사용
//        try {
//            SequenceInputStream sequenceInputStream = new SequenceInputStream(fileList.elements());
//            FileOutputStream fileOutputStream = new FileOutputStream(mergeFile);
//            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//            int data = 0;
//
//            while ((data = sequenceInputStream.read()) != -1) {
//                bufferedOutputStream.write(data);
//            }
//            bufferedOutputStream.close();
//        } catch (Exception e) {}
    }
}
