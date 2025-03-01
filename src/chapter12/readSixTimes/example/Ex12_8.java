package chapter12.readSixTimes.example;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
페이지 497, 500
*/
@Deprecated
@SuppressWarnings("1111") // 유효하지 않은 어노테이션은 무시된다.
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "160101", hhmmss = "235959"))
public class Ex12_8 {
    public static void main(String[] args) {
        // Ex12_8 의 Class 객체를 얻는다.
        Class<Ex12_8> cls = Ex12_8.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
        System.out.println("anno.testDate().hhmmss() = " + anno.testDate().hhmmss());

        for (String str : anno.testTools()) {
            System.out.println("testTools=" + str);
        }

        System.out.println();
        
        // Ex12_8 에 적용된 모든 어노테이션을 가져온다.
        Annotation[] annoArr = cls.getAnnotations();

        for (Annotation annotation : annoArr) {
            System.out.println(annotation);

            System.out.println("annotation.toString() = " + annotation.toString());
            System.out.println("annotation.hashCode() = " + annotation.hashCode());
            System.out.println("annotation.equals() = " + annotation.equals(annotation));
            System.out.println("annotation.annotationType() = " + annotation.annotationType());
            System.out.println();
        }
    }
}

// 사용자 정의 어노테이션 만들기
@Retention(RetentionPolicy.RUNTIME) // 실행 시에 사용가능하도록 지정
@interface TestInfo {
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUnit";
    TestType testType() default TestType.FIRST;
    DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME) // 실행 시에 사용가능하도록 지정
@interface DateTime {
    String yymmdd();
    String hhmmss();
}

enum TestType {
    FIRST, FINAL,
}