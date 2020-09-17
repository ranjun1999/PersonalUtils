package com.ranjun1999.personalutils.算法.nowcoder.linkedlist;

import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * @Author: ranjun
 * @Date: 2020/9/2 16:44
 */
public class DetectCycle {

    /**
     * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
     * 1）首先判断是否有环,有环时，返回相遇的节点，无环，返回null
     * 2）有环的情况下， 求链表的入环节点
     *  fast再次从头出发，每次走一步，
     *  slow从相遇点出发，每次走一步，
     *  再次相遇即为环入口点。
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode meetNode = meetingNode(head);
        if (meetNode == null) {//说明无环
            return null;
        }

        ListNode fast = head;
        ListNode slow = meetNode;
        //快指针的速度是慢指针的两倍 2Vslow = Vfast -> 2Sslow = Sfast
        //得到，将此时两指针分别放在起始位置和相遇位置，并以相同速度前进，当一个指针走到环入口点时，另一个指针恰好走出 绕环n-1圈加上相遇点到环入口点的距离。
        //即此时两指针相遇，即环的入口点位置
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    //寻找相遇节点，如果无环，返回null
    public static ListNode meetingNode(ListNode head) {
        ListNode slow = head;
        if (slow.next == null)
            return null;

        ListNode fast = slow.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                fast = fast.next;
            }
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        System.out.println(detectCycle(listNode).val);
    }
}
