package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author: ranjun
 * @Date: 2019/11/27 20:52
 */
public class 最长公共前缀 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length <= 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }
        int i = 1;
        String common = strs[0];
        //遍历数组，依次寻找每两个字符串的公共前缀
        while (i < strs.length) {
            common = commonPrefix(common, strs[i]);
            if (common == null) {
                return "";
            }
            i ++;
        }

        return common;
    }

    /**
     * 两个字符串的公共前缀
     * @param str1
     * @param str2
     * @return
     */
    public static String commonPrefix(String str1, String str2) {
        int min = Math.min(str1.length(),str2.length());
        StringBuilder sd = new StringBuilder();
        for (int i = 0; i < min; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            sd.append(str1.charAt(i));
        }
        return sd.toString();
    }


    public static String longestCommonPrefix_2(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //获得两个字符串的公共前缀
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0,prefix.length() -1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        String[] strs = {"fower","flow","flight"};

        System.out.println(longestCommonPrefix(strs));

        String str = "abcdefg";
        System.out.println(str.substring(0,str.length() - 1));
    }
}
