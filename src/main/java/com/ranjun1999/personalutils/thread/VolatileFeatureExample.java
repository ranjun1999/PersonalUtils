package com.ranjun1999.personalutils.thread;

/**
 * @Author: ranjun
 * @Date: 2019/10/31 20:49
 */
public class VolatileFeatureExample {
    volatile long v1 = 0L;

    public void setV1(long v1) {
        this.v1 = v1;  //单个volatile变量的写
    }

    public void getAndIncrement(){
        v1 ++; //复合volatile变量的读写
    }

    public long getV1() {
        return v1;  //单个volatile变量的读
    }
}

class EqualVolatileFeaturesExample {
    long vl = 0L; // 64位的long型普通变量

    public synchronized void set(long l) { // 对单个的普通变量的写用同一个锁同步
        vl = l;
    }
    public void getAndIncrement () { // 普通方法调用
        long temp = get(); // 调用已同步的读方法
        temp += 1L; // 普通写操作
        set(temp); // 调用已同步的写方法
    }





    public synchronized long get() { // 对单个的普通变量的读用同一个锁同步
        return vl;
    }
}