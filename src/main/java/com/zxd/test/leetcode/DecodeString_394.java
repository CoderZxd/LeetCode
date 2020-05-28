package com.zxd.test.leetcode;

import java.util.Stack;

/**
 * @Title: DecodeString_394
 * @Description: https://leetcode-cn.com/problems/decode-string/
 * @Author xiaodong.zou
 * @Date 2020/5/28 9:02
 */
//394. 字符串解码
//		给定一个经过编码的字符串，返回它解码后的字符串。
//
//		编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
//		你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
//		此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
//		示例:
//
//		s = "3[a]2[bc]", 返回 "aaabcbc".
//		s = "3[a2[c]]", 返回 "accaccacc".
//		s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
public class DecodeString_394 {

	public static void main(String[] args) {
//		System.out.println(decodeString("3[a]2[bc]"));
//		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("100[leetcode]"));
	}

	public static String decodeString(String s) {
		//1.结果栈
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for(char ele:chars){
			//如果是‘]’,需要弹栈,找到'['为需要重复的字符串
			if(']' == ele){
				StringBuffer sb = new StringBuffer();
				//循环弹栈
				label:
				for(;;){
					char temp = stack.peek();
					//如果为‘[’说明找到了字符串的左边界,否则仍然是需要重复的字符
					if('[' == temp){
						//将‘[’弹栈丢弃
						stack.pop();
						//继续弹栈找到字符串的重复次数
						StringBuffer numSb = new StringBuffer();
						for(;;){
							//如果栈空或者当前栈顶的字符不是数字,则说明重复次数已找到,将拼接的字符串继续压入栈中
							if(stack.isEmpty() || stack.peek()<'0' || stack.peek() > '9') {
								StringBuffer sbsb = new StringBuffer();
								String tempStr = sb.reverse().toString();
								String numStr = numSb.reverse().toString();
								for(int i =0;i<Integer.parseInt(numStr);i++){
									sbsb.append(tempStr);
								}
								for(char cc:sbsb.toString().toCharArray()){
									stack.push(cc);
								}
								break label;
							}else{
								numSb.append(stack.pop());
							}
						}
					}else{
						sb.append(stack.pop());
					}
				}
			}else{
				stack.push(ele);
			}
		}
		StringBuffer resultsb = new StringBuffer();
		for(char c:stack){
			resultsb.append(c);
		}
		return resultsb.toString();
	}
}
