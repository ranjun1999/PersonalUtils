package com.ranjun1999.personalutils.thread;

/**
 * 非线程安全延迟初始化
 *
 * @Author: ranjun
 * @Date: 2019/11/2 17:24
 */
public class UnsafeLazyInitialization {

    private static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            instance = new Instance();
        }

        return instance;
    }

    private static class Instance {

    }

    public static void main(String[] args) {
        System.out.println(0.1 + 0.2);
    }


}
