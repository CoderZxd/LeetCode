package com.zxd.test.leetcode;

/**
 * @ClassName LongestMountain_845
 * @Description https://leetcode-cn.com/problems/longest-mountain-in-array/
 * @Author xiaodong.zou
 * @Date 2020/10/25 10:55
 * @Version 1.0
 */
//845. 数组中的最长山脉
//        我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
//
//        B.length >= 3
//        存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
//        （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
//
//        给出一个整数数组 A，返回最长 “山脉” 的长度。
//
//        如果不含有 “山脉” 则返回 0。
//
//
//
//        示例 1：
//
//        输入：[2,1,4,7,3,2,5]
//        输出：5
//        解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
//        示例 2：
//
//        输入：[2,2,2]
//        输出：0
//        解释：不含 “山脉”。
//
//
//        提示：
//
//        0 <= A.length <= 10000
//        0 <= A[i] <= 10000
public class LongestMountain_845 {

    public static void main(String[] args) {
        LongestMountain_845 longestMountain_845 = new LongestMountain_845();
        System.out.println(longestMountain_845.longestMountain(new int[]{2,1,4,7,3,2,5}));
        System.out.println(longestMountain_845.longestMountain(new int[]{2,2,2}));
        System.out.println(longestMountain_845.longestMountain(new int[]{0,1,2,3,4,5,6,7,8,9}));
        System.out.println(longestMountain_845.longestMountain(new int[]{875,884,239,731,723,685}));
    }

    /**
     * 动态规划
     * @param A
     * @return
     */
    public int longestMountain(int[] A) {
        int result = 0;
        int len = A.length;
        if(len<3){
            return result;
        }
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        //动态规划，找到递增的序列数
        for(int i=1;i<len;i++){
            if(A[i]>A[i-1]){
                dp1[i] = dp1[i-1]+1;
            }
        }
        //动态规划，逆序找到递减的序列数
        for(int i=len-2;i>0;i--){
            if(A[i]>A[i+1]){
                dp2[i] = dp2[i+1]+1;
            }
        }
        //计算最长的山脉：当前点最长递增与最长递减和，取最大值
        for(int i=0;i<len;i++){
            if(dp1[i]+dp2[i]+1 > result && dp1[i]>0 && dp2[i]>0){
                result = dp1[i]+dp2[i]+1;
            }
        }
        return result;
    }
}
