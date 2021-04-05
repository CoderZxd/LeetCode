package com.zxd.test.leetcode;

/**
 * @ClassName Solution_88
 * @Description https://leetcode-cn.com/problems/merge-sorted-array/
 * @Author xiaodong.zou
 * @Date 2021/4/5 17:11
 * @Version 1.0
 */
//88. 合并两个有序数组
//        给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//        初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
//
//        示例 1：
//        输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//        输出：[1,2,2,3,5,6]

//        示例 2：
//        输入：nums1 = [1], m = 1, nums2 = [], n = 0
//        输出：[1]
//
//        提示：
//        nums1.length == m + n
//        nums2.length == n
//        0 <= m, n <= 200
//        1 <= m + n <= 200
//        -10^9 <= nums1[i], nums2[i] <= 10^9
public class Solution_88 {

    public static void main(String[] args) {
        Solution_88 solution_88 = new Solution_88();
        solution_88.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int l=0,r=0,cur=0;
        while (l<m || r<n){
            if (l==m){
                result[cur++]=nums2[r++];
            }else if(r==n){
                result[cur++]=nums1[l++];
            }else if(nums1[l]<nums2[r]){
                result[cur++]=nums1[l++];
            }else{
                result[cur++]=nums2[r++];
            }
        }
        for(int i=0;i<m+n;i++){
            nums1[i]=result[i];
        }
    }
}
