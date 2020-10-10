package com.zxd.test.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @Author zouxiaodong
 * @Date 2020/10/10 8:06
 */
//142. 环形链表 II
//        给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//        为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
//        说明：不允许修改给定的链表。
//
//        示例 1：
//
//        输入：head = [3,2,0,-4], pos = 1
//        输出：tail connects to node index 1
//        解释：链表中有一个环，其尾部连接到第二个节点。
//
//
//        示例 2：
//
//        输入：head = [1,2], pos = 0
//        输出：tail connects to node index 0
//        解释：链表中有一个环，其尾部连接到第一个节点。
//
//
//        示例 3：
//
//        输入：head = [1], pos = -1
//        输出：no cycle
//        解释：链表中没有环。
//
//        进阶：
//        你是否可以不用额外空间解决此题？
public class DetectCycle_142 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(4);
        head.next = n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n2;
        DetectCycle_142 detectCycle142 = new DetectCycle_142();
        ListNode cycleNode = detectCycle142.detectCycle_2(head);
        System.out.println(cycleNode);
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null){
            if(!nodeSet.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * @Author zouxiaodong
     * @Description 不适用额外空间，使用快慢指针先判断是否有环，再找到入环的第一个节点
     * @Date 2020/10/10 8:53
     * @Param [head]
     * @return com.zxd.test.leetcode.ListNode
     **/
    public ListNode detectCycle_1(ListNode head) {
        //第一步：使用快慢指针判断是否有环
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //第二步:如果有环，找到入环的第一个节点
        ListNode startNode = head;
        ListNode nextNode = slow.next;
        while (startNode != nextNode){
            if(nextNode != slow){
                nextNode = nextNode.next;
            }else{
                startNode = startNode.next;
                nextNode = slow.next;
            }
        }
        return startNode;
    }

    /**
     * @Author zouxiaodong
     * @Description 快慢指针二
     * @Date 2020/10/10 9:37
     * @Param [head]
     * @return com.zxd.test.leetcode.ListNode
     **/
    public ListNode detectCycle_2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */