package com.ranjun1999.personalutils.算法.剑指Offer;

import com.ranjun1999.personalutils.算法.utils.BinaryTreeNode;

/**
 * 对称二叉树
 * @Author: ranjun
 * @Date: 2020/9/14 17:18
 */
public class IsSymmetrical_28 {

    /**
     * 判断一棵儿二叉树是不是对称的。如果一棵二叉树的和他的镜像一样，那么他就是对称的。
     *
     * 可以通过比较前序遍历，与前序遍历的对称遍历是否相同来判断二叉树是否为对称二叉树
     * 前序遍历是先遍历左子节点，再遍历右子节点
     * 前序遍历的对称遍历即先遍历右子节点，在遍历左子节点
     * @param node
     * @return
     */
    public static boolean isSymmetrical(BinaryTreeNode node) {
        return false;
    }

    /**
     * root1前序遍历根节点，root2前序遍历的对称遍历根节点
     * @param root1
     * @param root2
     * @return
     */
    private static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null)
            return false;
        if (root1.getVal() != root2.getVal())
            return false;
        return isSymmetrical(root1.getLeft(),root2.getRight()) && isSymmetrical(root1.getRight(),root2.getLeft());
    }

}
