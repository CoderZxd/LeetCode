package com.zxd.test.leetcode;


/**
 * @Title: LongestCommonPrefix_14
 * @Description: https://leetcode-cn.com/problems/longest-common-prefix/
 * @Author xiaodong.zou
 * @Date 2020/6/15 9:07
 */
//14. 最长公共前缀
//		编写一个函数来查找字符串数组中的最长公共前缀。
//
//		如果不存在公共前缀，返回空字符串 ""。
//
//		示例 1:
//
//		输入: ["flower","flow","flight"]
//		输出: "fl"
//		示例 2:
//
//		输入: ["dog","racecar","car"]
//		输出: ""
//		解释: 输入不存在公共前缀。
//		说明:
//
//		所有输入只包含小写字母 a-z 。
public class LongestCommonPrefix_14 {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
		System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
		System.out.println(longestCommonPrefix(new String[]{}));
	}

	/**
	 * 最长的前缀只可能是第0个元素的长度
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		int lenArray = strs.length;
		String result = "";
		if(lenArray == 0) {
			return result;
		}
		if(lenArray == 1){
			return strs[0];
		}
		int len = strs[0].length();
		label:
		for(int i=1;i<=len;i++){
			String subStr = strs[0].substring(0,i);
			for(int j=1;j<lenArray;j++){
				if(!strs[j].startsWith(subStr)){
					break label;
				}
			}
			result = subStr;
		}
		return result;
	}
}
