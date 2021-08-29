package com.zxd.test.leetcode;

/**
 * @Title: RunningSum_1480
 * @Description: https://leetcode-cn.com/problems/running-sum-of-1d-array/
 * @Author xiaodong.zou
 * @Date 2020/6/16 16:59
 */
//1480. 一维数组的动态和
//		给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
//
//		请返回 nums 的动态和。
//
//
//
//		示例 1：
//
//		输入：nums = [1,2,3,4]
//		输出：[1,3,6,10]
//		解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
//		示例 2：
//
//		输入：nums = [1,1,1,1,1]
//		输出：[1,2,3,4,5]
//		解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
//		示例 3：
//
//		输入：nums = [3,1,2,10,1]
//		输出：[3,4,6,16,17]
//
//
//		提示：
//
//		1 <= nums.length <= 1000
//		-10^6 <= nums[i] <= 10^6
public class RunningSum_1480 {

	public static void main(String[] args) {
		RunningSum_1480 runningSum_1480 = new RunningSum_1480();
		int[] result = runningSum_1480.runningSum(new int[]{3,1,2,10,1});
		System.out.println(result);
	}

	public int[] runningSum(int[] nums) {
		int len = nums.length;
		int[] result = new int[len];
		if(len<1){
			return result;
		}
		result[0] = nums[0];
		for(int i=1;i<len;i++){
			result[i] = nums[i]+result[i-1];
		}
		return result;
	}

	public int[] runningSum_2(int[] nums) {
		int len = nums.length;
		for(int i=1;i<len;i++){
			nums[i] = nums[i]+nums[i-1];
		}
		return nums;
	}
}
