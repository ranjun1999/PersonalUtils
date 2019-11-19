package com.ranjun1999.personalutils.thread.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: ranjun
 * @Date: 2019/11/10 17:13
 */
public class WrongMap {

    public static void main(String[] args) throws InterruptedException{
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();

        Thread.sleep(10000);
        Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String,String> entry = iter.next();
            System.out.println(entry.getKey() + "," +entry.getValue() );
        }
    }
}
