package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/toeplitz-matrix/
 * @Author zouxiaodong
 * @Date 2021/02/22 15:58
 */
//766. 托普利茨矩阵
//        给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
//
//        如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
//
//
//
//        示例 1：
//
//
//        输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
//        输出：true
//        解释：
//        在上述矩阵中, 其对角线为:
//        "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
//        各条对角线上的所有元素均相同, 因此答案是 True 。
//        示例 2：
//
//
//        输入：matrix = [[1,2],[2,2]]
//        输出：false
//        解释：
//        对角线 "[1, 2]" 上的元素不同。
//
//
//        提示：
//
//        m == matrix.length
//        n == matrix[i].length
//        1 <= m, n <= 20
//        0 <= matrix[i][j] <= 99
//
//
//        进阶：
//
//        如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
//        如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
public class IsToeplitzMatrix_766 {

    public static void main(String[] args) {
        IsToeplitzMatrix_766 isToeplitzMatrix_766 = new IsToeplitzMatrix_766();
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1,2,3,4};
        matrix[1] = new int[]{5,1,2,3};
        matrix[2] = new int[]{9,5,1,2};
        int[][] mx = new int[2][2];
        mx[0] = new int[]{2,2};
        mx[1] = new int[]{2,2};
        int[][] m = new int[1][1];
        m[0]=new int[]{1};
        System.out.println(isToeplitzMatrix_766.isToeplitzMatrix(m));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0,j=0;j<col;j++){
            for(int m=i+1,n=j+1;m<row && n<col;m++,n++){
                if(matrix[i][j] !=  matrix[m][n]){
                    return false;
                }
            }
        }
        for(int i=1,j=0;i<row;i++){
            for(int m=i+1,n=j+1;m<row && n<col;m++,n++){
                if(matrix[i][j] !=  matrix[m][n]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix_offical(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
