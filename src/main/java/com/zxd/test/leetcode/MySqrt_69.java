package com.zxd.test.leetcode;

/**
 * @Title: MySqrt_69
 * @Description: https://leetcode-cn.com/problems/sqrtx/
 * @Author xiaodong.zou
 * @Date 2020/5/9 9:25
 */
//69. x 的平方根
//		实现 int sqrt(int x) 函数。
//
//		计算并返回 x 的平方根，其中 x 是非负整数。
//
//		由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
//		示例 1:
//
//		输入: 4
//		输出: 2
//		示例 2:
//
//		输入: 8
//		输出: 2
//		说明: 8 的平方根是 2.82842...,
//		由于返回类型是整数，小数部分将被舍去。
public class MySqrt_69 {

	public static void main(String[] args) {
		System.out.println(mySqrt(2147395600));
	}

	/**
	 * 暴力破解
	 * @param x
	 * @return
	 */
	public static int mySqrt(int x) {
		int max = (int)Math.ceil(x/2);
		System.out.println("max:"+max);
		for(int i=1;i<=max;i++){
			if(((long)i*i)<=x && ((long)(i+1)*(i+1))>x){
				return i;
			}
		}
		return x;
	}
}
