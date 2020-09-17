package com.ranjun1999.personalutils.算法.剑指Offer;

/**
 * @Author: ranjun
 * @Date: 2020/9/9 16:16
 */
public class Fibonacci_10 {

    /**
     * 求斐波那契数列的第n项
     * f(0) = 0, f(1) = 1;
     * f(n) = f(n-1) + f(n-2) n >= 2;
     * @param n
     * @return
     */
    public long fibonacci(int n) {
        int[] result = {0,1};
        if (n < 2)
            return result[n];
        long fibMinusOne = 1L,fibMinusTwo = 0L;
        long fibN = 0L;
        for (int i = 2; i <= n; i++) {
            fibN = fibMinusTwo + fibMinusOne;
            fibMinusTwo = fibMinusOne;
            fibMinusOne = fibN;
        }
        return fibN;
    }
}
