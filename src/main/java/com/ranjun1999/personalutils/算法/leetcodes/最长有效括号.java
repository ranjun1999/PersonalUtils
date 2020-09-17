package com.ranjun1999.personalutils.算法.leetcodes;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * @Author: ranjun
 * @Date: 2019/12/11 19:41
 */
public class 最长有效括号 {

    /**
     * 1. 暴力法，遍历所有子串
     * 超时 时间复杂度O(n^2)
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {

        int n = s.length();
        if (s == null || n < 2) {
            return 0;
        }

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = (i+2); j <= n; j+=2) {
                String sub = s.substring(i,j);
//                System.out.println(sub);
                if (valid(sub)) {
                    maxLength = Math.max(maxLength, sub.length());
                }
            }
        }

        return maxLength;
    }

    private static boolean valid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }else if (!stack.isEmpty() && stack.peek() == '(')
                stack.pop();
            else return false;
        }

        return stack.empty();
    }

    /**
     * 2.动态规划 时间复杂度O(n)
     *
     * 我们定义一个 dp 数组，其中第 i 个元素表示以下标为 i 的字符结尾的最长有效子字符串的长度。我们将 dp 数组全部初始化为 0 。
     * 现在，很明显有效的子字符串一定以 ‘)’ 结尾。这进一步可以得出结论：以 ‘(’ 结尾的子字符串对应的 dp 数组位置上的值必定为 0 。
     * 所以说我们只需要更新 ‘)’ 在 dp 数组中对应位置的值。
     *
     * 为了求出 dp 数组，我们每两个字符检查一次，如果满足如下条件:
     *1. s[i]=‘)’ 且 s[i−1]=‘(’ ，也就是字符串形如"……()"，我们可以推出：dp[i]=dp[i−2]+2
     *我们可以进行这样的转移，是因为结束部分的 "()" 是一个有效子字符串，并且将之前有效子字符串的长度增加了 2 。
     *
     *2. s[i]=‘)’ 且 s[i−1]=‘)’，也就是字符串形如 .......))" ，我们可以推出：
     * 如果 s[i−dp[i−1]−1]=‘(’ ，那么
     * dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
     *
     * 这背后的原因是如果倒数第二个 ‘)’ 是一个有效子字符串的一部分（记为 sub_s），对于最后一个‘)’ ，如果它是一个更长子字符串的一部分，
     * 那么它一定有一个对应的 ‘(’ ，它的位置在倒数第二个 ‘)’ 所在的有效子字符串的前面（也就是 sub_s的前面）。因此，如果子字符串 sub_s‘(’ ，
     * 那么我们就用 2 加上 sub_s的长度dp[i−1]）去更新 dp[i]。除此以外，我们也会把有效子字符串 "(,sub_s,)"之前的有效子字符串的长度也加上，
     * 也就是加上 dp[i−dp[i−1]−2] 。
     *
     *
     * @param s
     * @return
     */
    public int longestValidParentheses_2(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    /**
     * 3. 使用栈   时间复杂度O(n)
     *
     * 我们可以用栈在遍历给定字符串的过程中去判断到目前为止扫描的子字符串的有效性，同时能的都最长有效字符串的长度。我们首先将 −1 放入栈顶。
     *
     * 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中。
     * 对于遇到的每个 ‘)’ ，我们弹出栈顶的元素并将当前元素的下标与现在的栈顶元素下标作差，得出当前有效括号字符串的长度。
     * 通过这种方法，我们继续计算有效子字符串的长度，并最终返回最长有效子字符串的长度。
     *
     *
     * @param s
     * @return
     */
    public int longestValidParentheses_3(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    /**
     * 4. 不需要额外空间 时间复杂度O(n)
     *
     * 在这种方法中，我们利用两个计数器 left 和 right 。
     * 首先，我们从左到右遍历字符串，对于遇到的每个 ‘(’，我们增加 left 计算器，对于遇到的每个 ‘)’ ，我们增加 right 计数器。
     * 每当 left 计数器与 right 计数器相等时，我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串。
     * 如果 right 计数器比 left 计数器大时，我们将 left 和 right 计数器同时变回 00 。
     *
     * 接下来，我们从右到左做一遍类似的工作。
     *
     * @param s
     * @return
     */
    public int longestValidParentheses_4(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;

    }

    public static void main(String[] args) {
//        System.out.println(longestValidParentheses_2("()()"));
    }
}
