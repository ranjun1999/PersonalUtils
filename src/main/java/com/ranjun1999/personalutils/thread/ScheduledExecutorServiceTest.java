package com.ranjun1999.personalutils.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author: ranjun
 * @Date: 2020/7/26 16:20
 */
@Slf4j
public class ScheduledExecutorServiceTest {

    private static ScheduledExecutorService mScheduledExecutorService = Executors.newScheduledThreadPool(5);


    public static void onCreate() {
//        // 延时任务
//       mScheduledExecutorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                log.info("lzp-----------" + "first task");
//            }
//        }, 5, TimeUnit.SECONDS);

//         循环任务，按照上一次任务的发起时间计算下一次任务的开始时间
        mScheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.info("lzp----------"+"first" + System.currentTimeMillis() / 1000);
            }
        }, 1, 2, TimeUnit.SECONDS);
//
        // 循环任务，以上一次任务的结束时间计算下一次任务的开始时间
//        mScheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
//            @Override
//            public void run() {
//                log.info("lzp---------"+"scheduleWithFixedDelay:" + System.currentTimeMillis() / 1000);
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, 1, 1, TimeUnit.SECONDS);
//

    }

    public static void main(String[] args) {
        onCreate();
    }

}
