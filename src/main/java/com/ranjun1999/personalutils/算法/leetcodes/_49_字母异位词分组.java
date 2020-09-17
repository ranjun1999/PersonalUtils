package com.ranjun1999.personalutils.算法.leetcodes;


import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @Author: ranjun
 * @Date: 2019/12/21 21:45
 */
public class _49_字母异位词分组 {

    /**
     * 1. 按字符顺序分类
     *
     * 当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
     * 维护一个映射 ans : {String -> List}，其中每个键 \text{K}K 是一个排序字符串，每个值是初始输入的字符串列表，排序后等于K。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if (strs.length == 0) {
            return res;
        }
        Map<String,List<String>> ans = new HashMap<>();

        for (String str : strs) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key))
                ans.put(key,new ArrayList<>());
            ans.get(key).add(str);
        }

        return new ArrayList<>(ans.values());
    }


}
