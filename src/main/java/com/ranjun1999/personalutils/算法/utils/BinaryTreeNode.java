package com.ranjun1999.personalutils.算法.utils;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: ranjun
 * @Date: 2020/7/31 10:02
 */
@Data
public class BinaryTreeNode {

    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode parent;

    public BinaryTreeNode() {

    }
    public BinaryTreeNode(int val) {
        this.val = val;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this(val);
        this.left = left;
        this.right = right;
    }
    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right,BinaryTreeNode parent) {
        this(val,left, right);
        this.parent = parent;
    }

    public BinaryTreeNode(int val, BinaryTreeNode parent) {
        this(val);
        this.parent = parent;
    }

    /**
     * 层次遍历数
     * @param treeNode
     */
    public static void printTree(BinaryTreeNode treeNode) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (treeNode != null) {
            queue.offer(treeNode);
        }
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
            System.out.print(node.getVal() + "->");
        }
        System.out.println();
    }

    public static void preOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getVal() + " ->");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void InOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        InOrder(node.left);
        System.out.print(node.getVal() + " ->");
        InOrder(node.right);
    }
    public static void AfterOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        AfterOrder(node.left);
        AfterOrder(node.right);
        System.out.print(node.getVal() + " ->");
    }


    /**
     * 构造一棵二叉树
     *
     * @param
     * @return
     */
    public static BinaryTreeNode generateTreeNode(int floor) {
        int maxVal = (int) (Math.pow(2,floor) - 1);
        return generateTreeNode(1,maxVal);
    }
    public static BinaryTreeNode generateTreeNode(int val,int maxVal) {
        if (val > maxVal)
            return null;
        BinaryTreeNode node1 = new BinaryTreeNode(val);
        node1.setLeft(generateTreeNode(2*val,maxVal));
        node1.setRight(generateTreeNode(2*val + 1,maxVal));
        return node1;
    }
    public static void main(String[] args) {
        BinaryTreeNode node = generateTreeNode(3);
        printTree(node);
    }

}