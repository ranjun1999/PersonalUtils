package com.ranjun1999.personalutils.算法.剑指Offer;

import com.ranjun1999.personalutils.算法.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * 给定一颗二叉树和其中的一个节点。如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 * @Author: ranjun
 * @Date: 2020/7/31 11:18
 */
public class 二叉树的下一个节点_8 {

    /**
     * 这里有三种情况：
     * 1. 如果一个节点有右子树，那么它的下一个节点就是它的右子树中的最左子节点
     * 2. 如果一个节点没有右子树，但节点时它父亲节点的左子节点，那么它下一个节点就是它的父亲节点
     * 3. 如果节点既没有右子树，也不是它父节点的左子节点，那么可以沿着父亲节点的指针一直向上遍历，直到找到一个是它父亲节点的左子节点的节点
     *    ，那么这个节点的父亲节点就是要找的下一个节点
     * @param node
     * @return
     */
    public static BinaryTreeNode getInOrderNextNode(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode next = null;
        //如果有右子树
        if (node.getRight() != null) {
            BinaryTreeNode pRight = node.getRight();
            while (pRight.getLeft() != null)
                pRight = pRight.getLeft();
            next = pRight;
        }
        else if (node.getParent() != null) {
          BinaryTreeNode pCurrent = node;
          BinaryTreeNode pParent = node.getParent();
          //向上遍历，直到找到一个节点是它父亲节点的左子节点
            while (pParent != null && pCurrent == pParent.getRight()) {
                pCurrent = pParent;
                pParent = pParent.getParent();
            }
            next = pParent;
        }
        return next;
    }

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
        binaryTreeNode.setLeft(new BinaryTreeNode(2,binaryTreeNode));
        binaryTreeNode.setRight(new BinaryTreeNode(3,binaryTreeNode));
        System.out.println(getInOrderNextNode(binaryTreeNode).getVal());
        Stack<Integer> stack = new Stack<>();
    }
}
