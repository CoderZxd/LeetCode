package com.zxd.test.leetcode;

/**
 * @Title: IncreaseLonggestSubString
 * @Description: 寻找数组中的最长递增字串(可不连续)
 * @Author xiaodong.zou
 * @Date 2020/6/1 16:49
 */
public class IncreaseLonggestSubString {

	/**
	 * 动态规划
	 * dp[0] = 1
	 * dp[i] = nums[i]>nums[i-1]?dp[i-1]+1:dp[i-1]
	 * dp[len-1]即为最长的递增字串的长度
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,3,2,5,6,9,7,8,9};
		int len = nums.length;
		int[] dp = new int[len];
		dp[0] = 1;
		for(int i=1;i<len;i++){
			dp[i] = nums[i]>nums[i-1] ? dp[i-1]+1 : dp[i-1];
		}
		System.out.println("最长递增字符串长度为："+dp[len-1]);
		System.out.println("最长递增字符串为:");
		for(int i=0,j=1;j<len;i++,j++){
			if(dp[i]<dp[j]){
				System.out.println(nums[i]);
				if(j == len-1){
					System.out.println(nums[j]);
				}
			}
		}
	}
}
