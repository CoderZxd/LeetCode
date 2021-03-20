package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @Author zouxiaodong
 * @Date 2021/03/18 10:54
 */
//92.反转链表II
//   反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
//        说明:
//        1 ≤ m ≤ n ≤ 链表长度。
//
//        示例:
//        输入: 1->2->3->4->5->NULL, m = 2, n = 4
//        输出: 1->4->3->2->5->NULL
public class Solution_92 {

    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
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