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
		reverseKGroup(l1,6);
		ListNode re = reverseKGroup_2(l1,6);
		System.out.println(re);
	}

	/**
	 * 非递归
	 * 将head根据k进行切割，然后将切割后的节点全部进行反转后再拼接一起
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode reverseKGroup(ListNode head, int k) {
		//如果head节点数小于2个或者k==1,返回原节点
		if(head == null || head.next == null || k == 1){
			return head;
		}
		ListNode tempnode = head;
		//按照k长度对head进行分割,key为长度,value为分割后的node
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
		//对nodesList的value进行反转，并将key设置为反转前的start节点，因为反转后start节点就变为了最后节点，需要将next指向下一个节点，保证链路正常
		//nodesList结果类似于(以1->2->3->4->5->6->7->8为例子):[{3,1->2->3->null},{3,4->5->6->null},{2,7->8->null}]
		//resultList存放nodesList中各个node反转后的结果，key为每个元素node的头节点,[{3,1->2->3->null},{3,4->5->6->null},{2,7->8->null}]结果反转后:
		//[{1->null,3->2->1->null},{4->null,6->5->4->null},{7->8->null,7->8->null}]
		List<Map<ListNode,ListNode>> resultList = new ArrayList<>(10);
		for(Map<Integer,ListNode> eleNodeMap:nodesList){
			Set<Integer> keys = eleNodeMap.keySet();
			//其实只有一个元素
			for(Integer key:keys){
				//如果节点长度==k才翻转，否则保持不变
				if(key==k){
					//反转前的节点,即start节点(例如节点:1->2->3->null)
					ListNode start = eleNodeMap.get(key);
					ListNode next = start.next;
					//start next
					// ↓      ↓
					// 1----> 2----> 3---->null
					//交换start与next节点,此时next节点在start节点之前，即next.next == start
					start.next = next.next;
					next.next = start;
					//next  start
					// ↓      ↓
					// 2----> 1----> 3---->null
					//如果start节点不为null
					while (start != null){
						//将临时节点temp指向start.next
						//next  start   temp
						// ↓      ↓      ↓
						// 2----> 1----> 3---->null
						ListNode temp = start.next;
						//如果temp不为null,说明可交换的节点
						if(temp == null){
							break;
						}
						//将start的next指向temp的next,即指向start.next节点的next
						//next  start          temp
						// ↓      ↓             ↓
						// 2----> 1---->null    3->null
						start.next = temp.next;
						//将temp的next指向next,即完成start.next指向next节点
						//temp  next  start
						// ↓     ↓     ↓
						// 3---->2---->1---->null
						temp.next = next;
						//将反转后的node赋值给next,便于存入下面的map中
						next = temp;
					}
					Map<ListNode,ListNode> tempMap = new HashMap<>(2);
					//将start节点与反转后的node存入map
					tempMap.put(start,next);
					resultList.add(tempMap);
				}else{
					//如果剩余长度不够k,则不需要反转
					Map<ListNode,ListNode> tempMap = new HashMap<>(2);
					tempMap.put(eleNodeMap.get(key),eleNodeMap.get(key));
					resultList.add(tempMap);
				}
			}
		}
		List<ListNode> startNodes = new ArrayList<>(10);
		List<ListNode> resultNodes = new ArrayList<>(10);
		for(Map<ListNode,ListNode> eleMap:resultList){
			//startNodes中就是存的反转后的node的最后一个节点，需要将给节点的next指向下一个元素
			startNodes.addAll(eleMap.keySet());
			//resultNodes就是反转后的各个node
			resultNodes.addAll(eleMap.values());
		}
		for(int i=0;i<startNodes.size()-1;i++){
			//将startNodes的第i个节点的next指向resultNodes的第i+1节点，最后即为反转后的最后结果
			startNodes.get(i).next = resultNodes.get(i+1);
		}
		return resultNodes.get(0);
	}

	/**
	 * 递归方式
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode reverseKGroup_2(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode end = dummy;
		while (end.next != null) {
			for (int i = 0; i < k && end != null; i++) {
				end = end.next;
			}
			if(end == null){
				break;
			}
			ListNode start = pre.next;
			ListNode next = end.next;
			end.next = null;
			pre.next = reverse(start);
			start.next = next;
			pre = start;
			end = pre;
		}
		return dummy.next;
	}

	private static ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}
}
