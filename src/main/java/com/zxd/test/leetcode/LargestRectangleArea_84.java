package com.zxd.test.leetcode;

/**
 * @Title: LargestRectangleArea_84
 * @Description: https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @Author xiaodong.zou
 * @Date 2020/5/30 10:13
 */
//84. 柱状图中最大的矩形
//		给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
//		求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
//
//
//		以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
//
//
//
//
//
//		图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
//
//
//
//		示例:
//
//		输入: [2,1,5,6,2,3]
//		输出: 10
public class LargestRectangleArea_84 {

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
	}

	/**
	 * 方法一:94 / 96 个通过测试用例,执行95测试用例超时
	 * @param heights
	 * @return
	 */
	public static int largestRectangleArea(int[] heights) {
		int len = heights.length;
		int maxArea = 0;
		for(int i=0;i<len;i++){
			for(int j=i;j<len;j++){
				//找到i-j的最小元素
				int area = (j-i+1)*getMinNum(i,j,heights);
				if(area>maxArea){
					maxArea = area;
				}
			}
		}
		return maxArea;
	}

	private static int getMinNum(int i,int j,int[] heights){
		int min = heights[i];
		for(int s=i+1;s<=j;s++){
			if(heights[s]<min){
				min = heights[s];
			}
		}
		return min;
	}
}
