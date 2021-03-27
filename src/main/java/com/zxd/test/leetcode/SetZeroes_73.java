package com.zxd.test.leetcode;

/**
 * @ClassName SetZeroes_73
 * @Description https://leetcode-cn.com/problems/set-matrix-zeroes/
 * @Author xiaodong.zou
 * @Date 2021/3/21 9:01
 * @Version 1.0
 */
//73. 矩阵置零
//        给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
//
//        示例 1:
//        输入:
//        [
//        [1,1,1],
//        [1,0,1],
//        [1,1,1]
//        ]
//        输出:
//        [
//        [1,0,1],
//        [0,0,0],
//        [1,0,1]
//        ]

//        示例 2:
//        输入:
//        [
//        [0,1,2,0],
//        [3,4,5,2],
//        [1,3,1,5]
//        ]
//        输出:
//        [
//        [0,0,0,0],
//        [0,4,5,0],
//        [0,3,1,0]
//        ]
//        进阶:
//        一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
//        一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
//        你能想出一个常数空间的解决方案吗？
public class SetZeroes_73 {

    public static void main(String[] args) {
        SetZeroes_73 setZeroes_73 = new SetZeroes_73();
        int[][] m = new int[3][4];
        m[0] = new int[]{0,1,2,0};
        m[1] = new int[]{3,4,5,2};
        m[2] = new int[]{1,3,1,5};
        setZeroes_73.setZeroes(m);
        System.out.println(m);
    }


    /**
     *  O(m + n) 的额外空间
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] r = new int[row];
        int[] c = new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == 0){
                    r[i] = 1;
                    c[j] = 1;
                }
            }
        }
        for(int i=0;i<row;i++){
            if(r[i] == 1){
                for(int j=0;j<col;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i=0;i<col;i++){
            if(c[i] == 1){
                for(int j=0;j<row;j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
