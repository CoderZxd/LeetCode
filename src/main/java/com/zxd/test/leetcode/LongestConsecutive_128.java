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

		System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
		System.out.println(longestConsecutive_1(new int[]{100, 4, 200, 1, 3, 2}));
		System.out.println(longestConsecutive(new int[]{0,0}));
		System.out.println(longestConsecutive_1(new int[]{0,0}));
		System.out.println(longestConsecutive(new int[]{1,3,5,2,4}));
		System.out.println(longestConsecutive_1(new int[]{1,3,5,2,4}));
		System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
		System.out.println(longestConsecutive_1(new int[]{0,3,7,2,5,8,4,6,0,1}));
		System.out.println(longestConsecutive(new int[]{-1,9,-3,-6,7,-8,-6,2,9,2,3,-2,4,-1,0,6,1,-9,6,8,6,5,2}));
		System.out.println(longestConsecutive_1(new int[]{-1,9,-3,-6,7,-8,-6,2,9,2,3,-2,4,-1,0,6,1,-9,6,8,6,5,2}));
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


	public static int longestConsecutive_1(int[] nums) {
		int len = nums.length;
		if(len<=1){
			return len;
		}
		Arrays.sort(nums);
		int maxLen = 1,curLen=1;
		for(int i=1;i<len;i++){
			if(nums[i]-nums[i-1] == 1){
				curLen++;
			}else if(nums[i] == nums[i-1]){
				continue;
			}else {
				if(curLen>maxLen){
					maxLen = curLen;
				}
				curLen = 1;
			}
		}
		return Math.max(maxLen,curLen);
	}

//	方法一：哈希表
//			思路和算法
//
//	我们考虑枚举数组中的每个数 x，考虑以其为起点，不断尝试匹配 x+1, x+2,⋯ 是否存在，假设最长匹配到了x+y，那么以 x 为起点的最长连续序列即为 x, x+1, x+2,⋯,x+y，其长度为y+1，
//	我们不断枚举并更新答案即可。
//
//	对于匹配的过程，暴力的方法是 O(n)遍历数组去看是否存在这个数，但其实更高效的方法是用一个哈希表存储数组中的数，这样查看一个数是否存在即能优化至O(1) 的时间复杂度。
//
//	仅仅是这样我们的算法时间复杂度最坏情况下还是会达到 O(n^2)（即外层需要枚举 O(n)个数，内层需要暴力匹配 O(n)次），无法满足题目的要求。但仔细分析这个过程，
//	我们会发现其中执行了很多不必要的枚举，如果已知有一个 x, x+1, x+2,⋯,x+y 的连续序列，而我们却重新从 x+1，x+2 或者是x+y 处开始尝试匹配，那么得到的结果肯定不会优于枚举 x 为起点的答案，因此我们在外层循环的时候碰到这种情况跳过即可。
//
//	那么怎么判断是否跳过呢？由于我们要枚举的数 x 一定是在数组中不存在前驱数 x-1 的，不然按照上面的分析我们会从 x−1 开始尝试匹配，因此我们每次在哈希表中检查是否存在x−1 即能判断是否需要跳过了。
//	增加了判断跳过的逻辑之后，时间复杂度是多少呢？外层循环需要 O(n) 的时间复杂度，只有当一个数是连续序列的第一个数的情况下才会进入内层循环，然后在内层循环中匹配连续序列中的数，因此数组中的每个数只会进入内层循环一次。根据上述分析可知，总时间复杂度为 O(n)，符合题目要求。
	public int longestConsecutive_2(int[] nums) {
		Set<Integer> num_set = new HashSet<Integer>();
		for (int num : nums) {
			num_set.add(num);
		}

		int longestStreak = 0;
		for (int num : num_set) {
			if (!num_set.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 1;

				while (num_set.contains(currentNum + 1)) {
					currentNum += 1;
					currentStreak += 1;
				}

				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}

		return longestStreak;
	}
}
