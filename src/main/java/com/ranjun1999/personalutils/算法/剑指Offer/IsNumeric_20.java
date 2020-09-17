package com.ranjun1999.personalutils.算法.剑指Offer;

/**
 * 表示数值的字符串
 * @Author: ranjun
 * @Date: 2020/9/14 9:51
 */
public class IsNumeric_20 {

    /**
     * 判断输入的字符串是否表示数值（包括整数和小数）
     *
     * 表示字符串的形式都遵守模式A[.[B]][e | E C]
     * A为数值的整数部分，B为紧跟着小数点的小数部分，C为紧跟着'e'或'E'的数值的指数部分。
     * 其中，小数可能没有整数部分，例如：小数.23,因此A部分可能为空，但是此时小数部分不能为空。
     * A和C都可以以'+'或者'-'开头，但是B前面不能有正负号。
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        boolean numeric = false;
        int numIndex = str.lastIndexOf("e") > 0 ? str.lastIndexOf("e") : str.length();
        //数值部分
        String numVal = str.substring(0,numIndex);
        numeric = scanInteger(numVal);
        //指数部分
        if (numIndex < str.length()) {
            str = str.substring(numIndex + 1,str.length());
            numeric = numeric && str.matches("[\\+\\-]?\\d+");
        }
        return numeric;
    }

    /**
     * 扫描字符串的'0~9'的数位
     * @param str
     * @return
     */
    public static boolean scanUnsignedInteger(String str) {
        String pattern = "^\\d*\\.?\\d+$";
        return str.matches(pattern);
    }

    /**
     * 扫描可能以'+'或'-'为起始的0~9的数位
     * @return
     */
    public static boolean scanInteger(String str) {
       if (str.charAt(0) == '+' || str.charAt(0) == '-') {
           str = str.substring(1);
       }
        return scanUnsignedInteger(str.toString());
    }

    public static void main(String[] args) {
        System.out.println(isNumeric(".345E"));
    }
}
