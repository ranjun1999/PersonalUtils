package com.ranjun1999.personalutils.算法.nowcoder.linkedlist;

import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * @Author: ranjun
 * @Date: 2020/3/20 11:04
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class 删除链表中的重复节点 {

    /**
     * 需要两个指针，一个指向前一个节点preNode，另一个指向当前节点node，
     * 如果遇到相等的节点，node向后移动，preNode不动，存下node.val方便后面的比较，直到遇到node和node.next不相等，preNode就可以指向node.next
     * 注意：链表开头可能就开始有重复的节点，所以默认preNode=null，在后面的给preNode赋值的时候，若preNode为null，那就把pHead设置为node.next
     * @param pHead
     * @return
     */
    public ListNode delDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode node = pHead;
        ListNode prNode = null;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                if (prNode == null) {
                    pHead = node.next;
                }else {
                    prNode.next = node.next;
                }
            }else prNode = node;
            node = node.next;
        }
        return pHead;
    }

}
