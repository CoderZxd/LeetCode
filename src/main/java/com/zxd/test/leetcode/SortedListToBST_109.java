package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * @Author zouxiaodong
 * @Date 2020/08/18 8:16
 */
//109. 有序链表转换二叉搜索树
//        给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
//        本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
//        示例:
//
//        给定的有序链表： [-10, -3, 0, 5, 9],
//
//        一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//         0
//        / \
//      -3   9
//      /   /
//    -10  5
public class SortedListToBST_109 {

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode second = new ListNode(-3);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(5);
        ListNode fifth = new ListNode(9);
        fourth.next = fifth;
        third.next = fourth;
        second.next = third;
        head.next = second;
        SortedListToBST_109 sortedListToBST_109 = new SortedListToBST_109();
        TreeNode root = sortedListToBST_109.sortedListToBST(head);
        System.out.println(root);
    }

    public TreeNode sortedListToBST(ListNode head) {
        ListNode tempListNode = head;
        List<Integer> nodeValList = new ArrayList<>();
        while(tempListNode != null){
            nodeValList.add(tempListNode.val);
            tempListNode = tempListNode.next;
        }
        System.out.println(nodeValList);
        if(!nodeValList.isEmpty()){
            return generateTreeNode(nodeValList);
        }
        return null;
    }

    private TreeNode generateTreeNode(List<Integer> nodesList){
        if(!nodesList.isEmpty()){
            int size = nodesList.size();
            int mid = (size+1)/2-1;
            if(mid>=0 && mid < size){
                TreeNode temp = new TreeNode(nodesList.get(mid));
                temp.left = generateTreeNode(nodesList.subList(0,mid));
                temp.right = generateTreeNode(nodesList.subList(mid+1,size));
                return temp;
            }
        }
        return null;
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */