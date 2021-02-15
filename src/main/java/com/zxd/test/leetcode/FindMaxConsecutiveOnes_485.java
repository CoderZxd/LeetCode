package com.zxd.test.leetcode;

/**
 * @ClassName FindMaxConsecutiveOnes_485
 * @Description https://leetcode-cn.com/problems/max-consecutive-ones/
 * @Author xiaodong.zou
 * @Date 2021/2/15 11:02
 * @Version 1.0
 */
//485. 最大连续1的个数
//        给定一个二进制数组， 计算其中最大连续1的个数。
//        示例 1:
//        输入: [1,1,0,1,1,1]
//        输出: 3
//        解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.

//        注意：
//        输入的数组只包含 0 和1。
//        输入数组的长度是正整数，且不超过 10,000。
public class FindMaxConsecutiveOnes_485 {

    public static void main(String[] args) {
        FindMaxConsecutiveOnes_485 findMaxConsecutiveOnes_485 = new FindMaxConsecutiveOnes_485();
        System.out.println(findMaxConsecutiveOnes_485.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(findMaxConsecutiveOnes_485.findMaxConsecutiveOnes(new int[]{1,1,1,1,1,1}));
        System.out.println(findMaxConsecutiveOnes_485.findMaxConsecutiveOnes(new int[]{1}));
        System.out.println(findMaxConsecutiveOnes_485.findMaxConsecutiveOnes(new int[]{0}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int len = nums.length;
        for(int i=0,j=0;j<len;){
            if(nums[j] == 1){
                result = Math.max(result,j-i+1);
                j++;
            }else{
                i=j+1;
                j=i;
            }
        }
        return result;
    }
}
