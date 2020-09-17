package com.ranjun1999.personalutils.算法.nowcoder.string;

/**
 *
 * 在所有可能的字符串中，'?'部分可以换成'5'，'2'，'0'，问位置不同的为 "520" 的子序列共有多少个？
 *
 * 某个字符串的子序列指的是去掉这个字符串中一些字符并保持剩下的字符相对顺序不变的情况下得到的序列。
 * 如 "ace" 和 "abc" 都是 "abcde" 的子序列。
 * @Author: ranjun
 * @Date: 2020/7/27 13:47
 */
public class 寻找520 {

    /**
     * 寻找所有的 520 子序列
     * @param S string字符串 牛牛准备的数字字符串
     * @return int整型
     */
    public static int findOccurrences (String S) {
        // write code her
        int sum5 = 0, sum2 = 0, sum0 = 0,i;
        char[] s = S.toCharArray();
        for(i = 0; i < S.length(); i++){
            switch(s[i]){
                case '5':
                    sum5++;
                    break;
                case '2':
                    sum2 = (sum5 + sum2) % 998244353;
                    break;
                case '0':
                    sum0 = (sum2 + sum0) % 998244353;
                    break;
                case '?':
                    sum0 = (sum2 + sum0) % 998244353;
                    sum2 = (sum5 + sum2) % 998244353;
                    sum5++;
                    break;
            }
        }
        return sum0;
    }



    public static void main(String[] args) {
        System.out.println(findOccurrences("?????"));
    }
}
