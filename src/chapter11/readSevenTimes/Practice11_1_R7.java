package chapter11.readSevenTimes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class Practice11_1_R7 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(7);

        HashSet<Integer> set = new HashSet<>(list); // 중복 제거
        TreeSet<Integer> treeSet = new TreeSet<>(set); // 정렬(오름차순)
        Stack<Integer> stack = new Stack<>(); // FILO(First In Last Out)
        stack.addAll(treeSet);

        while (!stack.empty()) { // Stack 의 empty() 메서드
            System.out.println(stack.pop());
        }

        /*while (!stack.isEmpty()) { // 상속받은 Vector 의 isEmpty() 메서드
            System.out.println(stack.pop());
        }*/
    }
}
