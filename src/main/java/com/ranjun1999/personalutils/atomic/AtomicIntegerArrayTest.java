package com.ranjun1999.personalutils.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Author: ranjun
 * @Date: 2019/11/16 16:49
 */
public class AtomicIntegerArrayTest {

    static int[] value = new int[]{1,2};

    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        System.out.println(ai.addAndGet(0, 12));
        System.out.println(ai.get(0));
        System.out.println(value[0]);

        int a = 1, b = 1;

        System.out.println(a == b);
    }
}
