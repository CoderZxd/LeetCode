package com.zxd.test.leetcode;

/**
 * @ClassName RotateRight_61
 * @Description https://leetcode-cn.com/problems/rotate-list/
 * @Author xiaodong.zou
 * @Date 2021/3/27 10:26
 * @Version 1.0
 */
//61. 旋转链表
//        给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
//        示例 1：
//        输入：head = [1,2,3,4,5], k = 2
//        输出：[4,5,1,2,3]

//        示例 2：
//        输入：head = [0,1,2], k = 4
//        输出：[2,0,1]
//
//
//        提示：
//        链表中节点的数目在范围 [0, 500] 内
//        -100 <= Node.val <= 100
//        0 <= k <= 2 * 10^9
public class RotateRight_61 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        RotateRight_61 rotateRight_61 = new RotateRight_61();
        ListNode node = rotateRight_61.rotateRight(head, 10);
        System.out.println(node);
    }

    public ListNode rotateRight(ListNode head, int k) {
        //如果head为空或者head.next为空或者k==0，直接返回head
        if(head == null || head.next == null || k==0){
            return head;
        }
        ListNode left = head;
        ListNode right = head;
        int i=0;
        while (i<k){
            //如果i<k,并且right已经到达链表尾部,则此时k>链表长度
            if(right == null){
                //如果k正好是链表长度的整数倍,则直接返回head
                if(k%i==0){
                    return head;
                }
                //取实际的移动次数,从头开始重新计算
                k=k%i;
                i=0;
                right = head;
            }else{
                right = right.next;
                i++;
            }
        }
        //如果正好移动到链表尾部,说明k==链表长度,返回head
        if(right == null){
            return head;
        }
        //找到新的head
        while (right.next != null){
            left = left.next;
            right = right.next;
        }
        ListNode newHead = left.next;
        left.next = null;
        right.next = head;
        return newHead;
    }
}
