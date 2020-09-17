package com.ranjun1999.personalutils.算法.leetcodes;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * @Author: ranjun
 * @Date: 2019/12/15 13:44
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {

    /**
     * 1. 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int n = nums.length;
        if (n < 1) {
            return res;
        }
        int left = 0, right = n -1;

        int locat = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                locat = mid;
                break;
            }
        }

        if (locat == -1) {
            return res;
        }
        left = locat;
        right = locat;
        while (left-1 > -1) {
            if (nums[left - 1] == target) {
                left--;
            }else break;
        }
        while (right + 1 < n) {
            if (nums[right + 1] == target) {
                right++;
            }else break;
        }
        res[0] = left;
        res[1] = right;
        return res;
    }


    /**
     * 2. 二分法
     * 首先，为了找到最左边包含 target 的下标（而不是找到的话就返回 true ），
     * 所以算法在我们找到一个 target 后不能马上停止。我们需要继续搜索，直到 lo == hi 且它们在某个 target 值处下标相同。
     *
     * 另一个改变是 left 参数的引入，它是一个 boolean 类型的变量，指示我们在遇到 target == nums[mid] 时应该做什么。
     * 如果 left 为 true ，那么我们递归查询左区间，否则递归右区间。
     * 考虑如果我们在下标为 i 处遇到了 target ，最左边的 target 一定不会出现在下标大于 i 的位置，所以我们永远不需要考虑右子区间
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange_2(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }



}
