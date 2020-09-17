package com.ranjun1999.personalutils.算法.剑指Offer;

/**
 * @Author: ranjun
 * @Date: 2020/9/11 9:49
 */
public class PrintMaxOfDigits_17 {

    /**
     *打印从1开始，到最大的n位十进制数
     * 这里输入的n可能会很大，如果用整型输出数据会溢出，所以使用字符串实现整数的加法
     * @param n
     */
    public static void printMaxOfDigits(int n) {
        if (n < 0)
            return;
        StringBuilder sb = new StringBuilder();
        //初始字符串长度
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        Boolean isOvewFlow = false;
        int nLength = sb.length();
        while (!isOvewFlow) {
            int nTakeOver = 0;
            //数字递增
            for (int i = nLength - 1; i >= 0; i--) {
                int nSum = sb.charAt(i) - '0' + nTakeOver;
                if (i == nLength - 1)
                    nSum++;
                //向前进位
                if (nSum >= 10) {
                    //如果最高位大于10，则结束递增
                    if (i == 0) {
                        isOvewFlow = true;
                    } else {
                        nSum -= 10;
                        nTakeOver = 1;
                        sb.setCharAt(i, (char) (nSum + '0'));
                    }
                } else {
                    sb.setCharAt(i, (char) (nSum + '0'));
                    break;
                }
            }
            if (!isOvewFlow) {
                //碰到第一个非0字符开始打印
                boolean isBeginning0 = true;
                for (int i = 0; i < sb.length(); i++) {
                    if (isBeginning0 && sb.charAt(i) != '0')
                        isBeginning0 = false;
                    if (!isBeginning0) {
                        System.out.print(sb.toString().substring(i) + ",");
                        break;
                    }
                }
            }
        }
    }

    /**
     * 大数相加
     * @param num1
     * @param num2
     * @return
     */
    public static String add(String num1, String num2) {
        if (num1 == null && num2 == null)
            return null;
        if (num1 == null && num2 != null) {
            return num2;
        }
        if (num2 == null && num1 != null) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
//        sb.append(0);
        int index1 = num1.length() - 1,index2 = num2.length() - 1;
        int takeOver = 0;
        while (index1 >= 0 && index2 >= 0) {
            int sum = (num1.charAt(index1) - '0') + (num2.charAt(index2) - '0') + takeOver;
            if (sum >= 10) {
                sum -= 10;
                takeOver = 1;
                sb.insert(0,(char)(sum + '0'));
            }else {
                takeOver = 0;
                sb.insert(0,(char)(sum + '0'));
            }
            index1--;
            index2--;
        }
        while (index1 >= 0) {
            int sum = (num1.charAt(index1) - '0') + takeOver;
            if (sum >= 10) {
                sum -= 10;
                takeOver = 1;
                sb.insert(0,(char)(sum + '0'));
            }else {
                takeOver = 0;
                sb.insert(0,(char)(sum + '0'));
            }
            index1--;
        }
        while (index2 >= 0) {
            int sum = (num1.charAt(index1) - '0') + takeOver;
            if (sum >= 10) {
                sum -= 10;
                takeOver = 1;
                sb.insert(0,(char)(sum + '0'));
            }else {
                takeOver = 0;
                sb.insert(0,(char)(sum + '0'));
            }
            index2--;
        }
        if (takeOver > 0) {
            sb.insert(0,takeOver);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(add("999999999999999","1"));
    }
}
