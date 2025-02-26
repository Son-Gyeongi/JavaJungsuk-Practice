package chapter10.readSixTimes.example;

import java.text.DecimalFormat;

public class Ex10_6 {
    public static void main(String[] args) {
        double number = 1234567.89;
        String[] pattern = {
                "0",
                "#",
                "0.0",
                "#.#",
                "0000000000.0000",
                "##########.####",
                "#.#-",
                "-#.#",
                "#,###.##",
                "#,####.##",
                "#E0",
                "0E0",
                "##E0",
                "00E0",
                "####E0",
                "0000E0",
                "#.#E0",
                "0.0E0",
                "0.000000000E0",
                "00.00000000E0",
                "000.0000000E0",
                "#.#########E0",
                "##.########E0",
                "###.#######E0",
                "#,###.##+;#,###.##-",
                "#.#%",
                "#.#\u2030",
                "\u00A4 #,###",
                "'#'#,###", // '#'을 문자 그대로 출력, 작은따옴표(')는 "여기부터 일반 문자로 해석해!" 라는 신호
                "''#,###" // 작은따옴표(')를 출력, 작은따옴표(') 자체를 출력하려면 두 개('')를 사용
        };

        for (int i = 0; i < pattern.length; i++) {
            DecimalFormat decimalFormat = new DecimalFormat(pattern[i]);
            System.out.printf("%19s : %s\n", pattern[i], decimalFormat.format(number));
        }
    }
}
