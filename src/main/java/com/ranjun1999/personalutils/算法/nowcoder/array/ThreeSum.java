package com.ranjun1999.personalutils.算法.nowcoder.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: ranjun
 * @Date: 2020/9/4 17:03
 */
public class ThreeSum {


    /**
     * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
     * 注意：
     * 1. 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
     * 2. 解集中不能包含重复的三元组。
     * @param num
     * @return
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (num == null) {
            return result;
        }
        //排序
        Arrays.sort(num);
        int sum, left, right;
        for (int i = 0; i < num.length - 2; i++) {
            //避免重复, 比如前面计算了以-1开头,后面就不用计算了
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            left = i + 1;
            right = num.length - 1;
            /**
             * 固定一个数num[i],从后面的数中选出两个数,因为数组是有序的,所以可以
             * 用两个数组下标left和right,left指向当前元素的后一个位置,right指向最后一个位置
             * 三个数相加的和等于0时,加入解集;
             * 小于0时,把left往右边移动;
             * 大于0时,把right往左边移动;
             */
            while (left < right) {
                sum = num[left] + num[right];
                if (sum + num[i] == 0) {
                    ArrayList<Integer> solution = new ArrayList<>();
                    solution.add(num[i]);
                    solution.add(num[left]);
                    solution.add(num[right]);
                    result.add(solution);
                    left++;
                    right--;
                    while (left < right && num[left] == num[left - 1]) {
                        left++;
                    }
                    while (left < right && num[right] == num[right + 1]) {
                        right--;
                    }
                } else if (sum + num[i] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(a));
    }
}
