package com.ranjun1999.personalutils.tests;

/**
 * @Author: ranjun
 * @Date: 2019/11/12 19:56
 */
public class ReenSort {
    int a = 0;
    volatile boolean flag = false;


    public void writer() {
        a = 1; // 1
        flag = true; // 2
    }
    public void reader() {
        if (flag) { // 3
            int i = a * a; // 4
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ReenSort sort = new ReenSort();

        Thread t1 = new Thread(()->{
            System.out.println("writer runing");
            sort.writer();
        });

        t1.start();

        Thread t2 = new Thread(()->{
            System.out.println("reader runing");
            sort.reader();
        });

        t2.start();

        t1.join();

        t2.join();

        System.out.println(sort.a);

    }
}


