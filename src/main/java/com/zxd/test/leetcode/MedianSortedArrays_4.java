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

	public static double findMedianSortedArraysOffical(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		if (m > n) { // to ensure m<=n
			int[] temp = A; A = B; B = temp;
			int tmp = m; m = n; n = tmp;
		}
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if (i < iMax && B[j-1] > A[i]){
				iMin = i + 1; // i is too small
			}
			else if (i > iMin && A[i-1] > B[j]) {
				iMax = i - 1; // i is too big
			}
			else { // i is perfect
				int maxLeft = 0;
				if (i == 0) { maxLeft = B[j-1]; }
				else if (j == 0) { maxLeft = A[i-1]; }
				else { maxLeft = Math.max(A[i-1], B[j-1]); }
				if ( (m + n) % 2 == 1 ) { return maxLeft; }

				int minRight = 0;
				if (i == m) { minRight = B[j]; }
				else if (j == n) { minRight = A[i]; }
				else { minRight = Math.min(B[j], A[i]); }

				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}
	public static void main(String[] args) {
		int[] nums1 = new int[]{};
		int[] nums2 = new int[]{3,4,5,6,10};
		System.out.println(findMedianSortedArrays(nums1,nums2));
	}
}
