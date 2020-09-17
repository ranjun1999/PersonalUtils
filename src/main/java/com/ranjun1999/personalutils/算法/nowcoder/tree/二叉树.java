package com.ranjun1999.personalutils.算法.nowcoder.tree;

import java.util.Scanner;

/**
 * 由正整数1，2，3……组成了一颗完全二叉树。
 * 我们已知这个二叉树的最后一个结点是n。现在的问题是，结点m所在的子树中一共包括多少个结点。
 * 比如，n = 12，m = 3那么上图中的结点13，14，15以及后面的结点都是不存在的，结点m所在子树中包括的结点有3，6，7，12，因此结点m的所在子树中共有4个结点。
 * @Author: ranjun
 * @Date: 2020/8/4 11:12
 */
public class 二叉树 {
    /**
     * m <= n
     * @param m
     * @param n
     * @return
     */
    public static int countCode(int m, int n) {
        if (m == n && m == 0) {
            return 0;
        }
        if (m > n)
            return 0;
        //左子树节点数 + 右子树节点数 + 本节点
        return countCode(2*m,n) + countCode(2*m + 1,n) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,m;
        while (scanner.hasNext()) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            System.out.println(countCode(m,n));
        }

    }
}
