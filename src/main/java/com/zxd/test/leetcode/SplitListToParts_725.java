package com.zxd.test.leetcode;

import java.util.Arrays;

/**
 * @Description https://leetcode-cn.com/problems/split-linked-list-in-parts/
 * @Author zouxiaodong
 * @Date 2021/09/22 9:35
 */
//725. 分隔链表
//        给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
//
//        每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
//
//        这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
//
//        返回一个由上述 k 部分组成的数组。
//
//
//        示例 1：
//
//        1->2->3
//        输入：head = [1,2,3], k = 5
//        输出：[[1],[2],[3],[],[]]
//        解释：
//        第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
//        最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
//        示例 2：
//
//        1->2->3->4->5->6->7->8->9->10
//        输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
//        输出：[[1,2,3,4],[5,6,7],[8,9,10]]
//        解释：
//        输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
//
//
//        提示：
//
//        链表中节点的数目在范围 [0, 1000]
//        0 <= Node.val <= 1000
//        1 <= k <= 50
public class SplitListToParts_725 {

    public static void main(String[] args) {
        SplitListToParts_725 splitListToParts_725 = new SplitListToParts_725();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        head.next = node2;
        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
//        node5.next=node6;
//        node6.next=node7;
//        node7.next=node8;
//        node8.next=node9;
//        node9.next=node10;
        splitListToParts_725.splitListToParts(head,5);
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] resultNodeList = new ListNode[k];
        //计算链表长度
        int len = 0;
        ListNode temp = head;
        while (temp != null){
            temp=temp.next;
            len++;
        }
        //计算平均每个部分包含的节点数
        int eachNums = len/k;
        //计算剩余的节点数,剩余的个数需要在前modNums个节点+1
        int modNums = len%k;
        int[] sizes = new int[k];
        Arrays.fill(sizes,eachNums);
        for(int i=0;i<modNums;i++){
            sizes[i]++;
        }
        temp = head;
        for(int i=0;i<k;i++){
            if(sizes[i]>0){
                ListNode nodeHead = temp;
                ListNode eachNodeTail = temp.next;
                resultNodeList[i] = nodeHead;
                for(int j=0;j<sizes[i];j++){
                    eachNodeTail = temp;
                    temp = temp.next;
                }
                eachNodeTail.next = null;
            }
        }
        return resultNodeList;
    }

    /**
     * @Author zouxiaodong
     * @Description 实现间隔划分(非连续划分,与要求不符)
     * @Date 2021/09/22 10:21
     * @Param [head, k]
     * @return com.zxd.test.leetcode.ListNode[]
     **/
    public ListNode[] splitListToParts_1(ListNode head, int k) {
        ListNode[] resultNodeList = new ListNode[k];
        ListNode[] tailNodeList = new ListNode[k];
        int index = 0;
        while (head != null){
            ListNode temp = head;
            head=head.next;
            temp.next = null;
            if(resultNodeList[index%k] == null){
                resultNodeList[index%k] = temp;
                tailNodeList[index%k] = temp;
            }else{
                tailNodeList[index%k].next = temp;
                tailNodeList[index%k] = temp;
            }
            index++;
        }
        return resultNodeList;
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