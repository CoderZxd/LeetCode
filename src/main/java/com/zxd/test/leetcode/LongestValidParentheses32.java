package com.zxd.test.leetcode;

import java.util.Stack;

/**
 * @Title: LongestValidParentheses32
 * @Description: https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @Author xiaodong.zou
 * @Date 2020/4/26 23:13
 */
//32. 最长有效括号
//		给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的【子串】的长度。
//
//		示例 1:
//
//		输入: "(()"
//		输出: 2
//		解释: 最长有效括号子串为 "()"
//		示例 2:
//
//		输入: ")()())"
//		输出: 4
//		解释: 最长有效括号子串为 "()()"
public class LongestValidParentheses32 {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()(())"));
		System.out.println(longestValidParentheses("()(()"));
	}

	public static int longestValidParentheses(String s) {
		String[] charArray = s.split("");
		Stack<String> charStack = new Stack<>();
		int result = 0;
		for(String ele:charArray){
			if("(".equals(ele)){
				charStack.push(ele);
			}
			if(")".equals(ele) && !charStack.empty()){
				String stack = charStack.pop();
				if(stack != null && stack.equals("(")){
					result += 2;
				}
			}
		}
		return result;
	}
}
