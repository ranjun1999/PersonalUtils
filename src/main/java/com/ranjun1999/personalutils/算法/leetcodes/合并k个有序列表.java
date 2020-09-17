package com.ranjun1999.personalutils.算法.leetcodes;

import com.ranjun1999.personalutils.算法.utils.ListNode;

import java.util.*;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @Author: ranjun
 * @Date: 2019/12/3 22:05
 */
public class 合并k个有序列表 {

    /**
     * 1. 暴力法   时间复杂度  O(N logN)
     *
     *遍历所有链表，将所有节点值放到一个数组或集合中
     * 然后将这个数组排序，得到新的链表
     * @param lists
     * @return
     */
    public static ListNode mergerKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode l = lists[i];
            while (l != null) {
                list.add(l.val);
                l = l.next;
            }
        }
        Collections.sort(list);
        System.out.println(list);

        ListNode cur = new ListNode(0);
        ListNode head = cur;
        for (Integer integer : list) {
            cur.next = new ListNode(integer);
            cur = cur.next;
        }
        return head.next;
    }

    /**
     * 使用最小堆
     * @param lists
     * @return
     */
    public static ListNode mergerKLists_2(ListNode[] lists) {
        int len = 0;
        if((len=lists.length)==0 || lists == null) return null;

        ListNode preHead = new ListNode(-1);
        ListNode preNode = preHead;
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(len, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
        PriorityQueue<ListNode> queue = new PriorityQueue<>(len, (l1, l2) ->{
           return l1.val - l2.val;
        });
        for (ListNode node : lists) {
            if(node!=null) queue.add(node);
        }
        while(!queue.isEmpty()){
            ListNode small = queue.poll();
            preNode.next = small;
            if(small.next!=null) queue.add(small.next); //将最小值节点后面的节点添加到队里中
            preNode = preNode.next;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(new ListNode(new ListNode(5),4),1);
        lists[1] = new ListNode(new ListNode(new ListNode(4),3),1);
        lists[2] = new ListNode(new ListNode(6),2);
        ListNode ls = mergerKLists_2(lists);
        while (ls != null) {
            System.out.print(ls.val + "->");
            ls = ls.next;
        }
    }
}
