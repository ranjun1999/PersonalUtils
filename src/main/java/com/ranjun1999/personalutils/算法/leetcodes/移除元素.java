package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @Author: ranjun
 * @Date: 2019/12/6 21:15
 */
public class 移除元素 {


    /**
     * 双指针法
     *
     * 当 nums[j] 与给定的值相等时，递增 j 以跳过该元素。只要 nums[j] != val，我们就复制 nums[j] 到 nums[i] 并同时递增两个索引。
     * 重复这一过程，直到 j 到达数组的末尾，该数组的新长度为 i。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
