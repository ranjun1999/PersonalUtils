package com.ranjun1999.personalutils.算法.leetcodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * @Author: ranjun
 * @Date: 2019/11/28 20:46
 */
public class 电话号码的字母组合 {

    private static HashMap<String, String> phone = new HashMap<>();

    static {
        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");
    }

    private static List<String> output = new ArrayList<>();

    /**
     * 回溯算法
     * 回溯是一种通过穷举所有可能情况来找到所有解的算法。
     * 如果一个候选解最后被发现并不是可行解，回溯算法会舍弃它，并在前面的一些步骤做出一些修改，并重新尝试找到可行解。
     *
     * @param combination   每条回溯路径的组合
     * @param next_digits   每个字母对应的后继回溯字符
     */
    public static void backtrack(String combination, String next_digits) {
        //回溯完输入字符串，回溯结束，将当前回溯结果加入结果集中
        if (next_digits.length() == 0) {
            output.add(combination);
        }
        //输入字符还未回溯完成，继续当前字符的回溯过程
        else {
            //取得当期回溯的字符
            String digit = next_digits.substring(0, 1);
            //获取该字符对应的字符集
            String letters = phone.get(digit);
            //回溯字符集中的每一个字符
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);

                //将当前字母加入到组合最后，然后遍历下一个数字对应的所有映射的字母
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }





    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
