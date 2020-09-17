package com.ranjun1999.personalutils.算法.剑指Offer;

import com.ranjun1999.personalutils.算法.utils.BinaryTreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。
 * @Author: ranjun
 * @Date: 2020/9/14 15:46
 */
public class HasSubTree_26 {

    /**
     * 要查找A树是否存在和B树结构一样的子树，有两步：
     * 1.在树A中找到和树B的根节点的值一样的节点R；
     * 2. 判断树A中以R为根节点的子树是不是包含和B树一样的结构
     * @param root1
     * @param root2
     * @return
     */
    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean isInclude = false;
        if (root1 != null && root2 != null) {
            if (root1.getVal() == root2.getVal())
                isInclude = doesTree1HasTree2(root1, root2);
            if (!isInclude)
                isInclude = hasSubTree(root1.getLeft(),root2);
            if (!isInclude)
                isInclude = hasSubTree(root1.getRight(),root2);
        }
        return isInclude;
    }

    /**
     * 判断以root1为根节点的子树是不是和树root2具有相同的结构
     * @param root1
     * @param root2
     * @return
     */
    private static boolean doesTree1HasTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        //如果roo2为空，说明包含树B子结构，返回空
        if (root2 == null) {
            return true;
        }
        if (root1 == null)
            return false;
        //如果节点值不相等，说明不包含
        if (root1.getVal() != root2.getVal())
            return false;
        //递归左右子树
        return doesTree1HasTree2(root1.getLeft(),root2.getLeft()) && doesTree1HasTree2(root1.getRight(), root2.getRight());
    }


}
