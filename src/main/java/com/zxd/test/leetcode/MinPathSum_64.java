package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/minimum-path-sum/
 * @Author zouxiaodong
 * @Date 2020/07/23 8:00
 */
//64. 最小路径和
//        给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//        说明：每次只能向下或者向右移动一步。
//
//        示例:
//
//        输入:
//        [
//        [1,3,1],
//        [1,5,1],
//        [4,2,1]
//        ]
//        输出: 7
//        解释: 因为路径 1→3→1→1→1 的总和最小。
public class MinPathSum_64 {

    public static void main(String[] args) {
        MinPathSum_64 minPathSum = new MinPathSum_64();
        System.out.println(minPathSum.minPathSum(new int[][]{new int[]{1,3,1},new int[]{1,5,1},new int[]{4,2,1}}));
    }

    /**
     * @Author zouxiaodong
     * @Description 动态规划
     * 当 i>0,i>0 且 j=0j=0 时，dp[i][0]=dp[i−1][0]+grid[i][0]。
     * 当 i=0,i=0 且 j>0j>0 时，dp[0][j]=dp[0][j−1]+grid[0][j]。
     * 当 i>0,i>0 且 j>0,j>0 时，dp[i][j]=min(dp[i−1][j],dp[i][j−1])+grid[i][j]。
     * @Date 2020/07/23 8:17
     * @Param [grid]
     * @return int
     **/
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }else if(i == 0){
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }else if(j == 0){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[rows-1][cols-1];
    }
}
