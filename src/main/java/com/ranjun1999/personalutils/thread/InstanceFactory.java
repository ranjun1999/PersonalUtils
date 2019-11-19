package com.ranjun1999.personalutils.thread;

/**
 * @Author: ranjun
 * @Date: 2019/11/2 19:51
 */
public class InstanceFactory {

    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }
    public static Instance getInstance() {
        return InstanceHolder.instance ; // 这里将导致InstanceHolder类被初始化
    }


    private static class Instance{

    }
}
