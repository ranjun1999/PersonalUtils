package com.ranjun1999.personalutils.算法.剑指Offer;

import java.util.Arrays;

/**
 * 请实现一个函数，把字符串的每个空格替换成 "%20"。
 * @Author: ranjun
 * @Date: 2020/7/30 16:32
 */
public class 替换空格_5 {

    public static String replaceBlank(String str) {
        StringBuilder sb = new StringBuilder(str);
        return str.replaceAll(" ", "%20");
    }

    /**
     * 使用字符数组进行替换
     * 先计算出替换后的字符数组长度，然后创建一个新的字符数组，将原字符串的内容复制进去
     * 新字符数组的长度 = 原长 + 空格数量 * 2
     * 从字符数组的后面开始复合替换。准备两个指针 P1 和 P2。P1指向原字符数组末尾，P2指向新字符数组的末尾。
     * 然后向前一定P1指针，逐个把字符复制到P2指向的位置，直到碰到第一个空格位置。
     * 碰到第一个空格后，把P1向前移动一格，在P2之前插入“%20”，并把P2也向前移动3格
     * 直到P1=P2，所有空格替换完成
     * @param str
     * @return
     */
    public static String replaceBank(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        char[] originalChar = str.toCharArray();
        //字符串长
        int originalLength = str.length();
        //空格数量
        int numberOfBlank = 0;
        for (int i = 0; i < originalLength; i++) {
            if (str.charAt(i) == ' ') {
                numberOfBlank ++;
            }
        }
        int newLength = originalLength + numberOfBlank * 2;

        //新字符串
        char[] newChar = Arrays.copyOf(originalChar,newLength);

        int p1 = originalLength - 1;
        int p2 = newLength - 1;
        while (p1 > 0 && p2 > p1) {
            //遇到空格后 在p2位置插入"%20"
            if (newChar[p1] == ' ') {
                newChar[p2--] = '0';
                newChar[p2--] = '2';
                newChar[p2--] = '%';
            }else newChar[p2--] = newChar[p1];
            p1 --;
        }
        return new String(newChar);
    }

    public static void main(String[] args) {
//        System.out.println(replaceBlank("we are happy"));
        System.out.println(replaceBank("we are happy"));
    }
}
