package com.ranjun1999.personalutils.thread;

/**
 * 双重检查锁定
 * @Author: ranjun
 * @Date: 2019/11/2 17:30
 */
public class DoubleCheckLocking {

    private volatile static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLocking.class) {
                if (instance == null) {
                    instance = new Instance();  //instance现在为volatile类型变量
                }

            }
        }
        return instance;
    }

    private static class Instance{

    }
}
