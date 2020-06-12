package com.zxd.test.leetcode;

import java.util.*;

/**
 * @Title: ThreeSum_15
 * @Description: https://leetcode-cn.com/problems/3sum/
 * @Author xiaodong.zou
 * @Date 2020/6/12 9:09
 */
//15. 三数之和
//		给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
//
//		注意：答案中不可以包含重复的三元组。
//
//
//
//		示例：
//
//		给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//		满足要求的三元组集合为：
//		[
//		[-1, 0, 1],
//		[-1, -1, 2]
//		]
public class ThreeSum_15 {

	public static void main(String[] args) {
		threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//		threeSum(new int[]{0,0,0,0});
	}

	/**
	 * 311 / 313 个通过测试用例,312超出时间限制
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>(10);
		Set<List<Integer>> listSet = new HashSet<>();
		Arrays.sort(nums);
		int len = nums.length;
		List<Integer> numsList = new ArrayList<>(len);
		for(int ele:nums){
			numsList.add(ele);
		}
		for(int i=0;i<=len-2;i++){
			for(int j=i+1;j<=len-1;j++){
				List<Integer> tempList = new ArrayList<>(3);
				int remain = 0-numsList.get(i)-numsList.get(j);
				if(numsList.contains(remain) && numsList.lastIndexOf(remain) > i && numsList.lastIndexOf(remain) > j){
					tempList.add(numsList.get(i));
					tempList.add(numsList.get(j));
					tempList.add(remain);
					listSet.add(tempList);
				}
			}
			if(i+1<len && numsList.get(i).equals(numsList.get(i+1))){
				i++;
			}
		}
		resultList.addAll(listSet);
		return resultList;
	}

}
