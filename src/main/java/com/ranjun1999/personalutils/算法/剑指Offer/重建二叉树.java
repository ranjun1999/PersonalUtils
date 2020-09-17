package com.ranjun1999.personalutils.算法.剑指Offer;

import com.ranjun1999.personalutils.算法.utils.BinaryTreeNode;

/**
 * 输入二叉树的前序遍历与中序遍历的结果，请重建该二叉树；输入不包括重复数字
 * @Author: ranjun
 * @Date: 2020/7/31 10:16
 */
public class 重建二叉树 {
    int[] preOrderNodes;
    int[] inOrderNodes;

    public BinaryTreeNode constructorTree(int[] preOrderNodes, int[] inOrderNodes) {
        if (preOrderNodes == null || inOrderNodes == null || preOrderNodes.length <= 0) {
            return null;
        }
        this.preOrderNodes = preOrderNodes;
        this.inOrderNodes = inOrderNodes;
        return constructorCore(0,preOrderNodes.length -1,
                0, inOrderNodes.length -1);
    }

    /**
     * 前序遍历的第一个节点就是根节点的值，然后根据中序遍历，根节点值左边的值就是左子树节点，右边的值就是右子树节点。
     * @param startPreOrder
     * @param endPreOrder
     * @param startInOrder
     * @param endInOrder
     * @return
     */
    private BinaryTreeNode constructorCore(int startPreOrder, int endPreOrder,
                                           int startInOrder, int endInOrder) {
        //前序遍历第一个值等于根节点的值
        int rootVal = preOrderNodes[startPreOrder];

        BinaryTreeNode root = new BinaryTreeNode(rootVal);
        root.setLeft(null);
        root.setRight(null);

        //叶子节点结束递归
        if (startPreOrder == endPreOrder) {
            if (startInOrder == endInOrder && preOrderNodes[startPreOrder] == inOrderNodes[startInOrder]) {
                return root;
            }else throw new RuntimeException("Invalid Input");
        }
        //在中序遍历中找到根节点的位置
        int rootInOrder = startInOrder;
        while (rootInOrder <= endInOrder && inOrderNodes[rootInOrder] != rootVal) {
            rootInOrder ++;
        }
        //前序遍历和中序遍历不匹配
        if (rootInOrder - 1 == endInOrder && inOrderNodes[rootInOrder - 1] != rootVal) {
            throw new RuntimeException("Invalid input");
        }
        //左节点数
        int leftLength = rootInOrder - startInOrder;
        int leftPreOrderEnd = startPreOrder + leftLength;

        if (leftLength > 0) {
            //构建左子树
            root.setLeft(constructorCore(startPreOrder + 1, leftPreOrderEnd,
                    startInOrder,rootInOrder -1));
        }
        if (leftLength < endPreOrder - startPreOrder) {
            //构建右子树
            root.setRight(constructorCore(leftPreOrderEnd + 1, endPreOrder,
                    rootInOrder + 1,endInOrder));
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,6,5,3,8,1};
        BinaryTreeNode.printTree(new 重建二叉树().constructorTree(pre,inOrder));
    }
}
