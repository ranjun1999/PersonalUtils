package com.ranjun1999.personalutils.算法.剑指Offer;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 *  '*' 匹配零个或多个前面的那一个元素
 * @Author: ranjun
 * @Date: 2020/9/11 17:28
 */
public class MatchPattern {

    static boolean isMatch(String str, String pattern){
        if (str == null || pattern == null)
            return false;
        //返回条件
        if (pattern.isEmpty()){
            return str.isEmpty();
        }
        //首字符是否相同
        boolean firstMatch = (!str.isEmpty() &&
                (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.'));
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {    //如果模式串中有星号，它会出现在第二个位置，即 pattern[1]
            return (isMatch(str,pattern.substring(2)) ||        //匹配零个前面那个字符，即直接忽略模式串这一部分
                    (firstMatch && isMatch(str.substring(1),pattern)));     //匹配多个前面那个元素，即删除匹配串的第一个字符
        }else return isMatch(str.substring(1),pattern.substring(1));
    }
}
