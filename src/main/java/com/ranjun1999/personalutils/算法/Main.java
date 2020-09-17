package com.ranjun1999.personalutils.算法;

import java.util.Scanner;

/**
 * @Author: ranjun
 * @Date: 2020/7/31 18:56
 */
public class Main {


    public static int getResult(int n, int m) {
        long start = System.currentTimeMillis();
        System.out.println(start);
        //带0头牛出来
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            long a = n;
            long sum = 1;
            long sum_2 = 1;
            long sum_3 = 1;
            for (int j = i; j >= 1; j--) {
                sum = (long) ((sum * (a--)) % (1e9 + 7));
                sum_2 =  (long) ((sum_2 *m) % (1e9 + 7));
                sum_3 = (long) ((sum_3 * j) % (1e9 + 7));
            }
            ans += ((sum/sum_3)*sum_2) % (1e9 + 7);
        }
        System.out.println(System.currentTimeMillis());
        return (int) (ans % (1e9 + 7));
    }



    public static void main(String[] args) {
        System.out.println(Math.pow(2,2));
    }
}
