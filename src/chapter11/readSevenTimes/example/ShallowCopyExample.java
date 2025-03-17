package chapter11.readSevenTimes.example;

import java.util.HashSet;

/*
페이지 424
HashSet 클래스의 clone() 얕은 복사
 */
public class ShallowCopyExample {
    public static void main(String[] args) {
        // HashSet 예시
        HashSet<PersonShallowCopy> originalSet = new HashSet<>();
        originalSet.add(new PersonShallowCopy("Alice"));
        originalSet.add(new PersonShallowCopy("Bob"));

        // 얕은 복사 수행
        HashSet<PersonShallowCopy> clonedSet = (HashSet<PersonShallowCopy>) originalSet.clone();

        System.out.println("원본 Set: " + originalSet);
        System.out.println("복제된 Set: " + clonedSet);

        // 원본 Set의 첫 번째 요소 수정
        PersonShallowCopy firstPerson = originalSet.iterator().next();
        firstPerson.setName("Changed Alice");

        System.out.println("\n요소 수정 후:");
        System.out.println("원본 Set: " + originalSet);
        System.out.println("복제된 Set: " + clonedSet); // 복제본에도 변경이 반영됨

        // 새로운 요소 추가 - 컬렉션 자체는 독립적
        originalSet.add(new PersonShallowCopy("Charlie"));

        System.out.println("\n요소 추가 후:");
        System.out.println("원본 Set: " + originalSet);
        System.out.println("복제된 Set: " + clonedSet); // 복제본에는 추가되지 않음
    }
}

class PersonShallowCopy {
    private String name;

    public PersonShallowCopy(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person[name=" + name + "]";
    }
}