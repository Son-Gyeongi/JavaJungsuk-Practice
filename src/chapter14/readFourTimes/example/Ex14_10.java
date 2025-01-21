package chapter14.readFourTimes.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
스트림 2분할 - partitioningBy()
 */
public class Ex14_10 {
    public static void main(String[] args) {
        Student14[] stuArr = {
                new Student14("나자바", true, 1, 1, 300),
                new Student14("김지미", false, 1, 1, 250),
                new Student14("김자바", true, 1, 1, 200),
                new Student14("이지미", false, 1, 2, 150),
                new Student14("남자바", true, 1, 2, 100),
                new Student14("안지미", false, 1, 2, 50),
                new Student14("황지미", false, 1, 3, 100),
                new Student14("강지미", false, 1, 3, 150),
                new Student14("이자바", true, 1, 3, 200),
                new Student14("나자바", true, 2, 1, 300),
                new Student14("김지미", false, 2, 1, 250),
                new Student14("김자바", true, 2, 1, 200),
                new Student14("이지미", false, 2, 2, 150),
                new Student14("남자바", true, 2, 2, 100),
                new Student14("안지미", false, 2, 2, 50),
                new Student14("황지미", false, 2, 3, 100),
                new Student14("강지미", false, 2, 3, 150),
                new Student14("이자바", true, 2, 3, 200)
        };

        System.out.printf("1. 단순분할(성별로 분할)%n");
        Map<Boolean, List<Student14>> stuBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student14::isMale));

        List<Student14> maleStudent = stuBySex.get(true);
        List<Student14> femaleStudent = stuBySex.get(false);

        for (Student14 s : maleStudent) System.out.println(s);
        for (Student14 s : femaleStudent) System.out.println(s);

        System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student14::isMale,
                        Collectors.counting()));

        System.out.println("남학생 수 :" + stuNumBySex.get(true));
        System.out.println("여학생 수 :" + stuNumBySex.get(false));

        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<Student14>> topScoreBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student14::isMale,
                        Collectors.maxBy(Comparator.comparingInt(Student14::getScore))));

        System.out.println("남학생 1등 :" + topScoreBySex.get(true));
        System.out.println("여학생 1등 :" + topScoreBySex.get(false));

        Map<Boolean, Student14> topScoreBySex2 = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student14::isMale,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Student14::getScore)),
                                Optional::get
                        ))); // Optional 에서 값을 꺼내서 반환

        System.out.println("남학생 1등 :" + topScoreBySex2.get(true));
        System.out.println("여학생 1등 :" + topScoreBySex2.get(false));

        System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");

        Map<Boolean, Map<Boolean, List<Student14>>> failedStuBySex = Stream.of(stuArr)
                .collect(Collectors.partitioningBy(Student14::isMale,
                        Collectors.partitioningBy(s -> s.getScore() <= 100)));

        List<Student14> failedMaleStu = failedStuBySex.get(true).get(true);// 남자 불합격자
        List<Student14> failedFemaleStu = failedStuBySex.get(false).get(true);// 여자 불합격자

        for (Student14 s : failedMaleStu) System.out.println(s);
        for (Student14 s : failedFemaleStu) System.out.println(s);
    }
}
