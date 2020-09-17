package com.ranjun1999.personalutils.算法.剑指Offer;

import com.ranjun1999.personalutils.算法.utils.ArraysUtil;

/**
 * 调整数组顺序使奇数位于偶数的前面
 * @Author: ranjun
 * @Date: 2020/9/14 13:43
 */
public class ReorderOddEvent_21 {

    /**
     * 输入一个数组，实现一个函数来调整该数组中的数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * @param arr
     */
    public static void reorderOddEvent(Integer[] arr) {
        if (arr == null || arr.length <= 0)
            return;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            //向后移动left，直到他指向偶数
            while (left < right && (arr[left] & 0x1) != 0)
                left ++;
            //向前移动right，直到它指向偶数
            while (left < right && (arr[right] & 0x1) ==0)
                right --;

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArraysUtil.generateRandomArray(10,0,9);
        ArraysUtil.printArray(arr);
        reorderOddEvent(arr);
        ArraysUtil.printArray(arr);
    }
}
