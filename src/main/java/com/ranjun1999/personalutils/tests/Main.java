package com.ranjun1999.personalutils.tests;

import java.util.Scanner;

/**
 * @Author: ranjun
 * @Date: 2020/3/19 17:03
 *
 * 首先给出你一个整数，可能为正也可能为负，这个数字中仅包含数字1-9，
 * 现在定义一个1-9的置换，即指定将整数中的某个数字按顺序变换为另一个数字，请你输出变换以后的数字是多少。
 */
public class Main {

    public static void main(String[] args) {
        //要被替换的数
        int num = 0;
        Scanner in = new Scanner(System.in);
        String value = in.next();
        String realValue = "";
        if (value.indexOf("-") > -1){
            realValue = value.substring(value.indexOf("-") + 1);
        }else realValue = value;
        int n = realValue.length();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.valueOf(String.valueOf(realValue.charAt(i)));
        }
        int[] nums = new int[9];
        for (int i = 0; i < nums.length; i++) {
            int val = in.nextInt();
            while (val <= 0 || val > 9) {
                System.out.println("重新输入：");
                val = in.nextInt();
            }
            nums[i] = val;
        }
        replace(values,nums);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
        }
       if (value.indexOf("-") > -1){
           System.out.println("-" + sb.toString());
       }else System.out.println(sb.toString());
    }

    public static void replace(int[] values, int nums[]){
        for (int i = 0; i < values.length; i++) {
            values[i] = nums[values[i] - 1];
        }
    }
}