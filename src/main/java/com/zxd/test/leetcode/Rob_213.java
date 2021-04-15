package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/house-robber-ii/
 * @Author zouxiaodong
 * @Date 2021/04/15 9:18
 */
//213. 打家劫舍 II
//        你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
//        同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//        给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
//
//        示例 1：
//        输入：nums = [2,3,2]
//        输出：3
//        解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。

//        示例 2：
//        输入：nums = [1,2,3,1]
//        输出：4
//        解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//        偷窃到的最高金额 = 1 + 3 = 4 。

//        示例 3：
//        输入：nums = [0]
//        输出：0
//
//
//        提示：
//
//        1 <= nums.length <= 100
//        0 <= nums[i] <= 1000
public class Rob_213 {

    public static void main(String[] args) {
        Rob_213 rob_213 = new Rob_213();
        System.out.println(rob_213.rob(new int[]{2,3,2}));
        System.out.println(rob_213.rob(new int[]{1,2,3,1}));
        System.out.println(rob_213.rob(new int[]{0}));
        System.out.println(rob_213.rob(new int[]{1,2,1,1}));
        System.out.println(rob_213.rob(new int[]{1,7,9,2}));
    }

    /**
     * @Author zouxiaodong
     * @Description 动态规划:dp[i]=max(dp[i−2]+nums[i],dp[i−1])
     * 分别取 (start,end)=(0,n−2) 和(start,end)=(1,n−1) 进行计算，取两个dp[end] 中的最大值，即可得到最终结果
     * @Date 2021/04/15 9:56
     * @Param [nums]
     * @return int
     **/
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }else if(len == 2){
            return Math.max(nums[0],nums[1]);
        }
        //0~n-2
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<len-1;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);

        }
        //1~n-1
        int[] dp1 = new int[len];
        dp1[1] = nums[1];
        dp1[2] = Math.max(nums[1],nums[2]);
        for(int i=3;i<=len-1;i++){
            dp1[i] = Math.max(dp1[i-2]+nums[i],dp1[i-1]);
        }
        return Math.max(dp[len-2],dp1[len-1]);
    }
}
