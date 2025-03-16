package chapter11.readSevenTimes;

import java.util.HashSet;

public class Practice11_5_R7 {
    public static void main(String[] args) {
        Sutda11_5_R7 c1 = new Sutda11_5_R7(3, true);
        Sutda11_5_R7 c2 = new Sutda11_5_R7(3, true);
        Sutda11_5_R7 c3 = new Sutda11_5_R7();
        // == Sutda11_5_R7 c3 = new Sutda11_5_R7(1, true)

        HashSet<Sutda11_5_R7> set = new HashSet<>();
        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println(set);
    }
}
