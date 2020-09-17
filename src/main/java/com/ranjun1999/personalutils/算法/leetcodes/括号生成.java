package com.ranjun1999.personalutils.算法.leetcodes;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * @Author: ranjun
 * @Date: 2019/11/29 20:47
 */
public class 括号生成 {

    /**
     * 1. 暴力法   时间复杂度：O(2^2n * n）,对于2^2n个序列中的每一个，我们用于建立和验证该序列的复杂度为 O(n)。
     *
     * 为了生成所有序列，可以使用递归。长度为 n 的序列就是 '(' 加上所有长度为 n-1 的序列，以及 ')' 加上所有长度为 n-1 的序列。
     *
     * 为了检查序列是否为有效的，我们会跟踪 平衡，也就是左括号的数量减去右括号的数量的净值。如果这个值始终小于零或者不以零结束，该序列就是无效的，否则它是有效的。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }


    /**
     * 2. 回溯法
     * 只有在我们知道序列任然保持有效时才添加'('或')'。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
     * 如果我们还剩一个位置，我们可以开始放一个左括号。 如果它不超过左括号的数量，我们可以放一个右括号。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis_2(int n) {
        List<String> ans = new ArrayList<>();

        backtrack(ans,"",0,0,n);
        return ans;
    }

    /**
     * 回溯，每次回溯过程我们会保证序列有效添加
     * 即序列中左括号数不超过括号对数，我们可以放一个左括号，
     * @param ans
     * @param cur
     * @param open
     * @param close
     * @param max
     */
    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }


}
