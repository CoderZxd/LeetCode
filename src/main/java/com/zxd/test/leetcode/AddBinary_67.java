package com.zxd.test.leetcode;

/**
 * @Title: AddBinary_67
 * @Description: https://leetcode-cn.com/problems/add-binary/
 * @Author xiaodong.zou
 * @Date 2020/6/23 9:03
 */
//67. 二进制求和
//		给你两个二进制字符串，返回它们的和（用二进制表示）。
//
//		输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
//		示例 1:
//
//		输入: a = "11", b = "1"
//		输出: "100"
//		示例 2:
//
//		输入: a = "1010", b = "1011"
//		输出: "10101"
//
//
//		提示：
//
//		每个字符串仅由字符 '0' 或 '1' 组成。
//		1 <= a.length, b.length <= 10^4
//		字符串如果不是 "0" ，就都不含前导零。
public class AddBinary_67 {

	public static void main(String[] args) {
		AddBinary_67 addBinary67 = new AddBinary_67();
		System.out.println(addBinary67.addBinary("11","1"));
		System.out.println(addBinary67.addBinary("1010","1011"));
		System.out.println(addBinary67.addBinary("0","0"));
	}

	public String addBinary(String a, String b) {
		StringBuffer sb = new StringBuffer();
		int lenA = a.length();
		int lenB = b.length();
		int carry = 0;
		for(int i=lenA-1,j=lenB-1;i>=0 || j>=0;i--,j--){
			char tempA = '0';
			char tempB = '0';
			if(i>=0){
				tempA = a.charAt(i);
			}
			if(j>=0){
				tempB = b.charAt(j);
			}
			int sum = tempA-'0'+tempB-'0'+carry;
			if(sum == 3){
				carry = 1;
				sum = 1;
			}else if(sum == 2){
				carry = 1;
				sum = 0;
			}else{
				carry = 0;
			}
			sb.append(sum);
		}
		if(carry == 1){
			sb.append(carry);
		}
		return sb.reverse().toString();
	}
}
