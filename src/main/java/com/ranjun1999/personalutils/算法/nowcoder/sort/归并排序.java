package com.ranjun1999.personalutils.算法.nowcoder.sort;

import java.util.Arrays;

/**
 * @Author: ranjun
 * @Date: 2020/3/24 19:06
 * 归并操作(merge)，也叫归并算法，指的是将两个顺序序列合并成一个顺序序列的方法。
 *
 * 如　设有数列{6，202，100，301，38，8，1}
 *
 * 初始状态：6,202,100,301,38,8,1
 *
 * 第一次归并后：{6,202},{100,301},{8,38},{1}，比较次数：3；
 *
 * 第二次归并后：{6,100,202,301}，{1,8,38}，比较次数：4；
 *
 * 第三次归并后：{1,6,8,38,100,202,301},比较次数：4；
 *
 * 总的比较次数为：3+4+4=11；
 *
 * 逆序数为14
 *
 *归并操作的工作原理如下：
 * 第一步：申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 第二步：设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 第三步：比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 重复步骤3直到某一指针超出序列尾
 * 将另一序列剩下的所有元素直接复制到合并序列尾
 */
public class 归并排序 {
    //将arr[l...mid] 和arr[mid+1....r] 两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        //初始化，i指向左半部分的起始；j指向右半部分其实索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            //
            if (i > mid) {
                //左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                //右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                //左半部分所指元素<右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    /**
     * 归并划分数组，并依次进行排序
     * @param arr
     * @param left
     * @param right
     */
    private static void sort(Comparable[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left)/2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid,right);
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

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
    public static void main(String[] args) {
        Integer[] arr = generateRandomArray(10,0,10);
        printArray(arr);
        Comparable<Integer>[] aux = Arrays.copyOfRange(arr,7,9);
        printArray(aux);
//        sort(arr);
//        printArray(arr);
    }
}
