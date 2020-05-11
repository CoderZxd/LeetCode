package com.zxd.test.leetcode;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: 19. 删除链表的倒数第N个节点
 * @Version 1.0
 * @create 2019-04-14 20:57
 **/

//   19. 删除链表的倒数第N个节点（https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/）
//        给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//        示例：
//
//        给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//        当删除了倒数第二个节点后，链表变为 1->2->3->5.
//        说明：
//
//        给定的 n 保证是有效的。
//
//        进阶：
//
//        你能尝试使用一趟扫描实现吗？(双指针)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthFromEndSolution_19 {
    public static void main(String[] args){
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        System.out.println(getLength(l1));
        System.out.println(getListNodeLength(l1));
        removeNthFromEnd(l1,0);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        if (right == null) {
            head = head.next;
            return head;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;
    }

    /**
     * class_name: getLength
     * param: [node]
     * describe: 递归计算链表长度
     * creat_user: CoderZZ
     * creat_date: 2019-04-14
     * creat_time: 23:17
     **/
    public static int getLength(ListNode node){
        if(node == null){
            return 0;
        }else{
            return 1+ getLength(node.next);
        }
    }

    /**
     * class_name: getListNodeLength
     * param: [node]
     * describe: 非递归计算链表长度
     * creat_user: CoderZZ
     * creat_date: 2019-04-14
     * creat_time: 23:19
     **/
    public static int getListNodeLength(ListNode node){
        int length = 0;
        while (node != null){
            length++;
            node = node.next;
        }
        return length;
    }
}
