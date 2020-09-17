package com.ranjun1999.personalutils.算法.nowcoder.string;

/**
 *
 * 给定一个只包含小写字母的字符串s，将这个字符串中的所有'a'字母全部移动到字符串的末尾，而且保证其它字符的相对顺序不变。其中字符串s的长度<=1e6。
 *
 * 输入:
 * "abcavv"
 * 输出：
 * "bcvvaa"
 * @Author: ranjun
 * @Date: 2020/7/29 11:16
 */
public class 移动字符串 {

    public static String changeA(String str) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (char c:str.toCharArray()) {
            if (c == 'a') {
                cnt ++;
            }else {
                sb.append(c);
            }
        }
        while (cnt--> 0) {
            sb.append('a');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(changeA("abcavv"));
    }
}
