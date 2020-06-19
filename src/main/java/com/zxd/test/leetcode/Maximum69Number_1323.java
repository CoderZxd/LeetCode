package com.zxd.test.leetcode;

/**
 * @Title: Maximum69Number_1323
 * @Description: https://leetcode-cn.com/problems/maximum-69-number/
 * @Author xiaodong.zou
 * @Date 2020/6/19 17:56
 */
//1323. 6 和 9 组成的最大数字
//		给你一个仅由数字 6 和 9 组成的正整数 num。
//
//		你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
//
//		请返回你可以得到的最大数字。
//
//
//
//		示例 1：
//
//		输入：num = 9669
//		输出：9969
//		解释：
//		改变第一位数字可以得到 6669 。
//		改变第二位数字可以得到 9969 。
//		改变第三位数字可以得到 9699 。
//		改变第四位数字可以得到 9666 。
//		其中最大的数字是 9969 。
//		示例 2：
//
//		输入：num = 9996
//		输出：9999
//		解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
//		示例 3：
//
//		输入：num = 9999
//		输出：9999
//		解释：无需改变就已经是最大的数字了。
//
//
//		提示：
//
//		1 <= num <= 10^4
//		num 每一位上的数字都是 6 或者 9 。
public class Maximum69Number_1323 {

	public static void main(String[] args) {
		Maximum69Number_1323 maximum69Number_1323 = new Maximum69Number_1323();
		System.out.println(maximum69Number_1323.maximum69Number_1(9669));
		System.out.println(maximum69Number_1323.maximum69Number_1(9996));
		System.out.println(maximum69Number_1323.maximum69Number_1(9999));
		System.out.println(maximum69Number_1323.maximum69Number_1(6));
		System.out.println(maximum69Number_1323.maximum69Number_1(69));
		System.out.println(maximum69Number_1323.maximum69Number_1(669));
	}

	/**
	 * 方法二
	 * @param num
	 * @return
	 */
	public int maximum69Number_1(int num) {
		return Integer.parseInt(Integer.toString(num).replaceFirst("6","9"));
	}

	/**
	 * 双百
	 * @param num
	 * @return
	 */
	public int maximum69Number (int num) {
		//如果num小于10,最大只能是9
		if(num<10){
			return 9;
		}
		//如果num<100,高位如果是6,则最大值一定是+30;否则可以直接返回99
		if(num<100){
			if(num/10 == 6){
				return num+30;
			}
			return 99;
		}
		//如果num<1000,高位如果是6,则最大值一定是+300,后继依次判断次高位;否则可以直接返回999
		if(num<1000){
			if(num/100 == 6){
				return num+300;
			}else if(num/10<99){
				return num+30;
			}
			return 999;
		}
		//如果num<10000,高位如果是6,则最大值一定是+3000,后继依次判断次高位;否则可以直接返回9999
		if(num<10000){
			if(num/1000 == 6){
				return num+3000;
			}else if(num/100<99){
				return num+300;
			}else if(num/10<999){
				return num+30;
			}
			return 9999;
		}
		return num;
	}
}
