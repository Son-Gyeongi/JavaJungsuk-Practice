package chapter04.readFourTimes;

public class Practice4_4_answer {
    public static void main(String[] args) {
        int sum = 0; // 총합 저장
        int opt = 1; // 값의 부호를 바꿔주는데 사용할 변수
        int num = 0;

        for (int i = 1; true; i++, opt = -opt) {
            num = i * opt;
            sum += num;

            if (sum >= 100) {
                break;
            }
        }

//        for (int i = 1; sum < 100; i++, opt = -opt) {
//            num = i * opt;
//            sum += num;
//        }

        System.out.println("num = " + num);
        System.out.println("sum = " + sum);
    }
}
