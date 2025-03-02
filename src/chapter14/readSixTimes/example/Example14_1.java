package chapter14.readSixTimes.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
페이지 576
스트림 만들기 - 파일과 빈 스트림
 */
public class Example14_1 {
    public static void main(String[] args) {
        /*
        디렉토리 경로 지정
        Paths.get() - 원하는 디렉토리 경로의 Path 객체 생성
         */
        Path path = Paths.get("C:\\cheerup\\java-basic-test\\src\\chapter14\\readSixTimes");
        Path path2 = Paths.get("C:\\cheerup\\java-basic-test\\src\\chapter14");

        try {
            /*
            Files.list()는 직접적인 내용만 반환하며 하위 디렉토리의 내용은 포함하지 않습니다.
            재귀적으로 모든 파일을 나열하려면 Files.walk()를 대신 사용할 수 있습니다.
             */
            Stream<Path> fileList = Files.list(path);
            fileList.forEach(System.out::println);

            System.out.println();

            System.out.println("===== chapter14 하위 디렉토리 포함하지 않음 (Files.list()) =====");
            Stream<Path> fileList2 = Files.list(path2);
            fileList2.forEach(System.out::println);

            System.out.println();

            System.out.println("===== chapter14 하위 디렉토리 포함 (Files.walk()) =====");
            Stream<Path> fileList3 = Files.walk(path2);
            fileList3.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("===== 빈 스트림 만들기 =====");
        Stream<Integer> emptyStream = Stream.empty(); // empty() 는 빈 스트림을 생성해서 반환한다.
        long count = emptyStream.count();
        System.out.println("emptyStream count = " + count);
        /*
        요소가 하나도 없는 비어있는 스트림을 생성할 수도 있다.
        스트림에 연산을 수행한 결과가 하나도 없을 때, null 보다 빈 스트림을 반환하는 것이 낫다.
         */
    }
}
