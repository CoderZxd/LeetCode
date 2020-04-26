package com.zxd.test.leetcode;

/**
 * @Title: ReverseKGroup_25
 * @Description: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @Author xiaodong.zou
 * @Date 2020/4/26 16:14
 */
//25. K 个一组翻转链表
//		给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
//		k 是一个正整数，它的值小于或等于链表的长度。
//
//		如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//
//
//		示例：
//
//		给你这个链表：1->2->3->4->5
//
//		当 k = 2 时，应当返回: 2->1->4->3->5
//
//		当 k = 3 时，应当返回: 3->2->1->4->5
//
//
//
//		说明：
//
//		你的算法只能使用常数的额外空间。
//		你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseKGroup_25 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l1_2 = new ListNode(2);
		ListNode l1_3 = new ListNode(3);
		ListNode l1_4 = new ListNode(4);
		ListNode l1_5 = new ListNode(5);
		ListNode l1_6 = new ListNode(6);
		ListNode l1_7 = new ListNode(7);
		ListNode l1_8 = new ListNode(8);
		l1_7.next = l1_8;
		l1_6.next = l1_7;
		l1_5.next = l1_6;
		l1_4.next = l1_5;
		l1_3.next = l1_4;
		l1_2.next = l1_3;
		l1.next = l1_2;
		reverseKGroup(l1,3);
	}

	/**
	 * 将head根据k进行切割，然后将切割后的节点全部进行反转后再拼接一起
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode tempnode = head;
		List<Map<Integer,ListNode>> nodesList = new ArrayList<>(10);
		while (tempnode != null){
			ListNode ln = new ListNode(0);
			ListNode tempLn = ln;
			int nums = 0;
			for(int i=1;i<=k;i++){
				if(tempnode != null){
					tempLn.next = new ListNode(tempnode.val);
					tempnode = tempnode.next;
					tempLn = tempLn.next;
					nums = i;
				}
			}
			Map<Integer,ListNode> tempMap = new HashMap<>(2);
			tempMap.put(nums,ln.next);
			nodesList.add(tempMap);
		}
		List<Map<ListNode,ListNode>> result = new ArrayList<>(10);
		for(Map<Integer,ListNode> ele:nodesList){
			Set<Integer> keys = ele.keySet();
			for(Integer key:keys){
				if(key==k){
					ListNode start = ele.get(key);
					ListNode next = start.next;
					start.next = next.next;
					next.next = start;
					while (start != null){
						ListNode temp = start.next;
						if(temp == null){
							break;
						}
						start.next = temp.next;
						temp.next = next;
						next = temp;
					}
					Map<ListNode,ListNode> tempMap = new HashMap<>(2);
					tempMap.put(start,next);
					result.add(tempMap);
				}else{
					Map<ListNode,ListNode> tempMap = new HashMap<>(2);
					tempMap.put(ele.get(key),ele.get(key));
					result.add(tempMap);
				}
			}
		}
		List<ListNode> startNodes = new ArrayList<>(10);
		List<ListNode> resultNodes = new ArrayList<>(10);
		for(Map<ListNode,ListNode> eleMap:result){
			startNodes.addAll(eleMap.keySet());
			resultNodes.addAll(eleMap.values());
		}
		for(int i=0;i<startNodes.size()-1;i++){
			startNodes.get(i).next = resultNodes.get(i+1);
		}
		return resultNodes.get(0);
	}


}
