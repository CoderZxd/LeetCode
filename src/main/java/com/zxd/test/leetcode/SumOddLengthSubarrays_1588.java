package com.zxd.test.leetcode;

/**
 * @ClassName SumOddLengthSubarrays_1588
 * @Description https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 * @Author xiaodong.zou
 * @Date 2021/8/29 13:47
 * @Version 1.0
 */
//1588. 所有奇数长度子数组的和
//        给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
//
//        子数组 定义为原数组中的一个连续子序列。
//
//        请你返回 arr 中 所有奇数长度子数组的和 。
//
//
//
//        示例 1：
//
//        输入：arr = [1,4,2,5,3]
//        输出：58
//        解释：所有奇数长度子数组和它们的和为：
//        [1] = 1
//        [4] = 4
//        [2] = 2
//        [5] = 5
//        [3] = 3
//        [1,4,2] = 7
//        [4,2,5] = 11
//        [2,5,3] = 10
//        [1,4,2,5,3] = 15
//        我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
//        示例 2：
//
//        输入：arr = [1,2]
//        输出：3
//        解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
//        示例 3：
//
//        输入：arr = [10,11,12]
//        输出：66
//
//
//        提示：
//
//        1 <= arr.length <= 100
//        1 <= arr[i] <= 1000
public class SumOddLengthSubarrays_1588 {

    public static void main(String[] args) {
        SumOddLengthSubarrays_1588 sumOddLengthSubarrays_1588 = new SumOddLengthSubarrays_1588();
        System.out.println(sumOddLengthSubarrays_1588.sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
        System.out.println(sumOddLengthSubarrays_1588.sumOddLengthSubarrays(new int[]{1,2}));
        System.out.println(sumOddLengthSubarrays_1588.sumOddLengthSubarrays(new int[]{10,11,12}));
    }


//    执行结果：
//    通过
//
//    执行用时：3 ms, 在所有 Java 提交中击败了29.15%的用户
//    内存消耗：36.2 MB, 在所有 Java 提交中击败了14.78%的用户
//    通过测试用例：96/96
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int result =0;
        for(int i=1;i<=len;i=i+2){
            for(int j=0;j<len;j++){
                for(int k=j;k<j+i && j+i<=len;k++){
                    result+=arr[k];
                }
            }
        }
        return result;
    }

    /**
     * 前缀和
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays_1(int[] arr) {
        int n = arr.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + arr[i];
        }
        int sum = 0;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                sum += prefixSums[end + 1] - prefixSums[start];
            }
        }
        return sum;
    }

}
