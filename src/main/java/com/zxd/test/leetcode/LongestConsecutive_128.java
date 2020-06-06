package com.zxd.test.leetcode;

import java.util.*;

/**
 * @Title: LongestConsecutive_128
 * @Description: https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @Author xiaodong.zou
 * @Date 2020/6/6 10:45
 */
//128. 最长连续序列
//		给定一个未排序的整数数组，找出最长连续序列的长度。
//
//		要求算法的时间复杂度为 O(n)。
//
//		示例:
//
//		输入: [100, 4, 200, 1, 3, 2]
//		输出: 4
//		解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
public class LongestConsecutive_128 {

	public static void main(String[] args) {

//		System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
//		System.out.println(longestConsecutive(new int[]{0,0}));
//		System.out.println(longestConsecutive(new int[]{1,3,5,2,4}));
//		System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
		System.out.println(longestConsecutive(new int[]{-1,9,-3,-6,7,-8,-6,2,9,2,3,-2,4,-1,0,6,1,-9,6,8,6,5,2}));
	}

	/**
	 * 66 / 68 个通过测试用例
	 * @param nums
	 * @return
	 */
	public static int longestConsecutive(int[] nums) {
		int len = nums.length;
		if(len<=1){
			return len;
		}
		Set<Integer> numsSet = new HashSet<>(len*2);
		for(Integer ele:nums){
			numsSet.add(ele);
		}
		int result = 1;
		/**
		 * key:当前ele
		 * value:当前位置判断比当前元素大的元素个数
		 */
		Map<Integer,Integer> maxMap = new HashMap<>(len*2);
		/**
		 * key:当前ele
		 * value:当前位置判断比当前元素小的元素个数
		 */
		Map<Integer,Integer> minMap = new HashMap<>(len*2);
		for(int i=0;i<len;i++){
			int ele = nums[i];
			int max = maxMap.getOrDefault(ele+1,0);
			if(max == 0){
				if(numsSet.contains(ele+1)){
					max++;
				}
			}else{
				max+=1;
			}
			int min = minMap.getOrDefault(ele-1,0);
			if(min == 0){
				if(numsSet.contains(ele-1)){
					min++;
				}
			}else{
				min+=1;
			}
			maxMap.put(ele,max);
			minMap.put(ele,min);
			/**
			 * 如果minMap包含比当前元素大1的元素或者原数组中包含比当前元素大1的元素，则设置当前元素+1的个数为min+1
			 */
			if(minMap.containsKey(ele+1) || numsSet.contains(ele+1)){
				minMap.put(ele+1,min+1);
			}
			/**
			 * 如果maxMap包含比当前元素小1的元素或者原数组中包含比当前元素小1的元素，则设置当前元素-1的个数为max+1
			 */
			if(maxMap.containsKey(ele-1) || numsSet.contains(ele-1)){
				maxMap.put(ele-1,max+1);
			}
			if(max +1+min>result){
				result = max + 1 + min;
			}
		}
		return result;
	}
}
