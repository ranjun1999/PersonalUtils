package com.ranjun1999.personalutils.算法.剑指Offer;

/**
 * @Author: ranjun
 * @Date: 2020/9/10 15:02
 */
public class MaxProductAfterCutting_14 {

    /**
     * 有一根长度为n的绳子，现在要把绳子剪成 m 段，每段绳子的长度记k[0]，k[1]...,k[m-1]
     * 求k[0]*k[1]...*k[m-1]的最大值
     *
     *动态规划:
     * 定义函数f(n)为把长度为n的绳子剪成若干段后各段长度乘积的最大值。在剪第一刀时，有n- 1种可能。
     * 因此f(n) = max(f(i) * f(n - i))，（ 0 < i < n ）
     * @param length
     * @return
     */
    public static int maxProductAfterCutting(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        //子问题的最优解都保存在数组products中，products[i]表示把长度为i的绳子剪成若干段后各段长度的乘积的最大值
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;

        for (int i = 4; i <= length; i++) {
            max = 0;
            //将长度为i的绳子剪为若干段
            for (int j = 1; j <= i/2; j++) {
                int product = products[j] * products[i - j];
                if (max < product)
                    max = product;
            }
            //保存最大值
            products[i] = max;
        }
        max = products[length];
        return max;
    }


    /**
     * 贪婪算法：n >= 5时候，尽肯能多剪长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成两端长度为2的绳子
     *应该当n >= 5时，2（n - 2） > n，3（n-3）>n，且3(n-3) > 2(n-2)，所以应该多剪长度为3的绳子
     * @param length
     * @return
     */
    public static int maxProductAfterCutting_solution2(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int timesOf3 = length / 3;
        //当绳子剩下长度为4时，不能再剪去长度为3的绳子，因为2*2>1*3
        if (length - timesOf3 * 3 == 1)
            timesOf3 -= 1;
        int timesOf2 = (length - timesOf3 * 3)/2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting_solution2(6));
    }

}
