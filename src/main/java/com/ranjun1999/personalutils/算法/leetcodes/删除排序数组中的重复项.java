package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * @Author: ranjun
 * @Date: 2019/12/6 20:21
 */
public class 删除排序数组中的重复项 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[j])
                nums[++j] = nums[i];
        }
        return j+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
//        System.out.println(nums.length);
        System.out.println(removeDuplicates(nums));
//        System.out.println(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
