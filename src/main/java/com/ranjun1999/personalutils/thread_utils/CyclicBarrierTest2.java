package com.ranjun1999.personalutils.thread_utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: ranjun
 * @Date: 2019/11/16 20:38
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier c = new CyclicBarrier(3);
    public static void main(String[] args){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
            }
        });
        thread.start();
//        thread.interrupt();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
            }
        });
        thread2.start();

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println(c.isBroken());
        }

        System.out.println("end");
    }

}
