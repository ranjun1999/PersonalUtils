package com.ranjun1999.personalutils.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ranjun
 * @Date: 2019/11/16 16:20
 */
public class AtomicIntegerTest {

    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        if (ai.compareAndSet(1,20)) {   //如果expectedValue == ai的内存中的value，则以原子方式将value替换为newValue
            System.out.println(ai.get());
        }
    }

}
