package com.ranjun1999.personalutils.算法.leetcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 答案中不可以包含重复的三元组。
 *
 * @Author: ranjun
 * @Date: 2019/11/27 21:35
 */
public class 三数之和 {

    /**
     * 1. 暴力法   O(n^3)时间超出限制
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        if (n < 3) {
            return result;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int twoSum = nums[i] + nums[j];

                for (int k = j + 1; k < n; k++) {
                    if (twoSum + nums[k] == 0) {
                        if (!result.contains(Arrays.asList(nums[i], nums[j],nums[k])) )
                            result.add(Arrays.asList(nums[i], nums[j],nums[k]));
                    }
                }
            }
        }

        return result;
    }

    /**
     * 2. 排序加双指针    时间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum_2(int[] nums) {
        //将数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        if (n < 3) {
            return result;
        }

        /**
         * 令左指针 L=i+1，右指针R=n−1，当 L<R  时，执行循环：
         * 当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
         * 若和大于 0，说明 nums[R]太大，RR 左移
         * 若和小于 0，说明 nums[L]太小，LL 右移
         *

          */
        int L, R;
        for (int i = 0; i < n; i++) {
            //因为数组已经排好序，所以后面不可能有三个数相加等于0
            if (nums[i] > 0) {
                return result;  //直接返回结果
            }
            //去重
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            //左指针
            L = i + 1;
            //右指针
            R = n - 1;

            while (L < R) {
                if (nums[i] + nums[L] + nums[R] == 0) {
                    result.add(Arrays.asList(nums[i], nums[L],nums[R]));

                    //以下都是去重
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    } while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (nums[i] + nums[L] + nums[R] > 0) {   //num[R]值过大
                    R --;
                }else L ++;

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum_2(nums));

    }
}
