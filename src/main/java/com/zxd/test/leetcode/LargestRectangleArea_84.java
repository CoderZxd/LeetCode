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
	 * 方法一:暴力解法
	 * @param heights
	 * @return
	 */
	public static int largestRectangleArea(int[] heights) {
		int len = heights.length;
		int maxArea = 0;
		for(int i=0;i<len;i++){
			int w=1,h=heights[i],j=i;
			while (--j>=0 && heights[j]>=h){
				w++;
			}
			j=i;
			while (++j<len && heights[j]>=h){
				w++;
			}
			maxArea = Math.max(maxArea,h*w);
		}
		return maxArea;
	}
}
