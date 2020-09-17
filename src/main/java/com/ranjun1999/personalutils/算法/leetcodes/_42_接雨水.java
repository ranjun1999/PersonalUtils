package com.ranjun1999.personalutils.算法.leetcodes;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @Author: ranjun
 * @Date: 2019/12/18 19:48
 */
public class _42_接雨水 {

    /**
     * 1.暴力法 时间复杂度O(n^2)
     * 对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 1) {
            return 0;
        }
        int v = 0;
        for (int i = 0; i < n -1 ; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft,height[j]);
            }
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight,height[j]);
            }
            v += Math.min(maxLeft,maxRight) - height[i];
        }
        return v;
    }

    /**
     * 2. 动态规划  时间复杂度O(n)
     * 首先用两个数组，max_left [i] 代表第 i 列左边最高的墙的高度，max_right[i] 代表第 i 列右边最高的墙的高度。
     *对于maxLeft:
     * max_left [i] = Max(max_left [i-1],height[i-1])。它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。
     *
     * @param height
     * @return
     */
    public int trap_2(int[] height) {
        int n = height.length;
        if (n <= 1) {
            return 0;
        }
        int v = 0;

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for (int i = 1; i < n - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1],height[i-1]);
        }

        for (int i = n -2 ; i >= 0; i--) {
            maxRight[i] = Math.max(maxLeft[i+1],height[i+1]);
        }

        for (int i = 0; i < n - 1; i++) {
            int min = Math.min(maxLeft[i],maxRight[i]);

            if (min > height[i]) {
               v += min - height[i];
            }
        }
        return v;
    }

    /**
     * 3.使用栈
     *
     * 我们用栈保存每堵墙。
     *
     * 当遍历墙的高度的时候，如果当前高度小于栈顶的墙高度，说明这里会有积水，我们将墙的高度的下标入栈。
     *
     * 如果当前高度大于栈顶的墙的高度，说明之前的积水到这里停下，我们可以计算下有多少积水了。计算完，就把当前的墙继续入栈，作为新的积水的墙。
     *
     * 总体的原则就是，
     *
     * 当前高度小于等于栈顶高度，入栈，指针后移。
     *
     * 当前高度大于栈顶高度，出栈，计算出当前墙和栈顶的墙之间水的多少，然后计算当前的高度和新栈的高度的关系，重复第 2 步。
     * 直到当前墙的高度不大于栈顶高度或者栈空，然后把当前墙入栈，指针后移
     *
     * @param height
     * @return
     */
    public int trap_3(int[] height) {
        int v = 0;
        int n = height.length;
        if (n <= 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < n) {
            //如果栈不为空且当前指向的高度大于栈顶高度
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                //两堵墙之间的距离
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                v += distance*(min - h);
            }
            stack.push(height[current]);    //当前指向的墙入栈
            current++;  //指针后移
        }
        return v;
    }

    public static void main(String[] args) {
        int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(trap(h));
    }
}
