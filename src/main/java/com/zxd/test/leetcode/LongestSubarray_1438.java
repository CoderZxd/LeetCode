package com.zxd.test.leetcode;

import java.util.TreeMap;

/**
 * @ClassName LongestSubarray_1438
 * @Description https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * @Author xiaodong.zou
 * @Date 2021/2/21 10:30
 * @Version 1.0
 */
//1438. 绝对差不超过限制的最长连续子数组
//        给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
//        如果不存在满足条件的子数组，则返回 0 。
//
//        示例 1：
//        输入：nums = [8,2,4,7], limit = 4
//        输出：2
//        解释：所有子数组如下：
//        [8] 最大绝对差 |8-8| = 0 <= 4.
//        [8,2] 最大绝对差 |8-2| = 6 > 4.
//        [8,2,4] 最大绝对差 |8-2| = 6 > 4.
//        [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
//        [2] 最大绝对差 |2-2| = 0 <= 4.
//        [2,4] 最大绝对差 |2-4| = 2 <= 4.
//        [2,4,7] 最大绝对差 |2-7| = 5 > 4.
//        [4] 最大绝对差 |4-4| = 0 <= 4.
//        [4,7] 最大绝对差 |4-7| = 3 <= 4.
//        [7] 最大绝对差 |7-7| = 0 <= 4.
//        因此，满足题意的最长子数组的长度为 2 。

//        示例 2：
//        输入：nums = [10,1,2,4,7,2], limit = 5
//        输出：4
//        解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。

//        示例 3：
//        输入：nums = [4,2,2,2,4,4,2,2], limit = 0
//        输出：3
//
//        提示：
//        1 <= nums.length <= 10^5
//        1 <= nums[i] <= 10^9
//        0 <= limit <= 10^9
public class LongestSubarray_1438 {

    public static void main(String[] args) {
        LongestSubarray_1438 longestSubarray_1438 = new LongestSubarray_1438();
//        System.out.println(longestSubarray_1438.longestSubarray(new int[]{8,2,4,7},4));
//        System.out.println(longestSubarray_1438.longestSubarray(new int[]{10,1,2,4,7,2},5));
//        System.out.println(longestSubarray_1438.longestSubarray(new int[]{4,2,2,2,4,4,2,2},0));
//        System.out.println(longestSubarray_1438.longestSubarray(new int[]{1,5,6,7,8,10,6,5,6},4));
        System.out.println(longestSubarray_1438.longestSubarray(new int[]{24,12,71,33,5,87,10,11,3,58,2,97,97,36,32,35,15,80,24,45,38,9,22,21,33,68,22,85,35,83,92,38,59,90,42,64,61,15,4,40,50,44,54,25,34,14,33,94,66,27,78,56,3,29,3,51,19,5,93,21,58,91,65,87,55,70,29,81,89,67,58,29,68,84,4,51,87,74,42,85,81,55,8,95,39},87));
    }

    /**
     * 52 / 60 个通过测试用例
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        int result = 0;
        int maxLen = 0;
        int min = nums[0];
        int max = nums[0];
        int minIndex = 0;
        for(int i=0;i<nums.length;){
            if(Math.abs(nums[i]-min)<=limit && Math.abs(nums[i]-max)<=limit){
                if(nums[i]<=min){
                    min = nums[i];
                    minIndex = i;
                }else if(nums[i]>=max){
                    max = nums[i];
                }
                maxLen++;
                i++;
            }else{
                result = Math.max(maxLen,result);
                i=minIndex+1;
                min = nums[i];
                max = nums[i];
                maxLen=0;
            }
        }
        result = Math.max(maxLen,result);
        return result;
    }


    public int longestSubarray_offical(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = nums.length;
        int left = 0, right = 0;
        int result = 0;
        while (right < len) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

}
