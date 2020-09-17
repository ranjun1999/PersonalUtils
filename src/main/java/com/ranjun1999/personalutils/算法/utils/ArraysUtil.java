package com.ranjun1999.personalutils.算法.utils;

/**
 * @Author: ranjun
 * @Date: 2020/9/10 10:38
 */
public class ArraysUtil {

    // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        return arr;
    }
    // 打印arr数组的所有内容
    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
        return;
    }

    /**
     *由于浮点数的误差问题，不能直接判断两个浮点数是否相等
     * @param num1
     * @param num2
     * @return
     */
    public static boolean equal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
            return true;
        return false;
    }
}
