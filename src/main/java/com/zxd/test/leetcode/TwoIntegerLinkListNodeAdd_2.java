package com.zxd.test.leetcode;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: TODO:一句话描述信息
 * @Version 1.0
 * @create 2018-09-12 0:36
 **/
//给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
//         https://leetcode-cn.com/problems/add-two-numbers/
//        你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//
//        示例：
//
//        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8
//        原因：342 + 465 = 807
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}
public class TwoIntegerLinkListNodeAdd_2 {
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 0;
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (l1 != null || l2 != null) {
            int l1Value = 0;
            int l2Value = 0;
            if (l1 != null) {
                l1Value = l1.val;
            }
            if(l2 != null){
                l2Value = l2.val;
            }
            int value = (l1Value+l2Value+carry)%10;
            temp.next = new ListNode(value);
            carry = (l1Value+l2Value+carry)/10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(carry > 0){
            temp.next = new ListNode(carry);
        }
        return result.next;
    }
    
    public static void main(String[] args){
        ListNode l1 = new ListNode(5);
//        ListNode l1_2 = new ListNode(4);
//        ListNode l1_3 = new ListNode(3);
//        l1_2.next = l1_3;
//        l1.next = l1_2;
        ListNode l2 = new ListNode(5);
//        ListNode l2_2 = new ListNode(6);
//        ListNode l2_3 = new ListNode(4);
//        l2_2.next = l2_3;
//        l2.next = l2_2;
        ListNode test = addTwoNumbers(l1,l2);
        System.out.println(test);
    }
}