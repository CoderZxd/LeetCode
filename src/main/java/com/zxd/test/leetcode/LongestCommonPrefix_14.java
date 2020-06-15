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
		System.out.println(longestCommonPrefix_2(new String[]{"flower","flow","flight"}));
		System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
		System.out.println(longestCommonPrefix_3(new String[]{"dog","racecar","car"}));
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

	/**
	 * 官方题解一：横向扫描
	 * 依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，更新最长公共前缀，当遍历完所有的字符串以后，即可得到字符串数组中的最长公共前缀。
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix_1(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		int count = strs.length;
		for (int i = 1; i < count; i++) {
			prefix = longestCommonPrefix(prefix, strs[i]);
			if (prefix.length() == 0) {
				break;
			}
		}
		return prefix;
	}

	public static String longestCommonPrefix(String str1, String str2) {
		int length = Math.min(str1.length(), str2.length());
		int index = 0;
		while (index < length && str1.charAt(index) == str2.charAt(index)) {
			index++;
		}
		return str1.substring(0, index);
	}

	/**
	 * 官方题解二：纵向扫描
	 * 方法一是横向扫描，依次遍历每个字符串，更新最长公共前缀。另一种方法是纵向扫描。
	 * 纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，
	 * 如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀。
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix_2(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int length = strs[0].length();
		int count = strs.length;
		for (int i = 0; i < length; i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < count; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}

	/**
	 * 官方题解三：分治
	 * 可以使用分治法得到字符串数组中的最长公共前缀。对于问题LCP(Si⋯Sj)，可以分解成两个子问题LCP(Si…Smid) 与LCP(Smid+1…Sj)，其中mid=(i+j)/2。
	 * 对两个子问题分别求解，然后对两个子问题的解计算最长公共前缀，即为原问题的解
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix_3(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		} else {
			return longestCommonPrefix(strs, 0, strs.length - 1);
		}
	}

	public static String longestCommonPrefix(String[] strs, int start, int end) {
		if (start == end) {
			return strs[start];
		} else {
			int mid = (end - start) / 2 + start;
			String lcpLeft = longestCommonPrefix(strs, start, mid);
			String lcpRight = longestCommonPrefix(strs, mid + 1, end);
			return commonPrefix(lcpLeft, lcpRight);
		}
	}

	public static String commonPrefix(String lcpLeft, String lcpRight) {
		int minLength = Math.min(lcpLeft.length(), lcpRight.length());
		for (int i = 0; i < minLength; i++) {
			if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
				return lcpLeft.substring(0, i);
			}
		}
		return lcpLeft.substring(0, minLength);
	}

	/**
	 * 官方题解四：二分查找
	 * 显然，最长公共前缀的长度不会超过字符串数组中的最短字符串的长度。用 minLength 表示字符串数组中的最短字符串的长度，则可以在 [0,minLength] 的范围内通过二分查找得到最长公共前缀的长度。
	 * 每次取查找范围的中间值 mid，判断每个字符串的长度为mid 的前缀是否相同，如果相同则最长公共前缀的长度一定大于或等于mid，如果不相同则最长公共前缀的长度一定小于mid，通过上述方式将查找范围缩小一半，直到得到最长公共前缀的长度。
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix_4(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int minLength = Integer.MAX_VALUE;
		for (String str : strs) {
			minLength = Math.min(minLength, str.length());
		}
		int low = 0, high = minLength;
		while (low < high) {
			int mid = (high - low + 1) / 2 + low;
			if (isCommonPrefix(strs, mid)) {
				low = mid;
			} else {
				high = mid - 1;
			}
		}
		return strs[0].substring(0, low);
	}
	public static boolean isCommonPrefix(String[] strs, int length) {
		String str0 = strs[0].substring(0, length);
		int count = strs.length;
		for (int i = 1; i < count; i++) {
			String str = strs[i];
			for (int j = 0; j < length; j++) {
				if (str0.charAt(j) != str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
}
