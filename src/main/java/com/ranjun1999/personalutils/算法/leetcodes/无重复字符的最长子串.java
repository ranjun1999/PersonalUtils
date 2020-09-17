package com.ranjun1999.personalutils.算法.leetcodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author: ranjun
 * @Date: 2019/11/23 16:53
 */
public class 无重复字符的最长子串 {


    /**
     * 1. 暴力法，逐个检查所有的子字符串，看它是不是含有重复字符串
     * 时间复杂度 O(n^3)
     * @param s
     * @return
     */
    public int lengthOfSubString(String s) {
        int n = s.length();
        int ans = 0;

        //遍历字符串的所有子串
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i,j))
                    ans = Math.max(ans, j - i);
         return ans;
    }

    /**
     * 检查子串是否有重复字符
     * @param s
     * @param start
     * @param end
     * @return
     */
    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }

    /**
     * 2. 滑动窗口法
     * 滑动窗口是数组/字符串问题中常用的抽象概念。
     * 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i,j)（左闭，右开）。
     * 而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i,j) 向右滑动 11 个元素，则它将变为 [i+1,j+1)（左闭，右开）。
     *
     * 通过HashSet作为滑动窗口，我们可以用O(1)的时间完成对字符是否在当前字符串中的检查
     *
     * 该问题中，HashSet将字符串存储在当前窗口[i，j）(开始i = j)中，
     * 然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j，直到 s[j] 已经存在于 HashSet 中。
     * 此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头。
     *
     *若s[j]已经在滑动窗口中，则向右滑动索引i，得到一个新的以索引i++开头的子字符串。
     * 然后再继续重复上面操作。
     *
     * 时间复杂度 O(n)，在最糟糕的情况下，每个字符将被 i 和 j 访问两次
     *
     *
     * @param s
     * @return
     */
    public int lengthOfSubString2(String s) {
        int n = s.length();
        int i = 0, j = 0, ans = 0;

        //滑动窗口，保存子字符串
        Set<Character> set = new HashSet<>();

        while (i < n && j < n){
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans,j - i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 3. 优化的滑动窗口
     *
     * 上述的方法最多需要执行 2n 个步骤。事实上，它可以被进一步优化为仅需要 n 个步骤。
     * 我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
     * 也就是说，如果 s[j]在[i,j) 范围内有与 j'重复的字符，我们不需要逐渐增加 i 。 我们可以直接跳过 [i，j'] 范围内的所有元素，并将 i 变为 j' + 1。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;

        //使用Map集合添加字符与索引的映射
        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0, i = 0; j < n; j++) {
            //当集合中存在s[j],索引为j',将窗口范围变为[j'+1,j]
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            //向右滑动索引j，并添加进集合中
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
