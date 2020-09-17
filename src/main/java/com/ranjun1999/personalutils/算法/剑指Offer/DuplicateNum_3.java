package com.ranjun1999.personalutils.算法.剑指Offer;

import javax.validation.constraints.NotNull;
import java.util.HashSet;

/**
 * 在一个长度为n的数组中，所有数字的长度都在0~n-1的范围内。数组中某些数字重复了，但不知道有几个数组重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * @Author: ranju
 * @Date: 2020/7/30 14:00
 */
public class DuplicateNum_3 {


    public static int duplicateNum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public static int duplicateNum2(int nums[]) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 || nums[i] > n - 1) {
                return -1;
            }
        }
        for (int i = 0; i < n; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    /**
     * 不移动数组元素查找重复元素,使用二分查找
     * 把 1 ~ n 的数字从中间的 m 分为两个部分，前面一半为 1 ~ m，后面一半为 m+1 ~ n。
     * 如果 1 ~ m的数字数目超过 m,那么这一半区里面一定有重复数字；否则另一半区 m + 1 ~ n 的区间里一定包含重复数字
     * @param nums
     * @return
     */
    public static int duplicateNum3(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int n = nums.length;
        int start = 1, end = n -  1;
        while (end >= start) {
            int middle = start + (end - start) >> 1;
            int count = countRange(nums,start,middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                }else break;
            }

            if (count > (middle - start + 1)) {
                end = middle;
            }else start = middle + 1;
        }
        return -1;
    }

    private static int countRange(int[] nums, int start, int end) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                ++ count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,0,4,5,3};
        System.out.println(duplicateNum2(nums));
    }
}
