package com.zxd.test.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName RemoveDuplicateNodes_02_01_For_Offer
 * @Description https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * @Author xiaodong.zou
 * @Date 2020/6/26 10:22
 * @Version 1.0
 */
//面试题 02.01. 移除重复节点
//        编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//
//        示例1:
//
//        输入：[1, 2, 3, 3, 2, 1]
//        输出：[1, 2, 3]
//        示例2:
//
//        输入：[1, 1, 1, 1, 2]
//        输出：[1, 2]
//        提示：
//
//        链表长度在[0, 20000]范围内。
//        链表元素在[0, 20000]范围内。
//        进阶：
//
//        如果不得使用临时缓冲区，该怎么解决？
public class RemoveDuplicateNodes_02_01_For_Offer {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_3_2 = new ListNode(3);
        ListNode node_2_2 = new ListNode(2);
        ListNode node_1_2 = new ListNode(1);
        node_2_2.next = node_1_2;
        node_3_2.next = node_2_2;
        node_3.next = node_3_2;
        node_2.next = node_3;
        head.next = node_2;
        RemoveDuplicateNodes_02_01_For_Offer removeDuplicateNodes = new RemoveDuplicateNodes_02_01_For_Offer();
        ListNode node = removeDuplicateNodes.removeDuplicateNodes(head);
        System.out.println(node);
        ListNode head_1 = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        head_1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode headNew = removeDuplicateNodes.removeDuplicateNodes(head_1);
        System.out.println(headNew);
    }

    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 79.61% 的用户
     * 内存消耗： 41.2 MB , 在所有 Java 提交中击败了 100.00% 的用户
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){
            return head;
        }
        Set<Integer> valueSet = new HashSet<>(16);
        ListNode tempNode = head;
        valueSet.add(tempNode.val);
        while (tempNode.next != null){
            if(valueSet.contains(tempNode.next.val)){
                tempNode.next = tempNode.next.next;
                continue;
            }
            valueSet.add(tempNode.next.val);
            tempNode = tempNode.next;
        }
        return head;
    }

    /**
     * 双层循环,O(1)空间复杂度,O(n^2)时间复杂度
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes_2(ListNode head) {
        ListNode ob = head;
        while (ob != null) {
            ListNode oc = ob;
            while (oc.next != null) {
                if (oc.next.val == ob.val) {
                    oc.next = oc.next.next;
                } else {
                    oc = oc.next;
                }
            }
            ob = ob.next;
        }
        return head;
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