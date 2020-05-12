package com.zxd.test.leetcode;

/**
 * @Title: MyPow_50
 * @Description: https://leetcode-cn.com/problems/powx-n/
 * @Author xiaodong.zou
 * @Date 2020/5/11 16:37
 */
//50. Pow(x, n)
//		实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//
//		示例 1:
//
//		输入: 2.00000, 10
//		输出: 1024.00000
//		示例 2:
//
//		输入: 2.10000, 3
//		输出: 9.26100
//		示例 3:
//
//		输入: 2.00000, -2
//		输出: 0.25000
//		解释: 2^-2 = 1/2^2 = 1/4 = 0.25
//		说明:
//
//		-100.0 < x < 100.0
//		n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
public class MyPow_50 {

	public static void main(String[] args) {
		System.out.println(myPow(2.0,10));
		System.out.println(myPow_2(2.0,10));
	}

	//方法一：快速幂 + 递归
	public static double myPow(double x, int n) {
		return n>=0?quickMul(x,n):1.0/quickMul(x,-n);
	}

	private static double quickMul(double x,int n){
		if(n == 0){
			return 1.0;
		}
		double y = quickMul(x,n/2);
		return n%2 == 0?y*y:y*y*x;
	}

//	方法二：快速幂 + 迭代
	public static double myPow_2(double x, int n) {
		return n>=0?quickMul_2(x,n):1.0/quickMul_2(x,-n);
	}

	private static double quickMul_2(double x,int n){
		double ans = 1.0;
		// 贡献的初始值为 x
		double x_contribute = x;
		// 在对 N 进行二进制拆分的同时计算答案
		while (n > 0) {
			if (n % 2 == 1) {
				// 如果 N 二进制表示的最低位为 1，那么需要计入贡献
				ans *= x_contribute;
			}
			// 将贡献不断地平方
			x_contribute *= x_contribute;
			// 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
			n /= 2;
		}
		return ans;
	}
}
