package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: MedianSortedArrays_4
 * @Description: 4. 寻找两个有序数组的中位数
 * @Author xiaodong.zou
 * @Date 2019/11/8 17:27
 */
//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
//
//		请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
//		你可以假设 nums1 和 nums2 不会同时为空。
//
//		示例 1:
//
//		nums1 = [1, 3]
//		nums2 = [2]
//
//		则中位数是 2.0
//		示例 2:
//
//		nums1 = [1, 2]
//		nums2 = [3, 4]
//
//		则中位数是 (2 + 3)/2 = 2.5

public class MedianSortedArrays_4 {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int nums1len = nums1.length;
		int nums2len = nums2.length;
		int i=0,j =0;
		List<Integer> temp = new ArrayList<>(nums1len+nums2len);
		while(i<nums1len || j<nums2len){
			if(i<nums1len && j<nums2len){
				if(nums1[i]<=nums2[j]){
					temp.add(nums1[i]);
					i++;
				}else if(nums1[i]>nums2[j]){
					temp.add(nums2[j]);
					j++;
				}
			}else{
				if(i<nums1len){
					temp.add(nums1[i]);
					i++;
				}
				if(j<nums2len){
					temp.add(nums2[j]);
					j++;
				}
			}
		}
		System.out.println(temp);
		if(temp.size()%2 == 0){
			int idx = temp.size()/2;
			return (double)(temp.get(idx)+temp.get(idx-1))/2;
		}else{
			return temp.get((temp.size()-1)/2);
		}
	}
	public static void main(String[] args) {
		int[] nums1 = new int[]{};
		int[] nums2 = new int[]{3,4,5,6,10};
		System.out.println(findMedianSortedArrays(nums1,nums2));
	}
}
