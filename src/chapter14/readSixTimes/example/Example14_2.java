package chapter14.readSixTimes.example;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
페이지 602
예제 14-10 의 Student 사용

예시에 summaryStatistics(), Collectors.summarizingInt() 은 어떤 기능이지?
 */
public class Example14_2 {
    public static void main(String[] args) {
        Student14_R6[] stuArr = {
                new Student14_R6("나자바", true, 1, 1, 300),
                new Student14_R6("김지미", false, 1, 1, 250),
                new Student14_R6("김자바", true, 1, 1, 200),
                new Student14_R6("이지미", false, 1, 2, 150),
                new Student14_R6("남자바", true, 1, 2, 100),
                new Student14_R6("안지미", false, 1, 2, 50),
                new Student14_R6("황지미", false, 1, 3, 100),
                new Student14_R6("강지미", false, 1, 3, 150),
                new Student14_R6("이자바", true, 1, 3, 200),
                new Student14_R6("나자바", true, 2, 1, 300),
                new Student14_R6("김지미", false, 2, 1, 250),
                new Student14_R6("김자바", true, 2, 1, 200),
                new Student14_R6("이지미", false, 2, 2, 150),
                new Student14_R6("남자바", true, 2, 2, 100),
                new Student14_R6("안지미", false, 2, 2, 50),
                new Student14_R6("황지미", false, 2, 3, 100),
                new Student14_R6("강지미", false, 2, 3, 150),
                new Student14_R6("이자바", true, 2, 3, 200)
        };

        long count = Stream.of(stuArr).count();
        Long collectCounting = Stream.of(stuArr).collect(Collectors.counting());
        System.out.println("count = " + count);
        System.out.println("collectCounting = " + collectCounting);

        System.out.println();

        int sum = Stream.of(stuArr).mapToInt(Student14_R6::getScore).sum();
        Integer collectSum = Stream.of(stuArr).collect(Collectors.summingInt(Student14_R6::getScore));
        System.out.println("sum = " + sum);
        System.out.println("collectSum = " + collectSum);

        System.out.println();

        Optional<Student14_R6> topStudent = Stream.of(stuArr).max(Comparator.comparingInt(Student14_R6::getScore));
        Optional<Student14_R6> collectTopStudent =
                Stream.of(stuArr).collect(Collectors.maxBy(Comparator.comparingInt(Student14_R6::getScore)));
        System.out.println("topStudent = " + topStudent);
        System.out.println("collectTopStudent = " + collectTopStudent);

        System.out.println();

        System.out.println("===== 이 기능은 대량의 데이터에 대한 통계를 계산할 때 특히 유용 =====");
        IntSummaryStatistics intSummaryStatistics =
                Stream.of(stuArr).mapToInt(Student14_R6::getScore).summaryStatistics();
        IntSummaryStatistics collectIntSummaryStatistics =
                Stream.of(stuArr).collect(Collectors.summarizingInt(Student14_R6::getScore));

        // IntSummaryStatistics{count=18, sum=3000, min=50, average=166.666667, max=300}
        System.out.println("intSummaryStatistics = " + intSummaryStatistics);
        System.out.println("intSummaryStatistics.getCount() = " + intSummaryStatistics.getCount());
        System.out.println("intSummaryStatistics.getSum() = " + intSummaryStatistics.getSum());
        System.out.println("intSummaryStatistics.getAverage() = " + intSummaryStatistics.getAverage());
        System.out.println("intSummaryStatistics.getMax() = " + intSummaryStatistics.getMax());
        System.out.println("intSummaryStatistics.getMin() = " + intSummaryStatistics.getMin());
        System.out.println();

        // IntSummaryStatistics{count=18, sum=3000, min=50, average=166.666667, max=300}
        System.out.println("collectIntSummaryStatistics = " + collectIntSummaryStatistics);
        System.out.println("collectIntSummaryStatistics.getCount() = " + collectIntSummaryStatistics.getCount());
        System.out.println("collectIntSummaryStatistics.getSum() = " + collectIntSummaryStatistics.getSum());
        System.out.println("collectIntSummaryStatistics.getAverage() = " + collectIntSummaryStatistics.getAverage());
        System.out.println("collectIntSummaryStatistics.getMax() = " + collectIntSummaryStatistics.getMax());
        System.out.println("collectIntSummaryStatistics.getMin() = " + collectIntSummaryStatistics.getMin());
    }
}
