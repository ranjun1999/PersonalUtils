package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @Author: ranjun
 * @Date: 2019/11/26 18:50
 */
public class 回文数 {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int original = x;
        int rev = 0;

        while (x != 0) {
            int poll = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10) return false;
            if (rev < Integer.MIN_VALUE / 10) return false;

            rev = rev * 10 + poll;
        }

        return rev == original;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
}
