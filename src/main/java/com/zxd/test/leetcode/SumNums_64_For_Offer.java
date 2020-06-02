package com.zxd.test.leetcode;

/**
 * @Title: SumNums_64_For_Offer
 * @Description: https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @Author xiaodong.zou
 * @Date 2020/6/2 9:37
 */
//面试题64. 求1+2+…+n
//		求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//
//
//
//		示例 1：
//
//		输入: n = 3
//		输出: 6
//		示例 2：
//
//		输入: n = 9
//		输出: 45
//
//
//		限制：
//
//		1 <= n <= 10000
public class SumNums_64_For_Offer {

	public static void main(String[] args) {
		System.out.println(sumNums(1));
		System.out.println(sumNums_OR(1));
	}


//	通常实现递归的时候我们都会利用条件判断语句来决定递归的出口，但由于题目的限制我们不能使用条件判断语句，那么我们是否能使用别的办法来确定递归出口呢？答案就是逻辑运算符的短路性质。
//
//	以逻辑运算符 && 为例，对于 A && B 这个表达式，如果 A 表达式返回False ，那么 A && B 已经确定为 False ，此时不会去执行表达式 B。同理，对于逻辑运算符 ||， 对于 A || B 这个表达式，如果 A 表达式返回True ，
//	那么 A || B 已经确定为 True ，此时不会去执行表达式 B。
//
//	利用这一特性，我们可以将判断是否为递归的出口看作 A && B 表达式中的 A 部分，递归的主体函数看作 B 部分。如果不是递归出口，则返回True，并继续执行表达式 B 的部分，否则递归结束。
//	当然，你也可以用逻辑运算符 || 给出类似的实现，这里我们只提供结合逻辑运算符 && 的递归实现。
//
	public static int sumNums(int n) {
		boolean flag = n>0 && (n += sumNums(n-1)) >0 ;
		return n;
	}

	public static int sumNums_OR(int n) {
		boolean flag = n<1 || (n += sumNums_OR(n-1)) <0 ;
		return n;
	}
}
