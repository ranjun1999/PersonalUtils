package com.ranjun1999.personalutils.utils;



import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * create by tanwt
 * 2018/7/7 0007 11:03
 **/
public class PrintUtil {

    /**
     * 打印List
     * @param list
     */
    public static <T> void pringList(List<T> list){
        System.out.println("list.size: " + list.size());
        for (T t : list){
            System.out.println(t);
        }
    }
    /**
     * 打印map
     * @param map
     */
    public static void pringMap(Map map){
//        Set<String> keys = map.keySet();
        Iterator<Map.Entry> iter = map.entrySet().iterator();
        System.out.print("[");
        while(iter.hasNext()){
            Map.Entry entry = iter.next();
            System.out.print(entry.getKey() + ": " + entry.getValue() + " ,");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("1234".substring(0,3));
    }

}
