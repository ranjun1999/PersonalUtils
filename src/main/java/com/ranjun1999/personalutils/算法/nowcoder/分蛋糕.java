package com.ranjun1999.personalutils.算法.nowcoder;

/**
 * 分蛋糕时，有如下几个原则：
 * 1.不希望一个盘子里出现两种蛋糕
 * 2.希望每个盘子中都有蛋糕
 * 3.想让装有最少蛋糕数量的盘子中装有的蛋糕数量尽可能多
 * @Author: ranjun
 * @Date: 2020/7/27 14:36
 */
public class 分蛋糕 {

    /**
     *    链接：https://www.nowcoder.com/questionTerminal/435b7ac0d7eb4927a0ce4ef2ffcc1385?answerType=1&f=discussion
     *         来源：牛客网
     *
     * 使用二分法。
     * 假设盘子中最少的蛋糕数是 mid，那么 a 蛋糕所占盘子的数目小于等于 a / mid，b 蛋糕所占盘子的数目小于等于 b / mid。
     * 如果两种蛋糕所占盘子的数目之和小于 n，那么会有盘子中没有蛋糕，令 right = mid - 1。
     *
     * @param n int整型 n个盘子
     * @param a int整型 a蛋糕数量
     * @param b int整型 b蛋糕数量
     * @return int整型    在所有分法中，蛋糕数量最少的盘子中分到最多的蛋糕数量。
     */
    public int solve (int n, int a, int b) {
        // write code here

        // write code here
        int left = 1;
        int right = Math.min(a, b);
        int ans = left;
        while(left <= right){
            int mid = left + (right-left)/2;
            int k = a / mid + b / mid;
            if(k < n)
                right = mid - 1;
            else{
                left = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
