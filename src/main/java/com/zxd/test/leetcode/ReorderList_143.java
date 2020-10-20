package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/reorder-list/
 * @Author zouxiaodong
 * @Date 2020/10/20 8:17
 */
//143. 重排链表
//        给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//        将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//        示例 1:
//
//        给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//        示例 2:
//
//        给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
public class ReorderList_143 {

    public static void main(String[] args) {
        ReorderList_143 reorderList_143 = new ReorderList_143();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reorderList_143.reorderList(node1);
        System.out.println(node1);
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode start = head;
        ListNode left = head;
        ListNode right = head.next;
        while (right.next != null){
            left = left.next;
            right = right.next;
        }
        ListNode startNext = start.next;
        start.next = right;
        right.next = startNext;
        left.next = null;
        reorderList(startNext);
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */