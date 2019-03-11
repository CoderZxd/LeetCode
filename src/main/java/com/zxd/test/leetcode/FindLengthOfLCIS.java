package com.zxd.test.leetcode;

/**
 * @author CoderZZ
 * @Title: ${FILE_NAME}
 * @Project: LeetCode
 * @Package com.zxd.test.leetcode
 * @description: 最长连续递增序列（找出数组元素比左右元素都小的元素，返回元素间距最大值即可）
 * @Version 1.0
 * @create 2019-03-08 23:14
 **/
//        给定一个未经排序的整数数组，找到最长且连续的的递增序列。
//
//        示例 1:
//
//        输入: [1,3,5,4,7]
//        输出: 3
//        解释: 最长连续递增序列是 [1,3,5], 长度为3。
//        尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
//        示例 2:
//
//        输入: [2,2,2,2,2]
//        输出: 1
//        解释: 最长连续递增序列是 [2], 长度为1。
//        注意：数组长度不会超过10000。
public class FindLengthOfLCIS {
    public static void main(String[] args){
        int[] nums = {1,2,3,5};
        System.out.println(findLengthOfLCIS(nums));
    }

    //TODO
    public static int findLengthOfLCIS(int[] nums) {
        int returnIndex = 0;
        if(nums.length == 0){
            return returnIndex;
        }
        if(nums.length == 1){
            return 1;
        }
        if(nums.length == 2 && nums[1] >= nums[0]){
            return 2;
        }
        int start = 0;
        int end = start + 1;
        for(;end < nums.length;end++){
            if(nums[end]>nums[end-1]){
                if(end - start > returnIndex){
                    returnIndex = end - start;
                }
            }else{
                start = end;
            }
        }
        return returnIndex+1;
    }
}
