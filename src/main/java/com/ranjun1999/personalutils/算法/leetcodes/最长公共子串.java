package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * @Author: ranjun
 * @Date: 2019/11/23 21:57
 */
public class 最长公共子串 {

    public static String lcs(String str1, String str2) {

        //将两个字符串分别以行和列组成一个二维矩阵
        int[][] arr = new int[str1.length()][str2.length()];

        //最大长度
        int maxLen = 0;
        //最长结尾
        int maxEnd = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                //比较二维矩阵中每个点对应行列字符中否相等，相等的话值设置为1，否则设置为0。
                if (str1.charAt(i) == str2.charAt(j)) {
                    // i =0或j = 0时，设为1
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    }else arr[i][j] = arr[i-1][j-1] + 1; //左上角对角线长度加一（公共子串长度加一）
                }
                //记录最大长度
                if (arr[i][j] > maxLen) {
                    maxLen = arr[i][j];
                    maxEnd = i; //以i位置的字符作为结尾
                }
            }
        }

        return str1.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    public static void main(String[] args) {
        System.out.println(lcs("abcdek1","abcucdeki1"));
    }
}
