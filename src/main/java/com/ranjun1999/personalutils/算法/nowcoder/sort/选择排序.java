package com.ranjun1999.personalutils.算法.nowcoder.sort;

/**
 * @Author: ranjun
 * @Date: 2020/3/20 16:13
 */
public class 选择排序 {

    public static void selectSort(int[] arr){
        int n = arr.length;
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }

        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,1,3,6,8,9,3,10};
        selectSort(arr);
    }
}
