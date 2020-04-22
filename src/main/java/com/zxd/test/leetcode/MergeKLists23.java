package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Title: MergeKLists23
 * @Description: https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @Author xiaodong.zou
 * @Date 2020/4/22 9:13
 */

//23. 合并K个排序链表
//		合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
//
//		示例:
//
//		输入:
//		[
//		1->4->5,
//		1->3->4,
//		2->6
//		]
//		输出: 1->1->2->3->4->4->5->6
public class MergeKLists23 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l1_2 = new ListNode(4);
		ListNode l1_3 = new ListNode(5);
		l1.next = l1_2;
		l1_2.next = l1_3;
		ListNode l2 = new ListNode(1);
		ListNode l2_2 = new ListNode(3);
		ListNode l2_3 = new ListNode(4);
		l2.next = l2_2;
		l2_2.next = l2_3;
		ListNode l3 = new ListNode(2);
		ListNode l3_2 = new ListNode(6);
		l3.next = l3_2;
		ListNode[] lists = new ListNode[]{l1,l2,l3};
		System.out.println(mergeKLists(lists));
	}

	/**
	 * 遍历数组链表，获取值并排序，然后生成结果链表
	 * @param lists
	 * @return
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode resultNode = new ListNode(0);
		List<Integer> resultList = new ArrayList<>(10);
		for(ListNode ele:lists){
			while (ele != null){
				resultList.add(ele.val);
				ele = ele.next;
			}
		}
		System.out.println(resultList);
		Collections.sort(resultList);
		System.out.println(resultList);
		ListNode tempResult = resultNode;
		for(Integer ele:resultList){
			tempResult.next = new ListNode(ele);
			tempResult = tempResult.next;
		}
		return resultNode.next;
	}
}

//class ListNode {
//	int val;
//	ListNode next;
//	ListNode(int x) {
//		this.val = x;
//	}
//}