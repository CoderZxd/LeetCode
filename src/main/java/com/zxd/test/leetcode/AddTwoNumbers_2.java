package com.zxd.test.leetcode;

/**
 * @Title: AddTwoNumbers_2
 * @Description: 2. 两数相加
 * @Author xiaodong.zou
 * @Date 2019/11/8 11:35
 */
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//		如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//		您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//		示例：
//
//		输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//		输出：7 -> 0 -> 8
//		原因：342 + 465 = 807
//
//		来源：力扣（LeetCode）
//		链接：https://leetcode-cn.com/problems/add-two-numbers
//		著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class AddTwoNumbers_2 {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode temp = result;
		int carry = 0;
		while(l1 != null || l2 != null){
            temp.next = new ListNode(0);
			int l1Value = 0;
			int l2Value = 0;
			if(l1 != null){
				l1Value = l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				l2Value = l2.val;
				l2 = l2.next;
			}
			int currVal = (l1Value+l2Value+carry) % 10;
			carry = (l1Value+l2Value+carry) / 10;
			temp.next.val = currVal;
			temp = temp.next;
		}
		if(carry != 0){
			temp.next = new ListNode(carry);
		}
		return result.next;
	}

	public static void main(String[] args) {

	}

}
