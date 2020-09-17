package com.ranjun1999.personalutils.算法.nowcoder.sort;

import java.util.Random;

/**
 * @Author: ranjun
 * @Date: 2020/3/20 16:35
 *
 * 假设我们对数组{7, 1, 3, 5, 13, 9, 3, 6, 11}进行快速排序。
 * 首先在这个序列中找一个数作为基准数，为了方便可以取第一个数。
 * 1. 遍历数组，将小于基准数的放置于基准数左边，大于基准数的放置于基准数右边。
 * 2. 此时得到类似于这种排序的数组{3, 1, 3, 5, 6, 7, 9, 13, 11}。
 * 3. 在初始状态下7是第一个位置，现在需要把7挪到中间的某个位置k，也即 k位置是两边数的分界点。
 * 4. 那如何做到把小于和大于基准数7的值分别放置于两边呢，我们采用双指针法，从数组的两端分别进行比对。
 * 5. 先从最右位置往左开始找直到找到一个小于基准数的值，记录下该值的位置（记作 j）。
 * 6. 再从最左位置往右找直到找到一个大于基准数的值，记录下该值的位置（记作 i）。
 * 7. 如果位置i<j，则交换i和j两个位置上的值，然后继续从(j-1)的位置往前和(i+1)的位置往后重复上面比对基准数然后交换的步骤。
 * 8. 如果执行到i==j，表示本次比对已经结束，将最后i的位置的值与基准数做交换，此时基准数就找到了临界点的位置k，位置k两边的数组都比当前位置k上的基准值或都更小或都更大。
 * 9. 上一次的基准值7已经把数组分为了两半，基准值7算是已归位（找到排序后的位置）。
 * 10. 通过相同的排序思想，分别对7两边的数组进行快速排序，左边对[left, k-1]子数组排序，右边则是[k+1, right]子数组排序。
 * 11. 利用递归算法，对分治后的子数组进行排序
 */
public class 快速排序 {
    /**
     * 快速排序，使得整数数组 arr 有序
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序，使得整数数组 arr 的 [L, R] 部分有序
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start == end)
            return;
        //index右边的数小于基准值，左边的数大于基准值
        int index = partition(arr,start,end);
        if (index > start)
            //快排右边数组的索引
            quickSort(arr,start,index - 1);
        if (index < end)
            //快排左边数组的索引
            quickSort(arr,index + 1,end);
    }

    /**
     * 分区的过程，整数数组 arr 的[L, R]部分上，使得：
     *   大于 arr[R] 的元素位于[L, R]部分的右边，但这部分数据不一定有序
     *   小于 arr[R] 的元素位于[L, R]部分的左边，但这部分数据不一定有序
     *   等于 arr[R] 的元素位于[L, R]部分的中间
     * 返回等于部分的第一个元素的下标和最后一个下标组成的整数数组
     */
    public static int partition(int[] arr, int start, int end) {
        // 把数组中随机的一个元素与最后一个元素交换，这样以最后一个元素作为基准值实际上就是以数组中随机的一个元素作为基准值
        int index = new Random().nextInt(end - start + 1) + start;
        swap(arr,index,end);
        //让small最后指向右边小于基准值的最后一个值的索引，
        int small = start - 1;
        for (int i = start;i < end; ++ i) {
            if (arr[i] < arr[end]) {
                ++ small;
                if (small != i)
                    //将小于基准值的数交换到右边
                    swap(arr,small,i);
            }
        }
        //让small指向基准值
        small++;
        swap(arr,small,end);
        return small;
    }

    public static void sort2(int arr[], int low, int high) {
        if (arr == null || arr.length <= 0)
            return;
        if (low >= high)
            return;

        int left = low;
        int right = high;
        int key = arr[left];

        while (left < right){
            while (left < right && arr[right] >= key) {
                right--;
            }
            while (left < right && arr[left] <= key)
                left++;
            if (left < right)
                swap(arr,left,right);
        }
        swap(arr,left,low);
        sort2(arr,low,left - 1);
        sort2(arr,left + 1,high);
    }

    /*
     * 交换数组 arr 中下标为 i 和下标为 j 位置的元素
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,1,3,6,8,9,3,10};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
