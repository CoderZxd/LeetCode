package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/transpose-matrix/
 * @Author zouxiaodong
 * @Date 2021/02/25 16:25
 */
//867. 转置矩阵
//        给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
//        矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
//
//        示例 1：
//        输入：matrix = [
//        [1,2,3],
//        [4,5,6],
//        [7,8,9]]
//        输出：[
//        [1,4,7],
//        [2,5,8],
//        [3,6,9]]
//        示例 2：
//        输入：matrix = [
//        [1,2,3],
//        [4,5,6]]
//        输出：[
//        [1,4],
//        [2,5],
//        [3,6]]
//
//        提示：
//        m == matrix.length
//        n == matrix[i].length
//        1 <= m, n <= 1000
//        1 <= m * n <= 10^5
//        -10^9 <= matrix[i][j] <= 10^9
public class Transpose_867 {

    public static void main(String[] args) {
        Transpose_867 transpose_867 = new Transpose_867();
        int[][] matrix = new int[2][3];
        matrix[0] = new int[]{1,2,3};
        matrix[1] = new int[]{4,5,6};
//        matrix[2] = new int[]{7,8,9};
        int[][] transpose = transpose_867.transpose(matrix);
        System.out.println(transpose);
    }

    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[col][row];
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
