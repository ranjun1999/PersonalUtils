package com.ranjun1999.personalutils.thread.collections;

/**
 * @Author: ranjun
 * @Date: 2019/11/10 18:43
 */
public class ConcurrentHashMapTest {

    static int hash(int h) {
        h += (h << 15) ^ 0xffffcd7d;
        h ^= (h >>> 10);
        h += (h << 3);
        h ^= (h >>> 6);
        h += (h << 2) + (h << 14);
        return h ^ (h >>> 16);
    }


    public static void main(String[] args) { }


}



