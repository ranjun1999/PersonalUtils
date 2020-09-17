package com.ranjun1999.personalutils.算法.nowcoder;

/**
 * 给定一个正整数n，[n/i](i = 1~n)的和，[x]为向下取整
 * 答案可能会很大，输出答案对998244353取模后的值。
 * @Author: ranjun
 * @Date: 2020/7/28 9:43
 */
public class 浅尝陬值 {

    /**
     * 假设n = 10:
     *	i      1	2	3	4	5	6	7	8	9	10
     *[n/i]   10	5	3	2	2	1	1	1	1	1
     *
     * 表中同样的值会连续出现，可根据不同的数值划分出不同的分块。
     *
     * 假设已知某个分块的左端点 left  ，求出右端点 right，则有 [left/n] = [right/n] 。
     * 令 k = [n/left]，则 right = [n/k]  。
     * 范围 [left ,right] 内的数值都相等，即为k 。
     * @param n
     * @return
     */
    public static int work(long n) {
        int mod = 998244353;
        long ans = 0;
        long left = 1, right = 0;
        while (left <= n) {
            long k = n/left;
            right = n/k;
            ans += (right - left + 1)*k;
            ans %= mod;
            left = right + 1;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(9/2);
        System.out.println();
    }
}



