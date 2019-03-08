package com.zxd.test.leetcode;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: 寻找峰值
 * @Version 1.0
 * @create 2019-03-08 22:20
 **/

//        峰值元素是指其值大于左右相邻值的元素。
//
//        给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
//
//        数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
//
//        你可以假设 nums[-1] = nums[n] = -∞。
//
//        示例 1:
//
//        输入: nums = [1,2,3,1]
//        输出: 2
//        解释: 3 是峰值元素，你的函数应该返回其索引 2。
//        示例 2:
//
//        输入: nums = [1,2,1,3,5,6,4]
//        输出: 1 或 5
//        解释: 你的函数可以返回索引 1，其峰值元素为 2；
//        或者返回索引 5， 其峰值元素为 6。
//        说明:
//
//        你的解法应该是 O(logN) 时间复杂度的。
public class FindPeakElement {
    public static void main(String[] args){
        int[] nums = {3,4,3,2,1};
        System.out.println(findPeakElement(nums));
    }

    private static int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        if(nums[1] < nums[0]){
            return 0;
        }
        if(nums[nums.length-2] < nums[nums.length-1]){
            return nums.length-1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int middle = (start+end)/2;
            if(nums[middle] > nums[middle-1] && nums[middle] > nums[middle+1]){
                return middle;
            }
            if(nums[middle] > nums[middle-1]){
                start = middle + 1;
            }else{
                end = middle;
            }
        }
        return -1;
    }
}
