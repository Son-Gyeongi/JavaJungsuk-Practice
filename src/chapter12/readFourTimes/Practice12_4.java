package chapter12.readFourTimes;

import java.util.ArrayList;

public class Practice12_4 {
    // 지네릭 메서드
    public static <T extends Product> ArrayList<T> merge(
            ArrayList<T> list, ArrayList<T> list2
    ) {
        ArrayList<T> newList = new ArrayList<>(list);

        newList.addAll(list2);

        return newList;
    }
}
