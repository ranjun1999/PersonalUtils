package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 *  '.' 匹配任意单个字符
 *  '*' 匹配零个或多个前面的那一个元素
 *
 *
 * @Author: ranjun
 * @Date: 2019/11/26 19:04
 */
public class 正则表达式匹配 {

    /**
     * 1. 回溯法
     *
     * 如果模式串中有星号，它会出现在第二个位置，即 pattern[1] 。
     * 这种情况下，我们可以直接忽略模式串中这一部分，或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符，即 pattern[0] 。
     * 如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        //判空，递归结束条件
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        //判断第一个字符是否匹配
        boolean first_match = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {    //如果模式串中有星号，它会出现在第二个位置，即 pattern[1]
            return (isMatch(s, p.substring(2)) ||       //匹配零个前面那个字符，即直接忽略模式串这一部分
                    (first_match && isMatch(s.substring(1), p)));   //匹配多个前面那个元素，即删除匹配串的第一个字符
        } else return first_match && isMatch(s.substring(1), p.substring(1));
    }

    public static boolean isMatch_2(String s, String p) {

        return false;
    }
    public static void main(String[] args) {
        String str = "t";
        System.out.println(str.substring(1).isEmpty());
    }
}
