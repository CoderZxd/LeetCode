package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description https://leetcode-cn.com/problems/spiral-matrix/
 * @Author zouxiaodong
 * @Date 2021/03/15 9:44
 */
//54. 螺旋矩阵
//        给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//       示例 1：
//          1→2→3
//              ↓
//          4→5 6
//          ↑   ↓
//          7←8←9
//        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//        输出：[1,2,3,6,9,8,7,4,5]

//        示例 2：
//        1→2→3  →4
//                ↓
//        5→6→7  →8
//        ↑       ↓
//        9←10←11←12
//        输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//        输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//        提示：
//        m == matrix.length
//        n == matrix[i].length
//        1 <= m, n <= 10
//        -100 <= matrix[i][j] <= 100
public class SpiralOrder_54 {

    public static void main(String[] args) {
        SpiralOrder_54 spiralOrder_54 = new SpiralOrder_54();
        int[][] matrix = new int[3][4];
//        matrix[0] = new int[]{1,2,3};
//        matrix[1] = new int[]{4,5,6};
//        matrix[2] = new int[]{7,8,9};
        matrix[0] = new int[]{1,2,3,4};
        matrix[1] = new int[]{5,6,7,8};
        matrix[2] = new int[]{9,10,11,12};
        System.out.println(spiralOrder_54.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        //右下左上循环指示
        boolean right = true,down = false, left = false,up = false;
        //数组元素访问缓存,判断循环边界,判断循环方向是否需要变化
        boolean[][] visited = new boolean[row][col];
        int m=0,n=0;
        //如果循环次数到达matrix元素个数,终止
        for(int i=0;i<row*col;i++){
            result.add(matrix[m][n]);
            visited[m][n] = true;
            if(right){
                //如果向右遍历到达了右边界或者右边元素已经遍历过,需要向下遍历
                if(n == col-1 || visited[m][n+1]){
                    m++;
                    right = false;
                    down = true;
                    continue;
                }
                n++;
            }else if(down){
                //如果向下遍历到达了下边界或者下边元素已经遍历过,需要向左遍历
                if(m == row-1 || visited[m+1][n]){
                    n--;
                    down = false;
                    left = true;
                    continue;
                }
                m++;
            }else if(left){
                //如果向左遍历到达了左边界(n=0)或者左边元素已经遍历过,需要向上遍历
                if(n == 0 || visited[m][n-1]){
                    m--;
                    left = false;
                    up =true;
                    continue;
                }
                n--;
            }else if(up){
                //如果向上遍历到达了上边界(m=0)或者上边元素已经遍历过,需要向右遍历
                if(m == 0 || visited[m-1][n]){
                    n++;
                    up = false;
                    right = true;
                    continue;
                }
                m--;
            }
        }
        return result;
    }
}
