package com.ranjun1999.personalutils.atomic;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * @Author: ranjun
 * @Date: 2019/11/16 17:08
 */
public class CompareAndSetTest {



    private static final VarHandle VALUE;

    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            VALUE = l.findVarHandle(CompareAndSetTest.class, "value", String.class);
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }

    private volatile String value;

    public String get() {
        return value;
    }

    public void set(String newValue) {
        value = newValue;
    }

    public final boolean compareAndSet(String expectedValue, String newValue) {
        return VALUE.compareAndSet(this, expectedValue, newValue);
    }


    public static void main(String[] args) {
        CompareAndSetTest test = new CompareAndSetTest();
        String ran = new String("ranjun");
        test.set(ran);

        String newValue = "Wangjun";

        if (test.compareAndSet(ran, newValue)) {
            System.out.println(test.get() == newValue);
        }
    }
}
