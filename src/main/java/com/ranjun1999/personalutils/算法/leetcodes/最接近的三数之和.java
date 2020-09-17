package com.ranjun1999.personalutils.算法.leetcodes;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * @Author: ranjun
 * @Date: 2019/11/28 19:53
 */
public class 最接近的三数之和 {

    /**
     * 排序 + 双指针 时间复杂度O(n^2)
     *指向 start = i + 1 处，后指针指向 end = nums.length - 1 处，也就是结尾处
     * 根据 sum = nums[i] + nums[start] + nums[end] 的结果，判断 sum 与目标 target 的距离，如果更近则更新结果 closest
     * 同时判断 sum 与 target 的大小关系，因为数组有序，如果 sum > target 则 end--，如果 sum < target 则 start++，如果 sum == target 则说明距离为 0 直接返回结果
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int closest = nums[0] + nums[1] + nums[2];  //初始化前三个值与target最接近
        for (int i = 0; i < n; i++) {
          int start = i + 1, end = n -1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                if (sum > target) {
                    end --;
                } else if (sum < target) {
                    start ++;
                }else return closest;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,1,-3};
        System.out.println(threeSumClosest(nums,1));
    }
}
