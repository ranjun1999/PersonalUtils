package com.ranjun1999.personalutils.算法.剑指Offer;

/**
 * 单例模式
 * @Author: ranjun
 * @Date: 2020/7/30 11:47
 */
public class Singleton_2 {
    private volatile static  Singleton_2 singleton;

    private Singleton_2(){

    }

    /**
     *在多线程的情况下，这样写可能会导致singleton有多个实例
     * @return
     */
    public Singleton_2 getSingleton(){
        if (singleton == null) {
            singleton = new Singleton_2();
        }
        return singleton;
    }

    /**
     * 执行双重检查是因为，如果多个线程同时了通过了第一次检查，并且其中一个线程首先通过了第二次检查并实例化了对象，那么剩余通过了第一次检查的线程就不会再去实例化对象。
     *
     * 这样，除了初始化的时候会出现加锁的情况，后续的所有调用都会避免加锁而直接返回，解决了性能消耗的问题。
     *
     * 使用了volatile关键字后，重排序被禁止，所有的写（write）操作都将发生在读（read）操作之前。
     * @return
     */
    public Singleton_2 getSingleton_DoubleCheck() {
        if (singleton == null) {
            synchronized (Singleton_2.class) {
                if (singleton == null) {
                    singleton = new Singleton_2();
                }
            }
        }
        return singleton;
    }

    private static class SingletonInstance{
        static Singleton_2 singleton2 = new Singleton_2();
    }

    /**
     * 使用静态内部类，在类加载阶段会加锁
     * @return
     */
    public Singleton_2 getSingle_Static() {
        return SingletonInstance.singleton2;
    }
}
