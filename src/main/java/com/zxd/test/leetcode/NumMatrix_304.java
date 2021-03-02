package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * @Author zouxiaodong
 * @Date 2021/03/02 16:54
 */
//304. 二维区域和检索 - 矩阵不可变
//        给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
//        上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
//
//        示例:
//        给定 matrix = [
//        [3, 0, 1, 4, 2],
//        [5, 6, 3, 2, 1],
//        [1, 2, 0, 1, 5],
//        [4, 1, 0, 1, 7],
//        [1, 0, 3, 0, 5]
//        ]
//
//        sumRegion(2, 1, 4, 3) -> 8
//        sumRegion(1, 1, 2, 2) -> 11
//        sumRegion(1, 2, 2, 4) -> 12
//        说明:
//
//        你可以假设矩阵不可变。
//        会多次调用 sumRegion 方法。
//        你可以假设 row1 ≤ row2 且 col1 ≤ col2。
public class NumMatrix_304 {

    private int[][] matrix;

    public NumMatrix_304(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        for(int i=row1;i<=row2;i++){
            for(int j=col1;j<=col2;j++){
                result+=matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{3, 0, 1, 4, 2};
        matrix[1] = new int[]{5, 6, 3, 2, 1};
        matrix[2] = new int[]{1, 2, 0, 1, 5};
        matrix[3] = new int[]{4, 1, 0, 1, 7};
        matrix[4] = new int[]{1, 0, 3, 0, 5};
        NumMatrix_304 numMatrix_304 = new NumMatrix_304(matrix);
        System.out.println(numMatrix_304.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix_304.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix_304.sumRegion(1, 2, 2, 4));
    }
}
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */