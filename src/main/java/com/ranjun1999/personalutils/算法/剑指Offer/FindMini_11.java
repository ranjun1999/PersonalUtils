package com.ranjun1999.personalutils.算法.剑指Offer;

import com.ranjun1999.personalutils.算法.utils.ArraysUtil;

/**
 * @Author: ranjun
 * @Date: 2020/9/10 9:50
 */
public class FindMini_11 {

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转
     * 输入一个递增排序的数组的旋转，输出排序数组的最小值元素
     *
     * eg:{3,4,5,1,2}为{1,2,3,4,5}的一个旋转
     *
     * 旋转后的数组可以划分为两个排序的子数组，前面的元素都大于等于后面子数组的元素，而最小的元素就是这两个子数组的分界线。
     * 所以在排序数组中可以使用二分法实现 O(lgn)的查找
     * @param arr
     * @return
     */
    public static int findMin(int[] arr) {
        if (arr == null || arr.length < 0) {
            return -1;
        }
        //index1指向前面递增的子数组，index2指向后面递增的子数组，
        // 不断查找后，最终他们会指向两个相邻的元素，index2指向后面数组的第一个元素，也就是最小的元素
        int index1 = 0,index2 = arr.length - 1;
        int indexMid = index1;
        //数组中第一个元素就是最小的数字
        while (arr[index1] >= arr[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = index1 + (index2 - index1)/2;

            //如果index1、index2、indexMid指向的元素值相同，则只能顺序查找
            if (arr[index1] == arr[index2] && arr[index1] == arr[indexMid])
                findMinInOrder(arr,index1,index2);
            //中间元素位于前面的子数组，则最小元素在中间元素后面
            if (arr[indexMid] >= arr[index1])
                index1 = indexMid;
            //中间元素位于后面的子数组，则最小元素位于中间元素前面
            else if (arr[indexMid] <= arr[index2])
                index2 = indexMid;
        }
        return arr[indexMid];
    }

    private static int findMinInOrder(int[] arr,int index1, int index2) {
        int result = arr[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (result > arr[i])
                result  = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {7,8,9,2,3,4,5,6};
        System.out.println(findMin(arr));
    }
}
