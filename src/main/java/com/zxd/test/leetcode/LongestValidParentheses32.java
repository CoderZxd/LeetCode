package com.zxd.test.leetcode;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
		System.out.println(longestValidParentheses("()(()"));
//		System.out.println(longestValidParentheses_1("))))())()()(()"));
	}

	/**
	 * 通过堆栈比较未匹配的字符，并记录其坐标
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses(String s) {
		String[] charArray = s.split("");
		Stack<Integer> indexStack = new Stack<>();
		for(int i=0;i< charArray.length;i++){
			if("(".equals(charArray[i])){
				indexStack.push(i);
			}
			if(")".equals(charArray[i])){
				if(!indexStack.empty() && charArray[indexStack.peek()].equals("(")){
					indexStack.pop();
				}else{
					indexStack.push(i);
				}
			}
		}
		if(indexStack.empty()){
			return s.length();
		}
		int[] tempArray = new int[s.length()];
		while (!indexStack.empty()){
			tempArray[indexStack.pop()] = 1;
		}
		int result = 0;
		int len = 0;
		for(int i=0;i<tempArray.length;i++){
			if(tempArray[i] == 1){
				len = 0;
				continue;
			}
			len++;
			result = Math.max(result,len);
		}
		return result;
	}

	/**
	 * 正则表达式替换法()替换成1,(1),替换成2,(3)替换成4,以此类推
	 * 解决不了1a(1a的问题，太麻烦
	 * @param s
	 * @return
	 */
	@Deprecated
	public static int longestValidParentheses_1(String s) {
		int result = 0;
		int loop = 1;
		String replace = s.replaceAll("\\(\\)",loop+"a");
		if(replace.equals(s)){
			return 0;
		}
		String beforeReplace = replace;
		String afterReplace = replace;
		boolean isFirst = true;
		while (!afterReplace.equals(beforeReplace) || isFirst){
			beforeReplace = afterReplace;
			isFirst =  false;
			afterReplace = beforeReplace.replaceAll("\\("+loop+"a\\)",(++loop)+"a");
		}
		System.out.println(afterReplace);
		Pattern p=Pattern.compile("\\d+");
		Matcher matcher = p.matcher(afterReplace);
		while (matcher.find()){
			result += Integer.parseInt(matcher.group())*2;
		}
		beforeReplace = afterReplace;
		afterReplace = afterReplace.replaceAll("\\d+a","");
		System.out.println(afterReplace);
		if(!beforeReplace.equals(afterReplace)){
			result += longestValidParentheses(afterReplace);
		}
		return result;
	}
}
