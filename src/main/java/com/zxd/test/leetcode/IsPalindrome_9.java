package com.zxd.test.leetcode;

/**
 * @Title: IsPalindrome_9
 * @Description: https://leetcode-cn.com/problems/palindrome-number/
 * @Author xiaodong.zou
 * @Date 2020/6/10 9:07
 */
//
//9. 回文数
//		判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//		示例 1:
//
//		输入: 121
//		输出: true
//		示例 2:
//
//		输入: -121
//		输出: false
//		解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//		示例 3:
//
//		输入: 10
//		输出: false
//		解释: 从右向左读, 为 01 。因此它不是一个回文数。
//		进阶:
//
//		你能不将整数转为字符串来解决这个问题吗？
public class IsPalindrome_9 {

	public static void main(String[] args) {
		System.out.println(isPalindrome(4312134));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(0));
		isPalindrome_1(4312134);
	}

	/**
	 * 不将整数转为字符串来解决
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome_1(int x) {
		if(x<0){
			return false;
		}
		int result = x;
		int mod = 0;
		int reverseX = 0;
		do{
			mod = result%10;
			result = result/10;
			reverseX=reverseX*10+mod;
		}while (result>0);
		if(reverseX == x){
			return true;
		}
		return false;
	}

	/**
	 * 将整数转为字符串来解决
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		String num = Integer.toString(x);
		int len = num.length();
		for(int i=0,j=len-1;i<j;i++,j--){
			if(num.charAt(i) != num.charAt(j)){
				return false;
			}
		}
		return true;
	}
}
