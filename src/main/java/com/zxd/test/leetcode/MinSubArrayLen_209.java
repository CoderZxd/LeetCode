package com.zxd.test.leetcode;

import java.util.Arrays;

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


    /**
     * 方法二：前缀和 + 二分查找
     *
     * 方法一的时间复杂度是 O(n^2)，因为在确定每个子数组的开始下标后，找到长度最小的子数组需要 O(n)的时间。如果使用二分查找，则可以将时间优化到 O(logn)。
     *
     * 为了使用二分查找，需要额外创建一个数组sums 用于存储数组nums 的前缀和，其中sums[i] 表示从nums[0] 到 nums[i−1] 的元素和。得到前缀和之后，
     * 对于每个开始下标 i，可通过二分查找得到大于或等于 i 的最小下标bound，使得sums[bound]−sums[i−1]≥s，并更新子数组的最小长度（此时子数组的长度是bound−(i−1)）。
     *
     * 因为这道题保证了数组中每个元素都为正，所以前缀和一定是递增的，这一点保证了二分的正确性。如果题目没有说明数组中每个元素都为正，这里就不能使用二分来查找这个位置了。
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen_1(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    /**
     * 方法三：双指针
     * 在方法一和方法二中，都是每次确定子数组的开始下标，然后得到长度最小的子数组，因此时间复杂度较高。为了降低时间复杂度，可以使用双指针的方法。
     *
     * 定义两个指针start 和end 分别表示子数组的开始位置和结束位置，维护变量 sum 存储子数组中的元素和（即从nums[start] 到nums[end] 的元素和）。
     *
     * 初始状态下，start 和end 都指向下标 0，sum 的值为 0。
     *
     * 每一轮迭代，将nums[end] 加到sum，如果sum≥s，则更新子数组的最小长度（此时子数组的长度是end−start+1），然后将nums[start] 从sum 中减去并将 start 右移，直到 sum<s，
     * 在此过程中同样更新子数组的最小长度。在每一轮迭代的最后，将 end 右移。
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen_2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
