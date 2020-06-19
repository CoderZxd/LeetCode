package com.zxd.test.leetcode;

/**
 * @Title: IsPalindrome_125
 * @Description: https://leetcode-cn.com/problems/valid-palindrome/
 * @Author xiaodong.zou
 * @Date 2020/6/19 16:51
 */
//125. 验证回文串
//		给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
//		说明：本题中，我们将空字符串定义为有效的回文串。
//
//		示例 1:
//
//		输入: "A man, a plan, a canal: Panama"
//		输出: true
//		示例 2:
//
//		输入: "race a car"
//		输出: false
public class IsPalindrome_125 {

	public static void main(String[] args) {
		IsPalindrome_125 isPalindrome_125 = new IsPalindrome_125();
		System.out.println(isPalindrome_125.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome_125.isPalindrome("race a car"));
		System.out.println(isPalindrome_125.isPalindrome("         "));
		System.out.println(isPalindrome_125.isPalindrome("0P"));
		System.out.println(isPalindrome_125.isPalindrome("0"));
		System.out.println(isPalindrome_125.isPalindrome(""));
	}

	public boolean isPalindrome(String s) {
		int len = s.length();
		for(int l=0,r=len-1;l<=r;){
//				if(!((s.charAt(l)>='a' && s.charAt(l)<='z') || (s.charAt(l)>='0' && s.charAt(l)<='9') || (s.charAt(l)>='A' && s.charAt(l)<='Z'))){
//					l++;
//					continue;
//				}
			if(!Character.isLetterOrDigit(s.charAt(l))){
				l++;
				continue;
			}
//				if(!((s.charAt(r)>='a' && s.charAt(r)<='z') || (s.charAt(r)>='0' && s.charAt(r)<='9') || (s.charAt(r)>='A' && s.charAt(r)<='Z'))){
//					r--;
//					continue;
//				}
			if(!Character.isLetterOrDigit(s.charAt(r))){
				r--;
				continue;
			}
			if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
