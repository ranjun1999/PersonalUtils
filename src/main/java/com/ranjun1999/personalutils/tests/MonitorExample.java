package com.ranjun1999.personalutils.tests;

/**
 * @Author: ranjun
 * @Date: 2019/11/12 21:09
 */
public class MonitorExample {

    int a = 0;
    public synchronized void writer() { // 1
        a++; // 2
    } // 3
    public synchronized void reader() { // 4
        int i = a; // 5
    }


}
