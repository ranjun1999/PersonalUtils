package com.ranjun1999.personalutils.算法.剑指Offer;

import com.ranjun1999.personalutils.算法.utils.BinaryTreeNode;

/**
 * 二叉树的镜像
 * @Author: ranjun
 * @Date: 2020/9/14 16:36
 */
public class MirrorRecursively_27 {

    /**
     * 输入一个二叉树，将二叉树重构为它的镜像二叉树
     * @param node
     */
    public static void mirrorRecursively(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        //左右子节点为空结束递归
        if (node.getLeft() == null && node.getRight() == null)
            return;
        BinaryTreeNode temp = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(temp);
        if (node.getLeft() != null)
            mirrorRecursively(node.getLeft());
        if (node.getRight() != null)
            mirrorRecursively(node.getRight());
    }

    public static void main(String[] args) {
        BinaryTreeNode node = BinaryTreeNode.generateTreeNode(3);
        BinaryTreeNode.printTree(node);
        mirrorRecursively(node);
        BinaryTreeNode.printTree(node);
    }
}
