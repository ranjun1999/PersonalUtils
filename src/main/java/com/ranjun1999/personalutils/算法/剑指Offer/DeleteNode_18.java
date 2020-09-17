package com.ranjun1999.personalutils.算法.剑指Offer;

import com.ranjun1999.personalutils.算法.utils.ListNode;

import java.util.List;

/**
 * 在O(1)时间删除链表节点
 * @Author: ranjun
 * @Date: 2020/9/11 13:48
 */
public class DeleteNode_18 {


    /**
     * 给定单向列表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点
     *
     *要在O(1)时间内删除指定节点，可以将要删除节点的下一个的内容复制到要删除节点，并将要删除节点的下一个节点指向下下一个节点
     * 但是如果要删除节点位于链表的尾部，仍需要从头遍历链表，找到要删除节点的头一个节点
     * 如果链表只有一个节点，则将链表头置为空，然后再返回
     * @param head
     * @param deleteNode
     * @return
     */
    public static ListNode deleteListNode(ListNode head, ListNode deleteNode) {
        if(head == null || deleteNode == null)
            return head;
        //1.删除节点不是尾节点
        if (deleteNode.next != null) {
            ListNode nextNode = deleteNode.next;
            deleteNode.val = nextNode.val;
            deleteNode.next = nextNode.next;
            nextNode = null;
        }
        else if (head == deleteNode){
            //链表只有一个结点，删除头结点
            head = null;
        }else {//链表中有多个节点，删除尾节点
            ListNode node = head;
            while (node.next != deleteNode) {
                node = node.next;
            }
            node.next = null;
        }
        return head;
    }

    /**
     * 在一个排序链表中，删除重复的节点
     * @param head
     * @return
     */
    public static ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = head;
        ListNode preNode = null;
        while (node != null) {
//            ListNode nextNode = preNode.next;
            if (node.next != null && node.next.val == node.val) {
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                if (preNode == null) {
                    head = node.next;
                }else {
                    preNode.next = node.next;
                }
            } else preNode = node;
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l2_1 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l2_1;
        l2_1.next = l3;
        l3.next = l4;
        ListNode.printListNode(l1);
        ListNode.printListNode(deleteDuplication(l1));
    }

}
