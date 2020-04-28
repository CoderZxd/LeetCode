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
		Stack<Integer> indexStack = new Stack<>();
		for(int i=0;i< s.length();i++){
			if('(' == s.charAt(i)){
				indexStack.push(i);
			}
			if(')' == s.charAt(i)){
				if(!indexStack.empty() && s.charAt(indexStack.peek()) == '('){
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

//	方法 2：动态规划算法
//
//	这个问题可以通过动态规划解决。我们定义一个 dp 数组，其中第 i 个元素表示以下标为 i 的字符结尾的最长有效子字符串的长度。我们将dp 数组全部初始化为 0 。现在，很明显有效的子字符串一定以‘)’ 结尾。这进一步可以得出结论：以‘(’ 结尾的子字符串对应的dp 数组位置上的值必定为 0 。
	// 	所以说我们只需要更新‘)’ 在 dp 数组中对应位置的值。
//
//	为了求出dp 数组，我们每两个字符检查一次，如果满足如下条件
//
//1.s[i]=‘)’ 且s[i−1]=‘(’ ，也就是字符串形如"……()"，我们可以推出：dp[i]=dp[i−2]+2
//
//我们可以进行这样的转移，是因为结束部分的 "()" 是一个有效子字符串，并且将之前有效子字符串的长度增加了 2 。
//
//2.s[i]=‘)’且s[i−1]=‘)’，也就是字符串形如".......))" ，我们可以推出：
//	如果s[i−dp[i−1]−1]=‘(’ ，那么 dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
//
//	这背后的原因是如果倒数第二个‘)’ 是一个有效子字符串的一部分（记为 sub），对于最后一个‘)’ ，如果它是一个更长子字符串的一部分，那么它一定有一个对应的‘(’ ，它的位置在倒数第二个‘)’ 所在的有效子字符串的前面（也就是 sub的前面）。
// 	因此，如果子字符串 sub的前面恰好是(’ ，那么我们就用 2加上 sub的长度（dp[i−1]）去更新dp[i]。除此以外，我们也会把有效子字符串"(,sub,)"之前的有效子字符串的长度也加上，也就是加上dp[i−dp[i−1]−2] 。
	/**
	 * 动态规划
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses_dy(String s) {
		int maxans = 0;
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
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
