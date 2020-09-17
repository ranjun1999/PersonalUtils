package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 * @Author: ranjun
 * @Date: 2019/12/16 19:57
 */
public class _38_报数 {

    /**
     * 打印下一个数
     * @param str
     * @return
     */
    public static String nextSay(String str) {
        int i = 0;
        //保存下一个字符
        StringBuilder sb = new StringBuilder();
        while (i < str.length()) {
            Character c = str.charAt(i);
            int count = 0;
            //统计相同数字的数量
            while (i < str.length() && str.charAt(i) == c) {
                i++;
                count ++ ;
            }
            sb.append(count).append(c);
        }
        return sb.toString();
    }


    public static String countAndSay(int n) {
        String res = "1";
        //从1开始遍历n-1次，就可以当前报数序列
        for (int i = 1; i < n; i++) {
            res = nextSay(res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));

    }
}
