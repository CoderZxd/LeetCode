package com.zxd.test.leetcode;

import java.util.Stack;

/**
 * @Title: CQueue
 * @Description: https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @Author xiaodong.zou
 * @Date 2020/6/30 9:02
 */
//剑指 Offer 09. 用两个栈实现队列
//		用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//
//
//		示例 1：
//
//		输入：
//		["CQueue","appendTail","deleteHead","deleteHead"]
//		[[],[3],[],[]]
//		输出：[null,null,3,-1]
//		示例 2：
//
//		输入：
//		["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//		[[],[],[5],[2],[],[]]
//		输出：[null,-1,null,null,5,2]
//		提示：
//
//		1 <= values <= 10000
//		最多会对 appendTail、deleteHead 进行 10000 次调用
class CQueue {

	private Stack<Integer> tail;

	private Stack<Integer> head;

	public CQueue() {
		this.tail = new Stack<>();
		this.head = new Stack<>();
	}

	public void appendTail(int value) {
		this.tail.push(value);
		Stack<Integer> tempHead = new Stack<>();
		for(Integer ele:tail){
			tempHead.push(ele);
		}
		this.head = new Stack<>();
		while (!tempHead.isEmpty()){
			this.head.push(tempHead.pop());
		}
	}

	public int deleteHead() {
		if(!head.isEmpty()){
			int value =  head.pop();
			Stack<Integer> tempTail = new Stack<>();
			for(Integer ele:head){
				tempTail.push(ele);
			}
			this.tail = new Stack<>();
			while (!tempTail.isEmpty()){
				this.tail.push(tempTail.pop());
			}
			return value;
		}
		return -1;
	}

	public static void main(String[] args) {
		CQueue cQueue = new CQueue();
		System.out.println(cQueue.deleteHead());
		cQueue.appendTail(5);
		cQueue.appendTail(2);
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		CQueue cQueue_1 = new CQueue();
		cQueue_1.appendTail(3);
		System.out.println(cQueue_1.deleteHead());
		System.out.println(cQueue_1.deleteHead());
	}
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
