package com.zxd.test.leetcode;

/**
 * @Description https://leetcode-cn.com/problems/island-perimeter/
 * @Author zouxiaodong
 * @Date 2020/10/30 8:23
 */
//463. 岛屿的周长
//        给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
//
//        网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
//
//        岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
//
//
//
//        示例 :
//
//        输入:
//        [[0,1,0,0],
//        [1,1,1,0],
//        [0,1,0,0],
//        [1,1,0,0]]
//
//        输出: 16
//
//        解释: 它的周长是下面图片中的 16 个黄色的边：
public class IslandPerimeter_463 {

    public static void main(String[] args) {
        IslandPerimeter_463 islandPerimeter_463 = new IslandPerimeter_463();
        System.out.println(islandPerimeter_463.islandPerimeter(new int[][]{{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}}));
        System.out.println(islandPerimeter_463.islandPerimeter(new int[][]{{1,0}}));
    }

    public int islandPerimeter(int[][] grid) {
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    //上
                    if(i==0 || grid[i-1][j] == 0){
                        result++;
                    }
                    //下
                    if(i==row-1 || grid[i+1][j] == 0){
                        result++;
                    }
                    //左
                    if(j==0 || grid[i][j-1] == 0){
                        result++;
                    }
                    //右
                    if(j==col-1 || grid[i][j+1] == 0){
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
