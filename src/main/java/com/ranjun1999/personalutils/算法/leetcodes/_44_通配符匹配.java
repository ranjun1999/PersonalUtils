package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 * @Author: ranjun
 * @Date: 2019/12/21 14:12
 */
public class _44_通配符匹配 {

    /**
     * 1. 双指针
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sn = s.length();
        int pn = p.length();
        int i = 0, j = 0;
        int start = -1;
        int match = 0;
        while (i < sn) {
            //一对一进行匹配，匹配成功i,j一起移动
            if (j < pn && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            }
            else if (j < pn && p.charAt(j) == '*') {    //记录p的"*"位置，和s的位置
                start = j;
                match = i;
                j++;
            }
            else if (start != -1) {
                //j回到记录的下一个位置
                j = start + 1;
                //match更新下一个位置
                match ++;
                i = match;
            }else return false;
        }
        //将多余的*匹配空字符串
        while (j < pn) {
            if (p.charAt(j) != '*') return false;
            j++;
        }
        return true;
    }

    /**
     * 2. 动态规划
     *dp[i][j]表示s到 i 位置与p到j位置是否匹配
     * 初始化:
     *
     * dp[0][0]:什么都没有,所以为true
     * 第一行dp[0][j],换句话说,s为空,与p匹配,所以只要p开始为*才为true
     * 第一列dp[i][0],当然全部为False
     * 动态方程:
     *
     * 如果(s[i] == p[j] || p[j] == "?") && dp[i-1][j-1] ,有dp[i][j] = true
     *
     * 如果p[j] == "*" && (dp[i-1][j] = true || dp[i][j-1] = true) 有dp[i][j] = true
     *
     * ​ note:
     *
     * ​ dp[i][j-1],表示*代表是空字符,例如ab,ab*
     *
     * ​ dp[i-1][j],表示*代表非空任何字符,例如abcd,ab*
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j-1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
