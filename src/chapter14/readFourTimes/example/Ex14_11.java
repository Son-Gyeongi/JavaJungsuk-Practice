package chapter14.readFourTimes.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
스트림 n분할 - groupingBy()
 */
public class Ex14_11 {
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

        System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
        Map<Integer, List<Student14>> stuByBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student14::getBan));

        for (List<Student14> ban : stuByBan.values()) {
            for (Student14 s : ban) {
                System.out.println(s);
            }
        }

        System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
        Map<Student14.Level, List<Student14>> stuByLevel = Stream.of(stuArr)
                .collect(Collectors.groupingBy(s -> {
                    if (s.getScore() >= 200) return Student14.Level.HIGH;
                    else if (s.getScore() >= 100) return Student14.Level.MID;
                    else return Student14.Level.LOW;
                }));

        // TreeSet 중복이 없고 기본 정렬 기준으로 정렬된다.
        TreeSet<Student14.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for (Student14.Level key : keySet) {
            System.out.println("[" + key + "]");

            // 키에 대한 값 List<Student14> 출력
            for (Student14 s : stuByLevel.get(key)) {
                System.out.println(s);
            }
            System.out.println();
        }

        System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
        Map<Student14.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(Collectors.groupingBy(s -> {
                    if (s.getScore() >= 200) return Student14.Level.HIGH;
                    else if (s.getScore() >= 100) return Student14.Level.MID;
                    else return Student14.Level.LOW;
                }, Collectors.counting()));

        for (Student14.Level key : stuCntByLevel.keySet())
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        System.out.println();

        /*
        이전에 만든 '성적별로 그룹화' 랑 연결해도 되겠다.
        for (List<Student14> level : stuByLevel.values()) {
            System.out.println();
            for (Student14 s : level) {
                System.out.println(s);
            }
        }
         */

        System.out.printf("%n4. 다중그룹화(학년별, 반별)");
        Map<Integer, Map<Integer, List<Student14>>> stuByHakAndBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student14::getHak,
                        Collectors.groupingBy(Student14::getBan)));

        for (Map<Integer, List<Student14>> hak : stuByHakAndBan.values()) {
            for (List<Student14> ban : hak.values()) {
                System.out.println();
                for (Student14 s : ban) {
                    System.out.println(s);
                }
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, Student14>> topStuByHakAndBan = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student14::getHak,
                        Collectors.groupingBy(Student14::getBan,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                                Comparator.comparingInt(Student14::getScore)
                                        ), Optional::get
                                ))));

        for (Map<Integer, Student14> ban : topStuByHakAndBan.values()) {
            for (Student14 s : ban.values())
                System.out.println(s);
        }

        System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
        // 주어진 조건에 따라 내가 만들어 본 거
        /*
        Map<Integer, Map<Integer, Map<Student14.Level, Set<Student14>>>> stuByScoreGroupIsMine = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student14::getHak,
                        Collectors.groupingBy(Student14::getBan,
                                Collectors.groupingBy(
                                        s -> {
                                            if (s.getScore() >= 200) return Student14.Level.HIGH;
                                            else if (s.getScore() >= 100) return Student14.Level.MID;
                                            else return Student14.Level.LOW;
                                        }, Collectors.toSet()
                                )
                        )));

        for (Integer keyHak : stuByScoreGroupIsMine.keySet()) {
            Map<Integer, Map<Student14.Level, Set<Student14>>> ban = stuByScoreGroupIsMine.get(keyHak);

            for (Integer keyBan : ban.keySet()) {
                System.out.print("[" + keyHak + "-" + keyBan + "]");

                Map<Student14.Level, Set<Student14>> levelSet = ban.get(keyBan);
                System.out.println(levelSet.keySet());
            }
        }
         */

        // 위에 코드를 mapping 으로 바꾼 뒤 실행해보기
        Map<Integer, Map<Integer, Set<Student14.Level>>> stuByScoreGroupIsMine = Stream.of(stuArr)
                .collect(Collectors.groupingBy(Student14::getHak,
                        Collectors.groupingBy(Student14::getBan,
                                Collectors.mapping(
                                        s -> {
                                            if (s.getScore() >= 200) return Student14.Level.HIGH;
                                            else if (s.getScore() >= 100) return Student14.Level.MID;
                                            else return Student14.Level.LOW;
                                        }, Collectors.toSet()
                                )
                        )));

        for (Integer keyHak : stuByScoreGroupIsMine.keySet()) {
            Map<Integer, Set<Student14.Level>> ban = stuByScoreGroupIsMine.get(keyHak);

            for (Integer keyBan : ban.keySet()) {
                System.out.print("[" + keyHak + "-" + keyBan + "]");
                System.out.println(ban.get(keyBan));
            }
        }

        System.out.printf("%n책 예시%n");
        Map<String, Set<Student14.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(Collectors.groupingBy(
                        s -> s.getHak() + "-" + s.getBan(),
                        Collectors.mapping(s -> {
                            if (s.getScore() >= 200) return Student14.Level.HIGH;
                            else if (s.getScore() >= 100) return Student14.Level.MID;
                            else return Student14.Level.LOW;
                        }, Collectors.toSet())
                ));

        Set<String> keySet2 = stuByScoreGroup.keySet();

        for (String key : keySet2) {
            System.out.println("[" + key + "]" + stuByScoreGroup.get(key));
        }
    }
}
