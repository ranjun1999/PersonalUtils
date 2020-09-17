package com.ranjun1999.personalutils.算法.leetcodes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * @Author: ranjun
 * @Date: 2019/11/28 21:50
 */
public class 四数之和 {

    /**
     * 排序加双指针
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums==null||nums.length<4){
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            //排序后最小的四数之和仍比target，直接返回
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;

            //排序后nums[i]与最大的三数之和仍小于target,需要将i向右移动
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;

            for (int j = i + 1; j < n - 2; j++) {

                if (j - i > 1 && nums[j] == nums[j - 1]) continue;

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;

                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int tmp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (tmp == target) {
                        List<Integer> tmpList = new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        res.add(tmpList);
                        while (left < right && nums[left] == nums[left + 1]) left += 1;
                        while (left < right && nums[right] == nums[right - 1]) right -= 1;
                        left += 1;
                        right -= 1;
                    } else if (tmp > target)
                        right -= 1;
                    else
                        //temp < target
                        left += 1;
                }
            }

        }

        return res;
    }
}
