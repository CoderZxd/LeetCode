package com.zxd.test.leetcode;

/**
 * @ClassName RemoveNthFromEnd_19
 * @Description https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @Author xiaodong.zou
 * @Date 2020/10/18 20:44
 * @Version 1.0
 */
//19. 删除链表的倒数第N个节点
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
//        你能尝试使用一趟扫描实现吗？
public class RemoveNthFromEnd_19 {

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        RemoveNthFromEnd_19 removeNthFromEnd_19 = new RemoveNthFromEnd_19();
        ListNode result = removeNthFromEnd_19.removeNthFromEnd(node_1,2);
        System.out.println(result);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n>0){
            fast = fast.next;
            n--;
        }
        if(fast == null){
            head = head.next;
            return head;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
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