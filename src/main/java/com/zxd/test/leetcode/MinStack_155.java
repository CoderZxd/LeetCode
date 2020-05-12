package com.zxd.test.leetcode;

/**
 * @Title: MinStack_155
 * @Description: https://leetcode-cn.com/problems/min-stack/
 * @Author xiaodong.zou
 * @Date 2020/5/12 15:03
 */
//155. 最小栈
//		设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//		push(x) —— 将元素 x 推入栈中。
//		pop() —— 删除栈顶的元素。
//		top() —— 获取栈顶元素。
//		getMin() —— 检索栈中的最小元素。
//
//
//		示例:
//
//		输入：
//		["MinStack","push","push","push","getMin","pop","top","getMin"]
//		[[],[-2],[0],[-3],[],[],[],[]]
//
//		输出：
//		[null,null,null,null,-3,null,0,-2]
//
//		解释：
//		MinStack minStack = new MinStack();
//		minStack.push(-2);
//		minStack.push(0);
//		minStack.push(-3);
//		minStack.getMin();   --> 返回 -3.
//		minStack.pop();
//		minStack.top();      --> 返回 0.
//		minStack.getMin();   --> 返回 -2.
//
//
//		提示：
//
//		pop、top 和 getMin 操作总是在 非空栈 上调用。

import java.util.*;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class MinStack_155 {

	private List<Integer> stackList = new ArrayList<>(10);
	/** initialize your data structure here. */
	public MinStack_155() {

	}

	public void push(int x) {
		this.stackList.add(x);
	}

	public void pop() {
		this.stackList.remove(stackList.size()-1);
	}

	public int top() {
		return this.stackList.get(stackList.size()-1);
	}

	public int getMin() {
		int result = stackList.get(0);
		for(int i=1;i<this.stackList.size();i++){
			if(this.stackList.get(i)<result){
				result = this.stackList.get(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MinStack_155 minStack_155 = new MinStack_155();
		minStack_155.push(0);
		minStack_155.push(1);
		minStack_155.push(0);
		System.out.println(minStack_155.getMin());
		minStack_155.pop();
//		minStack_155.top();
		System.out.println(minStack_155.getMin());
	}
}
