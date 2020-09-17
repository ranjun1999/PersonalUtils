package com.ranjun1999.personalutils.算法.nowcoder.sort;

/**
 * 冒泡排序
 * @Author: ranjun
 * @Date: 2020/3/20 15:48
 */
public class 冒泡排序 {

    public static void maoPaoSoted(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n -1; i++) {
            for (int j = 1; j < n - i;j++){
                if (arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void maoPaoSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i;j++ ){
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,6,7,2,12,2,3,9,7,5};
        maoPaoSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "， ");
        }
    }
}
