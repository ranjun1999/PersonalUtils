package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理
 *
 * @Author: ranjun
 * @Date: 2019/12/18 21:59
 */
public class _43_字符串相乘 {

    /**
     * 使用数组存储每一位，然后按照竖式乘除法相乘，
     *   123
     * x 456
     * 即计算123x6（3x6, 2x6, 1x6）
     * 123x5（3x5, 2x5, 1x5）
     * 123x4（3x4, 2x4, 1x5）
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] arr1 = new int[num1.length()];
        int[] arr2 = new int[num2.length()];

        // 初始化两个乘数数组
        for (int i=0; i<arr1.length; i++) {
            arr1[i] = num1.charAt(i)-'0';
        }
        for (int i=0; i<arr2.length; i++) {
            arr2[i] = num2.charAt(i)-'0';
        }

        int maxLen = num1.length() + num2.length() + 1;
        int[] res = new int[maxLen];

        int temp = 0, extra = 0, m=0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                temp = arr1[j]*arr2[i];
                m = (arr1.length - 1 - j) + (arr2.length - 1 - i);  //m标记当前数位
                res[m] += temp;
                //循环判断进位，累加至不需要进位
                while (res[m] >= 10) {
                    extra = res[m]/10;
                    res[m] = res[m]%10;
                    m++;
                    res[m] += extra;
                }
            }
        }
        // 构造结果字符串
        StringBuffer resString = new StringBuffer("");
        for (int i=m; i>=0; i--) {
            resString.append(Integer.toString(res[i]));
        }
        return resString.toString();

    }
}
