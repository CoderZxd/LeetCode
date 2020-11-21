package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName SortList_148
 * @Description https://leetcode-cn.com/problems/sort-list/
 * @Author xiaodong.zou
 * @Date 2020/11/21 14:36
 * @Version 1.0
 */
//148. 排序链表
//        给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
//        进阶：
//
//        你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
//
//        示例 1：
//
//        输入：head = [4,2,1,3]
//        输出：[1,2,3,4]
//        示例 2：
//
//        输入：head = [-1,5,3,4,0]
//        输出：[-1,0,3,4,5]
//        示例 3：
//
//        输入：head = []
//        输出：[]
//
//
//        提示：
//        链表中节点的数目在范围 [0, 5 * 104] 内
//        -105 <= Node.val <= 105
public class SortList_148 {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        node4.next = node2;
        node2.next=node1;
        node1.next=node3;
        SortList_148 sortList_148 = new SortList_148();
        ListNode node = sortList_148.sortList(node4);
        System.out.println(node);
    }

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        Collections.sort(list, (n1, n2) -> n1.val - n2.val);
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).next = list.get(i);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }
}
