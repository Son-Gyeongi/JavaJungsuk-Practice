package chapter14.readFourTimes.example;

public class Student14 {
    String name;
    boolean isMale; // 성별
    int hak; // 학년
    int ban; // 반
    int score;

    public Student14(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }
    
    String getName() {
        return this.name;
    }

    boolean isMale() {
        return this.isMale;
    }

    int getHak() {
        return this.hak;
    }

    int getBan() {
        return this.ban;
    }

    int getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]",
                name, isMale ? "남" : "여", hak, ban, score);
        // 인스턴트 변수에 자기자신 참조변수 this. 생략
    }

    // groupingBy() 에서 사용
    enum Level {HIGH, MID, LOW} // 성적을 상, 중, 하 세 단계로 분류
}
