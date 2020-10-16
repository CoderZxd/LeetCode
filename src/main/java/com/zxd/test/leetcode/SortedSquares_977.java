package com.zxd.test.leetcode;

import java.util.Arrays;

/**
 * @Description https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @Author zouxiaodong
 * @Date 2020/10/16 8:10
 */
//977. 有序数组的平方
//        给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
//
//        示例 1：
//
//        输入：[-4,-1,0,3,10]
//        输出：[0,1,9,16,100]
//        示例 2：
//
//        输入：[-7,-3,2,3,11]
//        输出：[4,9,9,49,121]
//
//
//        提示：
//
//        1 <= A.length <= 10000
//        -10000 <= A[i] <= 10000
//        A 已按非递减顺序排序。
public class SortedSquares_977 {

    public static void main(String[] args) {

    }

    public int[] sortedSquares(int[] A) {
        int len = A.length;
        if(len > 0){
            for(int i=0;i<len;i++){
                A[i] *= A[i];
            }
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * @Author zouxiaodong
     * @Description 双指针
     * @Date 2020/10/16 8:28
     * @Param [A]
     * @return int[]
     **/
    public int[] sortedSquares_1(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                ++i;
            } else {
                ans[pos] = A[j] * A[j];
                --j;
            }
            --pos;
        }
        return ans;
    }
}
