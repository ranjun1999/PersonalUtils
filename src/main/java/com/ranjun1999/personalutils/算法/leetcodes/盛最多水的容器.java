package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * @Author: ranjun
 * @Date: 2019/11/26 20:20
 */
public class 盛最多水的容器 {


    /**
     * 1. 暴力法   时间复杂度O(n^2)
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        int maxArea = 0;

        int n = height.length;
        int area = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                maxArea = Math.max(maxArea,Math.max(maxArea,(j - i) * Math.min(height[i], height[j])));
            }
        }
        return maxArea;
    }

    /**
     * 2. 双指针法  时间复杂度O(n)
     * 这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。
     *
     * @param height
     * @return
     */
    public static int maxArea_2(int[] height){
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            }else j--;
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] area = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea_2(area));
    }
}
