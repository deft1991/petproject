package com.deft.fox;

import java.util.Collections;
import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 15.12.2020
 */
public class TestClass {

    public static void main(String[] args) {
        System.out.println(Long.toBinaryString(1L));
        System.out.println(Long.toBinaryString(1L << 1));
        System.out.println(Long.toBinaryString(1L << 2));
        System.out.println(Long.toBinaryString(1L << 3));
        System.out.println(Long.toBinaryString(1L << 4));

        System.out.println(Long.toBinaryString(0L | (1L << 1)));
        System.out.println(Long.toBinaryString((1L << 1) | (1L << 2)));
        System.out.println(Long.toBinaryString((1L << 1) | (1L << 2) | (1L<<3)));


        System.out.println(Long.toBinaryString((1L << 1) | (1L << 2) & ~(1L<<2)));

        System.out.println("-=-=-=-=-=-");
        System.out.println(Long.toBinaryString(((1L << 1) | (1L << 2) | (1L<<3)) & 1L));
        System.out.println(Long.toBinaryString((1L | 2L | 3L | 4L) & 4L));

    }

    static void printRez() {
        List<Integer> arrayList = List.of(1, 2, 3, 4, 9, 6, 7);

        Collections.sort(arrayList);

        Integer start = 0;
        String rez = "";

        for (int i = 1; i < arrayList.size(); i++) {
            int prev = arrayList.get(i - 1);
            int cur = arrayList.get(i);

            if (prev + 1 == cur) {
                if (start == null) {
                    start = prev;
                }
            } else {
                rez += start + "-" + cur + ",";
                start = null;
            }

        }
        System.out.println(rez);
    }



}
