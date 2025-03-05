package chapter15.readSixTimes.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.*;

public class Ex15_7 {
    public static void main(String[] args) {
        byte[] arr1 = {0, 1, 2};
        byte[] arr2 = {3, 4, 5};
        byte[] arr3 = {6, 7, 8};
        byte[] outSrc = null;

        /*
        Vector 활용
        Vector<ByteArrayInputStream> vector = new Vector<>();
        vector.add(new ByteArrayInputStream(arr1));
        vector.add(new ByteArrayInputStream(arr2));
        vector.add(new ByteArrayInputStream(arr3));

        SequenceInputStream input = new SequenceInputStream(vector.elements());
         */

        // List 활용
        List<ByteArrayInputStream> list = new ArrayList<>();
        list.add(new ByteArrayInputStream(arr1));
        list.add(new ByteArrayInputStream(arr2));
        list.add(new ByteArrayInputStream(arr3));
        // Collections 클래스를 활용해서 Enumeration 을 만들 수 있다.
        Enumeration<ByteArrayInputStream> enumerationList = Collections.enumeration(list);
        SequenceInputStream input = new SequenceInputStream(enumerationList);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;

        try {
            while ((data = input.read()) != -1) {
                output.write(data);
            }

            input.close(); // 'SequenceInputStream' used without 'try'-with-resources statement 해결
        } catch (IOException e) {}

        outSrc = output.toByteArray();

        System.out.println("Input Source1 :" + Arrays.toString(arr1));
        System.out.println("Input Source2 :" + Arrays.toString(arr2));
        System.out.println("Input Source3 :" + Arrays.toString(arr3));
        System.out.println("Output Source :" + Arrays.toString(outSrc));
    }
}
