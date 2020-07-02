package com.zxd.test.leetcode;

import java.util.Arrays;

/**
 * @ClassName KthSmallest_378
 * @Description https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @Author xiaodong.zou
 * @Date 2020/7/2 10:31
 * @Version 1.0
 */
//378. 有序矩阵中第K小的元素
//        给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
//        请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
//
//
//
//        示例：
//
//        matrix = [
//        [ 1,  5,  9],
//        [10, 11, 13],
//        [12, 13, 15]
//        ],
//        k = 8,
//
//        返回 13。
//
//
//        提示：
//        你可以假设 k 的值永远是有效的，1 ≤ k ≤ n^2 。
public class KthSmallest_378 {

    public static void main(String[] args) {

        KthSmallest_378 kthSmallest = new KthSmallest_378();
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1,  5,  9};
        matrix[1] = new int[]{10, 11, 13};
        matrix[2] = new int[]{12, 13, 15};
        System.out.println(kthSmallest.kthSmallest(matrix,8));

    }

    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        int[] nums = new int[length*length];
        int index = 0;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++) {
                nums[index++] = matrix[i][j];
            }
        }
        Arrays.sort(nums);
        return nums[k-1];
    }
}
