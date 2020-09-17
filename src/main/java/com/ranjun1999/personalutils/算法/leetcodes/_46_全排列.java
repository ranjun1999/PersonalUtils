package com.ranjun1999.personalutils.算法.leetcodes;

import java.util.*;

/**
 *给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * @Author: ranjun
 * @Date: 2019/12/21 16:43
 */
public class _46_全排列 {


//    int[] nums;
//    int n;

    public void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }


    /**
     * 2. 全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute_2(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0)
            return res;

        //保存数组序列的使用状态
        boolean[] used = new boolean[len];
        generatePermution(nums,used,0,len,new Stack<>(),res);
        return res;
    }

    /**
     *
     * @param nums
     * @param visited
     * @param curSize
     * @param len
     * @param path
     * @param res
     */
    private void generatePermution(int[] nums, boolean[] visited, int curSize,
                                   int len, Stack<Integer> path, List<List<Integer>> res) {
        //递归结束条件
        if (curSize == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            //下次排序选取未选过元素
            if (!visited[i]) {
                path.push(nums[i]);
                visited[i] = true;
                generatePermution(nums,visited,curSize + 1,len,path,res);
                //状态重置
                path.pop();
                visited[i] = false;
            }
        }
    }


}
