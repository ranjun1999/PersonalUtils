package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *

 * @Date: 2019/11/25 21:32
 */
public class 字符串转换整数 {

    public static int myAtoi(String str) {
        //剔除空空格
        str = str.trim();
        StringBuilder sb = new StringBuilder();
        if(str.length() <= 0){
            return 0;
        }
        //字符串开头只能是‘+’、‘-’或者是数字，排除这些外，全都不符合规则
        if(str.charAt(0)=='+' || str.charAt(0)=='-' || Character.isDigit(str.charAt(0))) {
            sb.append(str.charAt(0));
        } else {
            return 0;
        }

        int i=1;
        while(i<str.length()) {
            //碰到非数字字符，直接返回
            if(!Character.isDigit(str.charAt(i))) {
                break;
            }
            sb.append(str.charAt(i));
            //因为int 的范围是-2147483648——2147483647，只要截取的长度超过8位，就有可能超过int的范围
            if(i>8) {
                if (Long.valueOf(sb.toString())>Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if(Long.valueOf(sb.toString())<Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
            i++;
        }
        //如果字符串只是"+"或者是"-"，返回0
        if((sb.charAt(0)=='+' || sb.charAt(0)=='-') && i==1) {
            return 0;
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("  +1212"));
    }
}


