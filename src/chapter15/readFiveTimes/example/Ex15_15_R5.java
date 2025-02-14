package chapter15.readFiveTimes.example;

import java.io.File;
import java.net.URI;

/*
File(URI uri)
지정된 URI 로 파일 생성하면 어떤 값을 가져오는 걸까?
-> 파일 URI를 File 객체로 변환 (로컬 파일 경로를 다룰 때 유용한 생성자)
 */
public class Ex15_15_R5 {
    public static void main(String[] args) {
        // 일반적인 파일 경로 - \는 Java에서 이스케이프 문자라서 \\ 두 개를 써야 함.
//        File file = new File("C:\\cheerup\\java-basic-test\\src\\chapter15\\readFiveTimes\\example\\123_flush_R5.txt");

        try {
            // URI 형식(file:///) - URI에서는 /(슬래시)만 사용해야 함.
            URI uri = new URI("file:///C:/cheerup/java-basic-test/src/chapter15/readFiveTimes/example/123_flush_R5.txt");
            File fileURI = new File(uri);
            String fileName = fileURI.getName();
            int pos = fileName.indexOf(".");

            System.out.println("경로를 제외한 파일이름 - " + fileName);
            System.out.println("확장자를 제외한 파일 이름 - " + fileName.substring(0, pos));
            System.out.println("확장자 - " + fileName.substring(pos + 1));

            System.out.println("경로를 포함한 파일이름   - " + fileURI.getPath());
            System.out.println("파일의 절대경로         - " + fileURI.getAbsolutePath());
            System.out.println("파일의 정규경로         - " + fileURI.getCanonicalPath());
            System.out.println("파일이 속해 있는 디렉토리 - " + fileURI.getParent());
            System.out.println();

            System.out.println("File.pathSeparator - " + File.pathSeparator);
            System.out.println("File.pathSeparatorChar - " + File.pathSeparatorChar);
            System.out.println("File.separator - " + File.separator);
            System.out.println("File.separatorChar - " + File.separatorChar);
            System.out.println();

            // 현재 프로그램이 실행 중인 디렉토리
            System.out.println("user.dir=" + System.getProperty("user.dir"));
            // sun.boot.class.path 라는 시스템 속성에 기본적인 경로들 설정되어 잇다.
            System.out.println("sun.boot.class.path=" + System.getProperty("sun.boot.class.path"));
        } catch (Exception e) {}
    }
}
