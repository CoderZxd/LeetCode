package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @Author zouxiaodong
 * @Date 2021/03/25 9:39
 */
//83. 删除排序链表中的重复元素
//        存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
//        返回同样按升序排列的结果链表。
//
//        示例 1：
//              1->1->2
//                 ↓
//                1->2
//        输入：head = [1,1,2]
//        输出：[1,2]
//        示例 2：
//        1->1->2->3->3
//              ↓
//           1->2->3
//        输入：head = [1,1,2,3,3]
//        输出：[1,2,3]
//
//
//        提示：
//        链表中节点数目在范围 [0, 300] 内
//        -100 <= Node.val <= 100
//        题目数据保证链表已经按升序排列
public class DeleteDuplicates_83 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(3);
        head.next = node_1;
        node_1.next = node_2;
//        node_2.next = node_3;
//        node_3.next = node_4;
        DeleteDuplicates_83 deleteDuplicates_83 = new DeleteDuplicates_83();
        ListNode node = deleteDuplicates_83.deleteDuplicates(head);
        System.out.println(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head != null && head.next != null){
            ListNode left = head;
            ListNode right = head.next;
            while (right != null){
                if (left.val != right.val) {
                    left.next = right;
                    left = right;
                }
                right = right.next;
            }
            left.next = null;
        }
        return head;
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