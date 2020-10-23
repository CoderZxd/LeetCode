package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/palindrome-linked-list/
 * @Author zouxiaodong
 * @Date 2020/10/23 11:01
 */
//234. 回文链表
//        请判断一个链表是否为回文链表。
//
//        示例 1:
//
//        输入: 1->2
//        输出: false
//        示例 2:
//
//        输入: 1->2->2->1
//        输出: true
//        进阶：
//        你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
public class IsPalindrome_234 {

    public static void main(String[] args) {
        IsPalindrome_234 isPalindrome_234 = new IsPalindrome_234();
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        ListNode next_1 = new ListNode(2);
        ListNode next_2 = new ListNode(2);
        head.next = next;
        next.next = next_1;
        next_1.next = next_2;
        System.out.println(isPalindrome_234.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>(10);
        while (head != null){
            values.add(head.val);
            head = head.next;
        }
        int size = values.size();
        for(int i=0,j=size-1;i<j;i++,j--){
            if(!values.get(i).equals(values.get(j))){
                return false;
            }
        }
        return true;
    }

    /**
     * @Author zouxiaodong
     * @Description 快慢指针
     * @Date 2020/10/23 11:20
     * @Param [head]
     * @return boolean
     **/
    public boolean isPalindrome_1(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */