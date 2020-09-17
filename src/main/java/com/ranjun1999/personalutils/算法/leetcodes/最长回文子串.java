package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * @Author: ranjun
 * @Date: 2019/11/23 20:46
 */
public class 最长回文子串 {

    /**
     * 中心扩展法
     *时间复杂度O(n^2)
     *
     * 回文两侧互为镜像，因此回文可以从中心展开，并且只有2n-1个这样的中心。
     * 所含字母数为偶数的回文的中心可以处于两字母之间（例如 “abba” 的中心在两个 ‘b’ 之间）。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i + 1);
            int len = Math.max(len1, len2);
            if (len > (end - start)) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }

        }
        return s.substring(start, end + 1);
    }

    /**
     * 判断从中心扩展开是否为回文
     * @param s
     * @param left
     * @param right
     * @return
     */
    public int  expandAroundCenter(String s,int left, int right) {
        while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right++;
        }
        return right - left - 1; //返回回文子串的长度
    }

    public static void main(String[] args) {
            Thread b = new Thread();
            b.interrupt();
//            b.sleep(100);
//        Object o = new Object();
//        o.wait();
    }
}
