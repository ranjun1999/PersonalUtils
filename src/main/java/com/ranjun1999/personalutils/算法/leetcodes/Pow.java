package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * @Author: ranjun
 * @Date: 2019/12/7 19:28
 */
public class Pow {

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }


    public static void main(String[] args) {
//        System.out.println(myPow(0.0001,2147483647 ));
    }
}
