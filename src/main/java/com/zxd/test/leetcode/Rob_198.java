package com.zxd.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: Rob_198
 * @Description: https://leetcode-cn.com/problems/house-robber/
 * @Author xiaodong.zou
 * @Date 2020/5/29 9:27
 */
//198. 打家劫舍
//		你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
//		给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//
//		示例 1:
//
//		输入: [1,2,3,1]
//		输出: 4
//		解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//		偷窃到的最高金额 = 1 + 3 = 4 。
//		示例 2:
//
//		输入: [2,7,9,3,1]
//		输出: 12
//		解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//		偷窃到的最高金额 = 2 + 9 + 1 = 12 。
public class Rob_198 {

	public static void main(String[] args) {
//		System.out.println(rob(new int[]{1,2,3,1}));
//		System.out.println(rob_1(new int[]{2,7,9,1,1,3,1,4,1,5}));
//		System.out.println(rob(new int[]{1,9,2}));
//		System.out.println(rob_1(new int[]{1,9,2}));
		System.out.println(rob_1(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
	}

	/**
	 * 动态规划 dp[i] = max(dp[i-2]+nums[2],dp[i-1])
	 * @param nums
	 * @return
	 */
	public static int rob_1(int[] nums) {
		int result = 0;
		int len = nums.length;
		if(len == 0){
			return result;
		}
		int[] dp = new int[len];
		dp[0] = nums[0];
		result = nums[0];
		if(len>=2){
			dp[1] = Math.max(nums[0],nums[1]);
			result = dp[1];
		}
		for(int i=2;i<len;i++){
			dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
			if(dp[i]>result){
				result = dp[i];
			}
		}
		return result;
	}

	public static int rob(int[] nums) {
		int step1 = cr(0,nums);
		int step2 = cr(1,nums);
		return Math.max(step1,step2);
	}

	/**
	 * 方法一：递归，56 / 69 个通过测试用例，57测试用例超时
	 * @param i
	 * @param nums
	 * @return
	 */
	private static int cr(int i,int[] nums){
		int len = nums.length;
		int result = 0;
		for(int step=2;step<=len-i;step++){
			int temp = nums[i]+cr(i+step,nums);
			if(temp>result){
				result = temp;
			}
		}
		if(i<= len-1 && result == 0){
			result = nums[i];
		}
		return result;
	}

}
