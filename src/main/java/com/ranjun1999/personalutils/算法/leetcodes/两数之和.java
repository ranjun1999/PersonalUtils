package com.ranjun1999.personalutils.算法.leetcodes;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * @Author: ranjun
 * @Date: 2019/11/23 15:33
 */
public class 两数之和 {



    /**
     * 1. 暴力法
     * 遍历每个元素 x，并查找是否存在一个值与 target - x 相等的目标元素。
     * 时间复杂度：O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length <= 0 || nums == null) {
            return null;
        }
        int[] result = new int[2];

        int x = 0, y = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }


    /**
     * 2. 一遍哈希表
     * 以空间换时间，Hash表的索引速度为O(1),使用一个Map集合保存遍历过的数组值与索引
     * 遍历数组过程中，判断是否有相加为target的元素。若没有则添加进Map集合当中，若有，则返回索引。
     * 时间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        if (nums.length <= 0 || nums == null) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int targetValue = target - nums[i];
            if (map.containsKey(targetValue)) {
                return new int[]{map.get(targetValue), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no such two nums");
    }
}
