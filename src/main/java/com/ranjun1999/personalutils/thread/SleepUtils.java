package com.ranjun1999.personalutils.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ranjun
 * @Date: 2019/11/4 21:25
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
