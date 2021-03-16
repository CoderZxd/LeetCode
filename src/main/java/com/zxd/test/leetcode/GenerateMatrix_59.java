package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @Author zouxiaodong
 * @Date 2021/03/16 9:09
 */
//59. 螺旋矩阵 II
//    给你一个正整数n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//          1→2→3
//              ↓
//          8→9 4
//          ↑   ↓
//          7←6←5
//
//        示例 1：
//        输入：n = 3
//        输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//        示例 2：
//        输入：n = 1
//        输出：[[1]]
//
//
//        提示：
//        1 <= n <= 20
public class GenerateMatrix_59 {

    public static void main(String[] args) {
        GenerateMatrix_59 generateMatrix_59 = new GenerateMatrix_59();
        generateMatrix_59.generateMatrix(5);
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int row = n,col = n;
        //右下左上循环指示
        boolean right = true,down = false, left = false,up = false;
        //数组元素访问缓存,判断循环边界,判断循环方向是否需要变化
        boolean[][] visited = new boolean[row][col];
        int r=0,c=0;
        //如果循环次数到达matrix元素个数,终止
        for(int i=1;i<=n*n;i++){
            matrix[r][c] = i;
            visited[r][c] = true;
            if(right){
                //如果向右遍历到达了右边界或者右边元素已经遍历过,需要向下遍历
                if(c == col-1 || visited[r][c+1]){
                    r++;
                    right = false;
                    down = true;
                    continue;
                }
                c++;
            }else if(down){
                //如果向下遍历到达了下边界或者下边元素已经遍历过,需要向左遍历
                if(r == row-1 || visited[r+1][c]){
                    c--;
                    down = false;
                    left = true;
                    continue;
                }
                r++;
            }else if(left){
                //如果向左遍历到达了左边界(n=0)或者左边元素已经遍历过,需要向上遍历
                if(c == 0 || visited[r][c-1]){
                    r--;
                    left = false;
                    up =true;
                    continue;
                }
                c--;
            }else if(up){
                //如果向上遍历到达了上边界(m=0)或者上边元素已经遍历过,需要向右遍历
                if(r == 0 || visited[r-1][c]){
                    c++;
                    up = false;
                    right = true;
                    continue;
                }
                r--;
            }
        }
        return matrix;
    }
}
