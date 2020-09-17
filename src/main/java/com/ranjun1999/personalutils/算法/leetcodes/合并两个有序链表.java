package com.ranjun1999.personalutils.算法.leetcodes;


import com.ranjun1999.personalutils.算法.utils.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @Author: ranjun
 * @Date: 2019/11/29 19:38
 */
public class 合并两个有序链表 {


    /**
     * 时间复杂度 O(n)
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        ListNode currentNode = new ListNode(0);

        ListNode head = currentNode;


        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (cur1 != null || cur2 != null) {

            if (cur1 == null) {
                currentNode.next = cur2;
                break;
            }

            if (cur2 == null) {
                currentNode.next = cur1;
                break;
            }

            if (cur1.val > cur2.val) {
                currentNode.next = cur2;
                currentNode = currentNode.next;
                cur2 = cur2.next;
            }else {
                currentNode.next = cur1;
                currentNode = currentNode.next;
                cur1 = cur1.next;
            }
        }

        return head.next;
    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode temp;
        if(l1.val<l2.val){
            temp = l1;
            //若l1节点的值小于l2节点，向后移动l1节点
            temp.next= mergeTwoLists_2(l1.next,l2);
        }else{
            //若l1节点的值大于等于l2节点，向后移动l2节点
            temp = l2;
            temp.next= mergeTwoLists_2(l1,l2.next);
        }
        return temp;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);

        l1 = mergeTwoLists(l1,l2);

        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
}
