package com.zxd.test.leetcode;

/**
 * @ClassName SearchMatrix_74
 * @Description https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @Author xiaodong.zou
 * @Date 2021/3/30 21:39
 * @Version 1.0
 */
//74. 搜索二维矩阵
//        编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//        每行中的整数从左到右按升序排列。
//        每行的第一个整数大于前一行的最后一个整数。
//
//
//        示例 1：
//          1  3  5  7
//          10 11 16 20
//          23 30 34 60
//
//        输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//        输出：true
//        示例 2：
//          1  3  5  7
//          10 11 16 20
//          23 30 34 60
//
//        输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//        输出：false
//
//
//        提示：
//
//        m == matrix.length
//        n == matrix[i].length
//        1 <= m, n <= 100
//        -10^4 <= matrix[i][j], target <= 10^4
public class SearchMatrix_74 {

    public static void main(String[] args) {
        SearchMatrix_74 searchMatrix_74 = new SearchMatrix_74();
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int[][] matrix = new int[][]{{1,3}};
        System.out.println(searchMatrix_74.searchMatrix(matrix,13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(matrix[0][0]<=target && matrix[row-1][col-1]>=target){
            int i=0;
            while (i<row){
                if(matrix[i][col-1] == target){
                    return true;
                }
                if(matrix[i][col-1]<target){
                    i++;
                    continue;
                }
                //折半查找
                int l = 0,r=col-1;
                while (l<=r){
                    int mid = (l+r+1)/2;
                    if(matrix[i][mid]==target){
                        return true;
                    }else if(matrix[i][mid]>target){
                        r = mid-1;
                    }else{
                        l = mid+1;
                    }
                }
                return false;
            }

        }
        return false;
    }
}
