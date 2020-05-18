package com.zxd.test.leetcode;

/**
 * @Title: MaxProduct_152
 * @Description: https://leetcode-cn.com/problems/maximum-product-subarray/
 * @Author xiaodong.zou
 * @Date 2020/5/18 14:35
 */
//152. 乘积最大子数组
//		给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//
//
//		示例 1:
//
//		输入: [2,3,-2,4]
//		输出: 6
//		解释: 子数组 [2,3] 有最大乘积 6。
//		示例 2:
//
//		输入: [-2,0,-1]
//		输出: 0
//		解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
public class MaxProduct_152 {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[]{-2,0,-1}));
		System.out.println(maxProduct_dp(new int[]{-2,0,-1}));
	}

	public static int maxProduct(int[] nums) {
		int length = nums.length;
		int result = Integer.MIN_VALUE;
		for(int i=0;i<length;i++){
			int temp = nums[i];
			if(temp>result){
				result = nums[i];
			}
			for(int j=i+1;j<length;j++){
				temp*=nums[j];
				if(temp>result){
					result = temp;
				}
			}
		}
		return result;
	}

//方法一：动态规划
	public static int maxProduct_dp(int[] nums) {
		int[] maxF = new int[nums.length];
		int[] minF = new int[nums.length];
		maxF[0] = nums[0];
		minF[0] = nums[0];
		int ans = nums[0];
		for(int i=1;i<nums.length;i++){
			maxF[i] = Math.max(maxF[i-1]*nums[i],Math.max(nums[i],minF[i-1]*nums[i]));
			minF[i] = Math.min(minF[i-1]*nums[i],Math.min(nums[i],maxF[i-1]*nums[i]));
			ans = Math.max(ans,maxF[i]);
		}
		return ans;
	}
}
