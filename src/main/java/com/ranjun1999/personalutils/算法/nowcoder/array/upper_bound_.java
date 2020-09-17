package com.ranjun1999.personalutils.算法.nowcoder.array;

/**
 * @Author: ranjun
 * @Date: 2020/9/2 10:40
 */
public class upper_bound_ {

    /**
     * 请实现有重复数字的有序数组的二分查找。
     * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_ (int n, int v, int[] a) {
        if (v > a[n - 1]) {
            return n + 1;
        }
        // write code here
        int left = 0, right = n, mid = 0;
        while (left < right){
            mid = left + (right - left)/2;
            if (v < a[mid]) {
                right = mid - 1;
            } else return mid + 1;
        }
//        System.out.println(mid);
        return mid + 1;
    }

    public static void main(String[] args) {
        int[] a = {2,3,3,4,4,5,5,5,6,6,7,7,9,9,9,10,10,12,14,16,17,18,18,18,19,22,23,23,26,26,26,26,28,28,29,29,29,32,33,35,36,38,39,39,40,41,46,47,47,47,49,50,54,55,55,55,56,57,57,58,58,58,59,61,61,62,62,62,62,63,63,67,67,69,70,70,71,72,74,75,76,79,84,85,85,86,89,92,93,93,93,94,94,95,97,97,97,97,97,99};
        System.out.println(upper_bound_(100,100,a));
    }

}
