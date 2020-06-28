package com.zxd.test.leetcode;

/**
 * @ClassName MinSubArrayLen_209
 * @Description https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @Author xiaodong.zou
 * @Date 2020/6/28 9:18
 * @Version 1.0
 */
//209. 长度最小的子数组
//        给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
//
//        示例:
//
//        输入: s = 7, nums = [2,3,1,2,4,3]
//        输出: 2
//        解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
//        进阶:
//
//        如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
public class MinSubArrayLen_209 {

    public static void main(String[] args) {

        MinSubArrayLen_209 minSubArrayLen209 = new MinSubArrayLen_209();
        System.out.println(minSubArrayLen209.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));

    }

    /**
     * 双层循环判断
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        //如果数组长度为0，返回0
        if(len == 0){
            return 0;
        }
        //设定结果值为当前数组长度+1
        int result = len+1;
        //如果数组长度为1并且元素大于s,返回1，否则返回0
        if(len == 1 && nums[0]>= s){
            return 1;
        }else if(len == 1){
            return 0;
        }
        for(int i=0;i<len;i++){
            //如果元素大于s直接返回1
            if(nums[i]>=s){
                return 1;
            }
            int sum = nums[i];
            for(int j=i+1;j<len;j++){
                //如果j-i+1已经>=result,则当前循环没有更短的了，可提前终止当前内循环
                if(j-i+1>=result){
                    break;
                }else if(sum+nums[j]>=s){
                    if(j-i+1<result){
                        result = j-i+1;
                        break;
                    }
                }else{
                    sum +=nums[j];
                }
            }
        }
        return result == len+1? 0:result;
    }
}
