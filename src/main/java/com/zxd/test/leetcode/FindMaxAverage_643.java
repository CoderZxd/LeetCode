package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * @Author zouxiaodong
 * @Date 2021/02/04 9:07
 */
//643. 子数组最大平均数 I
//        给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
//
//        示例：
//        输入：[1,12,-5,-6,50,3], k = 4
//        输出：12.75
//        解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
//
//        提示：
//        1 <= k <= n <= 30,000。
//        所给数据范围 [-10,000，10,000]。
public class FindMaxAverage_643 {

    public static void main(String[] args) {
        FindMaxAverage_643 findMaxAverage_643 = new FindMaxAverage_643();
        System.out.println(findMaxAverage_643.findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
        System.out.println(findMaxAverage_643.findMaxAverage(new int[]{1},1));
        System.out.println(findMaxAverage_643.findMaxAverage(new int[]{0,0,3,2,4},5));
    }

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        double maxSum = sum;
        int len = nums.length;
        for(int i=k;i<len;i++){
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum/k;
    }
}
