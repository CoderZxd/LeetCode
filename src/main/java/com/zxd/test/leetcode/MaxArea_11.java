package com.zxd.test.leetcode;

/**
 * @Title: MaxArea_11
 * @Description: https://leetcode-cn.com/problems/container-with-most-water/
 * @Author xiaodong.zou
 * @Date 2020/4/21 9:24
 */
//11. 盛最多水的容器
//		给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//		说明：你不能倾斜容器，且 n 的值至少为 2。
//
//
//
//
//
//		图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
//
//
//		示例：
//
//		输入：[1,8,6,2,5,4,8,3,7]
//		输出：49
public class MaxArea_11 {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{1,8}));
		System.out.println(maxArea_2(new int[]{1,8,6,2,5,4,8,3,7}));
	}

	/**
	 * 解法一
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		int result = 0;
		int len = height.length;
		for(int i=0;i<len-1;i++){
			for(int j=i+1;j<len;j++){
				if(Math.min(height[i],height[j])*(j-i)>result){
					result = Math.min(height[i],height[j])*(j-i);
				}
			}
		}
		return result;
	}

	/**
	 * 解法二:双指针法
	 * @param height
	 * @return
	 */
	public static int maxArea_2(int[] height){
		int result = 0;
		int len = height.length;
		int start = 0;
		int end = len - 1;
		while (start<end){
			if(Math.min(height[start],height[end])*(end-start)>result){
				result = Math.min(height[start],height[end])*(end-start);
			}
			if(height[start]<=height[end]){
				start++;
			}else{
				end--;
			}
		}
		return result;
	}
}
