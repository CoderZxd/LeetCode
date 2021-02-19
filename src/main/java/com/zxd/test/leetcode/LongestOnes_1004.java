package com.zxd.test.leetcode;

/**
 * @ClassName LongestOnes_1004
 * @Description https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 * @Author xiaodong.zou
 * @Date 2021/2/19 10:33
 * @Version 1.0
 */
//1004. 最大连续1的个数 III
//        给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
//        返回仅包含 1 的最长（连续）子数组的长度。
//
//        示例 1：
//        输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//        输出：6
//        解释：
//        [1,1,1,0,0,1,1,1,1,1,1]
//        粗体数字从 0 翻转到 1，最长的子数组长度为 6。

//        示例 2：
//        输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//        输出：10
//        解释：
//        [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//        粗体数字从 0 翻转到 1，最长的子数组长度为 10。
//
//        提示：
//        1 <= A.length <= 20000
//        0 <= K <= A.length
//        A[i] 为 0 或 1
public class LongestOnes_1004 {

    public static void main(String[] args) {
        LongestOnes_1004 longestOnes_1004 = new LongestOnes_1004();
        System.out.println(longestOnes_1004.longestOnes_1(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
        System.out.println(longestOnes_1004.longestOnes_1(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
    }

    public int longestOnes(int[] A, int K) {
        int result = 0;
        int k = K;
        int len = A.length;
        for(int i=0,j=0;j<len;){
            if(A[j] == 1){
                result = Math.max(result,j-i+1);
                j++;
            }else{
                k--;
                if(k<0){
                    result = Math.max(result,j-i);
                    i++;
                    j=i;
                    k=K;
                    continue;
                }else{
                    result = Math.max(result,j-i+1);
                    j++;
                }
            }
        }
        return result;
    }

    /**
     * 官方题解
     * @param A
     * @param K
     * @return
     */
    public int longestOnes_1(int[] A, int K) {
        int n = A.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; ++right) {
            rsum += 1 - A[right];
            while (lsum < rsum - K) {
                lsum += 1 - A[left];
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
