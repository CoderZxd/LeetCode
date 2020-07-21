package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @Author zouxiaodong
 * @Date 2020/07/20 8:47
 */
//167. 两数之和 II - 输入有序数组
//        给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//
//        函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
//
//        说明:
//
//        返回的下标值（index1 和 index2）不是从零开始的。
//        你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
//        示例:
//
//        输入: numbers = [2, 7, 11, 15], target = 9
//        输出: [1,2]
//        解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
public class TwoSum_167 {

    public static void main(String[] args) {

        TwoSum_167 twoSum = new TwoSum_167();
//        int[] result = twoSum.twoSum(new int[]{2,7,11,15},9);
        int[] result = twoSum.twoSum(new int[]{1,2,5,7,11,15},9);
        System.out.println(result);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int len = numbers.length;
        for(int start=0,end=len-1;start<end;){
            int sum = numbers[start]+numbers[end];
            if(sum == target){
                result[0] = ++start;
                result[1] = ++end;
                return result;
            }
            if(sum > target){
                end--;
            }
            if(sum < target){
                start++;
            }
        }
        return result;
    }
}
