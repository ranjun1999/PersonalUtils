package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * @Author: ranjun
 * @Date: 2019/12/21 15:28
 */
public class _45_跳跃游戏 {

     int minCount;
     int[]  nums;
    public int jump(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        minCount = n -1;
//        System.out.println(minCount);
        jump(0,0);
        return minCount;
    }

    private  void jump(int start, int count) {
        if (start >= nums.length - 1) {
//            System.out.println(start + "," + count);
            minCount = Math.min(minCount,count);
            return ;
        }
        for (int i = 1; i <= nums[start]; i++) {
            if ((start + i) < nums.length - 1 && nums[start + i] == 0) {
                continue;
            }
            jump(start + i,count + 1);
        }

    }

    /**
     * 贪心算法
     * 时间复杂度O(n)
     * @param nums
     * @return
     */
    public int jump_2(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;

    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new _45_跳跃游戏().jump_2(nums));
    }

}
