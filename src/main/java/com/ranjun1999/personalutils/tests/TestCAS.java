package com.ranjun1999.personalutils.tests;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * @Author: ranjun
 * @Date: 2019/10/11 19:28
 */
public class TestCAS {

    private static final VarHandle WAITSTATUS;

    private static final VarHandle NEXT;

    volatile int waitStatus;
    volatile TestCAS next;
    int data;

    public TestCAS(int data){
        this.data = data;
    }

    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            WAITSTATUS = l.findVarHandle(TestCAS.class, "waitStatus", int.class);
             NEXT = l.findVarHandle(TestCAS.class, "next", TestCAS.class);
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }

    /** CASes waitStatus field. */
    final boolean compareAndSetWaitStatus(int expect, int update) {
        return WAITSTATUS.compareAndSet(this, expect, update);
    }

    final boolean compareAndSetNext(TestCAS expect, TestCAS update) {
        return NEXT.compareAndSet(this, expect, update);
    }

    public static void main(String[] args) {

       TestCAS node = new TestCAS(1);
       node.waitStatus = 1;
       node.next = new TestCAS(100);

        System.out.println(node.next);

        TestCAS n1 = node.next;

        TestCAS n2 = new TestCAS(101);
        System.out.println(n2);

        if (node.compareAndSetNext(n1, n2)) {
            System.out.println(node.next);

            System.out.println(n1);
            System.out.println(n2);
        }

        if (node.compareAndSetWaitStatus(1, 202)) {
            System.out.println(node.waitStatus);
        }
    }
}


