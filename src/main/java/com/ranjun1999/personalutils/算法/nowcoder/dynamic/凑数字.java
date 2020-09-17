package com.ranjun1999.personalutils.算法.nowcoder.dynamic;

/**
 *
 * 数字一共有九种类型，分别是1-9这九个数字，每个数字的价钱都不一样，而且每个数字的货源都非常充足。
 * 用自己能够承受的价格，从这些数字里面购买，并且凑到最大的数字带回家。
 *
 * @Author: ranjun
 * @Date: 2020/7/27 11:44
 */
public class 凑数字 {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/c507734e1d3c40489ff18d75b0d57620?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 要凑成最大的数，
     *
     * 先求出最大的位数：遍历价格，求出最低的价格 a[minIndex]，则最大的位数为 k = n / a[minIndex]。
     * 再者，高位上的数字越大，数越大：如果钱有剩余，可以购买更大的数字，替换掉原来的数字，从高位开始替换。
     * @param n int整型 牛牛能够承受的价格
     * @param a int整型一维数组 1-9这九个数字的价格数组
     * @return string字符串
     */
    public static String solve (int n, int[] a) {
        // write code here
        int minIdex = 8;
        for (int i = 7; i >= 0; i--) {
            if (a[minIdex] > a[i]) {
                minIdex = i;
            }
        }
        if (n < a[minIdex]) {
            return "-1";
        }
        //最大的位数
        int count = n / a[minIdex];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(minIdex + 1);
        }

        //剩余金额
        int d = n % a[minIdex];
        if (d == 0) {
            return sb.toString();
        }

        //从高位开始购买最大的数字
        int j = 0;
        for (int i = 8; i > minIdex; i--) {
            while (a[i] <= a[minIdex] + d) {
                if (j < sb.length() ) {
                    sb.replace(j, j + 1, String.valueOf(i + 1));
                    d -= a[i] - a[minIdex];
                    j++;
                }
            }
            if (d <= 0) {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] a = {5,2,2,7,3,6,8,6,5};
        System.out.println(solve(1000000, a));
    }
}
