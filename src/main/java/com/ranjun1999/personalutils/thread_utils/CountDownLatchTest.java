package com.ranjun1999.personalutils.thread_utils;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: ranjun
 * @Date: 2019/11/16 17:41
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println("3");
    }
}
