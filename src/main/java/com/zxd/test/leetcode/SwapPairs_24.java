package com.zxd.test.leetcode;

/**
 * @ClassName SwapPairs_24
 * @Description https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @Author xiaodong.zou
 * @Date 2020/4/25 13:17
 * @Version 1.0
 */
//24. 两两交换链表中的节点
//        给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//        你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
//        示例:
//
//        给定 1->2->3->4, 你应该返回 2->1->4->3.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapPairs_24 {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4);
        ListNode l1_5 = new ListNode(5);
        ListNode l1_6 = new ListNode(6);
        l1_5.next = l1_6;
        l1_4.next = l1_5;
        l1_3.next = l1_4;
        l1_2.next = l1_3;
        l1.next = l1_2;
        System.out.println(swapPairs(l1));
    }

    /**
     * 非递归方法
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        //如果为空或者只有一个元素，直接返回
        if(head == null || head.next == null){
            return head;
        }
        //标注开始节点
        ListNode start = head;
        //与开始节点需要交换位置的下一个节点
        ListNode next = head.next;
        //返回的节点一定是开始节点的下一个节点，即上面的next节点
        ListNode resultNode = next;
        //while循环的上一次循环结束时的start节点，因为需要在下次循环将该节点的next指向循环中计算出的next节点，保证链表不断
        ListNode laststart = head;
        //如果start和next都不为空就可以继续交换
        while (start != null && next != null){
            //start节点的next指向next节点的next
            start.next = next.next;
            //next的next指向start，完成start与next的交换
            next.next = start;
            //如果start有next,则将start指向start的next
            start = start == null ? start:start.next;
            //如果start有next,则将next指向start的next
            next = start == null ? start:start.next;
            //如果next不null,则将laststart的next指向next,保证结果链表不断
            if(next != null){
                laststart.next = next;
                //最后将本次的start赋值给laststart,下次whlie循环继续使用
                laststart = start;
            }
        }
        return resultNode;
    }

}
