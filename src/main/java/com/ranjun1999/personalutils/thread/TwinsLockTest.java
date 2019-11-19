package com.ranjun1999.personalutils.thread;

import java.util.concurrent.locks.Lock;

/**
 * @Author: ranjun
 * @Date: 2019/11/8 20:33
 */
public class TwinsLockTest {

    public static void main(String[] args) {
        final Lock lock = new TwinsLock();

        class Worker extends Thread{
            @Override
            public void run() {
                while (true) {
                    lock.lock();

                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
//                        SleepUtils.second(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }

        //启动十个线程
        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        //每1秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println("*****************");
        }
    }


}
