package com.zxd.test.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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

    /**
     * 方法一:直接排序
     * @param matrix
     * @param k
     * @return
     */
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


    /**
     * 方法二：归并排序
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest_2(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }
    /**
     * 方法三：二分查找
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest_3(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
