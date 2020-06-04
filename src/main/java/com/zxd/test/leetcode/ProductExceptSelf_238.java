package com.zxd.test.leetcode;

/**
 * @Title: ProductExceptSelf_238
 * @Description: https://leetcode-cn.com/problems/product-of-array-except-self/
 * @Author xiaodong.zou
 * @Date 2020/6/4 9:13
 */
//238. 除自身以外数组的乘积
//		给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
//
//
//
//		示例:
//
//		输入: [1,2,3,4]
//		输出: [24,12,8,6]
//
//
//		提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
//
//		说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
//		进阶：
//		你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
public class ProductExceptSelf_238 {

	public static void main(String[] args) {
		productExceptSelf(new int[]{1,2,3,4});
	}

	/**
	 * 动态规划
	 * output[i] = multi[i-1]*rightMulti[i+1];
	 * @param nums
	 * @return
	 */
	public static int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		//返回结果
		int[] output = new int[len];
		/**
		 * 存放当前元素i之前所有元素的乘积
		 */
		int[] multi = new int[len];
		/**
		 * 第0个元素的乘积为自己本身
		 */
		multi[0] = nums[0];
		for(int i=1;i<len;i++){
			multi[i] = nums[i] * multi[i-1];
		}
		System.out.println(multi);
		/**
		 * 存放当前元素i之后所有元素的乘积
		 */
		int[] rightMulti = new int[len+1];
		/**
		 * 最后一个元素因为没有最右，所以存入1
		 */
		rightMulti[len] = 1;
		//当前元素i最右乘积=当前元素值i*元素i+1最右乘积
		for(int i=len-1;i>0;i--){
			rightMulti[i] = nums[i] * rightMulti[i+1];
		}
		System.out.println(rightMulti);
		//第一个元素值=第一个（i=1）元素的最右乘积
		/**
		 * 输出结果可以得到如下规律:
		 * output[i] = multi[i-1]*rightMulti[i+1];
		 */
		output[0] = rightMulti[1];
		for(int i=1;i<len;i++){
			output[i] = multi[i-1] * rightMulti[i+1];
		}
		return output;
	}

}
