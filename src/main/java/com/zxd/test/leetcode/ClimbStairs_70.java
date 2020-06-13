package com.zxd.test.leetcode;

/**
 * @Title: ClimbStairs_70
 * @Description: https://leetcode-cn.com/problems/climbing-stairs/
 * @Author xiaodong.zou
 * @Date 2020/6/13 10:18
 */
//70. 爬楼梯
//		假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//		每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//		注意：给定 n 是一个正整数。
//
//		示例 1：
//
//		输入： 2
//		输出： 2
//		解释： 有两种方法可以爬到楼顶。
//		1.  1 阶 + 1 阶
//		2.  2 阶
//		示例 2：
//
//		输入： 3
//		输出： 3
//		解释： 有三种方法可以爬到楼顶。
//		1.  1 阶 + 1 阶 + 1 阶
//		2.  1 阶 + 2 阶
//		3.  2 阶 + 1 阶
public class ClimbStairs_70 {

	public static void main(String[] args) {
		System.out.println(climbStairs(1));
		System.out.println(climbStairs_1(1));
		System.out.println(climbStairs_2(1));
		System.out.println(climbStairs(2));
		System.out.println(climbStairs_1(2));
		System.out.println(climbStairs_2(2));
		System.out.println(climbStairs(3));
		System.out.println(climbStairs_1(3));
		System.out.println(climbStairs_2(3));
		System.out.println(climbStairs(45));
		System.out.println(climbStairs_1(45));
		System.out.println(climbStairs_2(45));
	}

	/**
	 * 动态规划
	 * dp[i] = dp[i-1]+dp[i-2]
	 * @param n
	 * @return
	 */
	public static int climbStairs_1(int n) {
		if(n<=2){
			return n;
		}
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=n;i++){
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}

	/**
	 * 动态规划（减少内存消耗）
	 * dp[i] = dp[i-1]+dp[i-2]
	 * @param n
	 * @return
	 */
	public static int climbStairs_2(int n) {
		if(n<=2){
			return n;
		}
		int before_1 = 2,before_2 = 1;
		for(int i=3;i<=n;i++){
			int result = before_1+before_2;
			before_2 = before_1;
			before_1 = result;
		}
		return before_1;
	}

	/**
	 * Java的话因为返回值为int，n=46时，结果会溢出，因此n < 46，那么就有
	 * @param n
	 * @return
	 */
	public int climbStairs_3(int n) {

		int result = 0;

		switch(n){
			case 1: result = 1; break;
			case 2: result = 2; break;
			case 3: result = 3; break;
			case 4: result = 5; break;
			case 5: result = 8; break;
			case 6: result = 13; break;
			case 7: result = 21; break;
			case 8: result = 34; break;
			case 9: result = 55; break;
			case 10: result = 89; break;
			case 11: result = 144; break;
			case 12: result = 233; break;
			case 13: result = 377; break;
			case 14: result = 610; break;
			case 15: result = 987; break;
			case 16: result = 1597; break;
			case 17: result = 2584; break;
			case 18: result = 4181; break;
			case 19: result = 6765; break;
			case 20: result = 10946; break;
			case 21: result = 17711; break;
			case 22: result = 28657; break;
			case 23: result = 46368; break;
			case 24: result = 75025; break;
			case 25: result = 121393; break;
			case 26: result = 196418; break;
			case 27: result = 317811; break;
			case 28: result = 514229; break;
			case 29: result = 832040; break;
			case 30: result = 1346269; break;
			case 31: result = 2178309; break;
			case 32: result = 3524578; break;
			case 33: result = 5702887; break;
			case 34: result = 9227465; break;
			case 35: result = 14930352; break;
			case 36: result = 24157817; break;
			case 37: result = 39088169; break;
			case 38: result = 63245986; break;
			case 39: result = 102334155; break;
			case 40: result = 165580141; break;
			case 41: result = 267914296; break;
			case 42: result = 433494437; break;
			case 43: result = 701408733; break;
			case 44: result = 1134903170; break;
			case 45: result = 1836311903; break;

		}
		return result;
	}

	/**
	 * 递归,31 / 45 个通过测试用例,32超时
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		if(n<=2){
			return n;
		}else{
			return climbStairs(n-1)+climbStairs(n-2);
		}
	}
}
