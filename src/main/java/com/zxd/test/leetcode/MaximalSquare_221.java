package com.zxd.test.leetcode;

import sun.nio.cs.ext.MacHebrew;

/**
 * @Title: MaximalSquare_221
 * @Description: https://leetcode-cn.com/problems/maximal-square/
 * @Author xiaodong.zou
 * @Date 2020/5/8 14:51
 */
//221. 最大正方形
//		在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
//		示例:
//
//		输入:
//
//		1 0 1 0 0
//		1 0 1 1 1
//		1 1 1 1 1
//		1 0 0 1 0
//
//		输出: 4
public class MaximalSquare_221 {

	public static void main(String[] args) {
		int max = maximalSquare(new char[][]{
				{'0','0','0','1','0','1','1','1'},
				{'0','1','1','0','0','1','0','1'},
				{'1','0','1','1','1','1','0','1'},
				{'0','0','0','1','0','0','0','0'},
				{'0','0','1','0','0','0','1','0'},
				{'1','1','1','0','0','1','1','1'},
				{'1','0','0','1','1','0','0','1'},
				{'0','1','0','0','1','1','0','0'},
				{'1','0','0','1','0','0','0','0'}});
//		int max = maximalSquare(new char[][]{{'1','0','1','0','0'},
//											 {'1','0','1','1','1'},
//											 {'1','1','1','1','1'},
//											 {'1','0','0','1','1'}});
//		int max = maximalSquare(new char[][]{{'1','1'},{'1','1'}});
		System.out.println("max="+max);
	}

//	方法一：暴力法
//	由于正方形的面积等于边长的平方，因此要找到最大正方形的面积，首先需要找到最大正方形的边长，然后计算最大边长的平方即可。
//
//	暴力法是最简单直观的做法，具体做法如下：
//
//	遍历矩阵中的每个元素，每次遇到 1，则将该元素作为正方形的左上角；
//
//	确定正方形的左上角后，根据左上角所在的行和列计算可能的最大正方形的边长（正方形的范围不能超出矩阵的行数和列数），在该边长范围内寻找只包含 1 的最大正方形；
//
//	每次在下方新增一行以及在右方新增一列，判断新增的行和列是否满足所有元素都是 1。
//
//	作者：LeetCode-Solution
//	链接：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
//	来源：力扣（LeetCode）
//	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	public static int maximalSquare(char[][] matrix) {
		int maxSide = 0;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return maxSide;
		}
		int rows = matrix.length, columns = matrix[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (matrix[i][j] == '1') {
					// 遇到一个 1 作为正方形的左上角
					maxSide = Math.max(maxSide, 1);
					// 计算可能的最大正方形边长
					int currentMaxSide = Math.min(rows - i, columns - j);
					for (int k = 1; k < currentMaxSide; k++) {
						// 判断新增的一行一列是否均为 1
						boolean flag = true;
						if (matrix[i + k][j + k] == '0') {
							break;
						}
						for (int m = 0; m < k; m++) {
							if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
								flag = false;
								break;
							}
						}
						if (flag) {
							maxSide = Math.max(maxSide, k + 1);
						} else {
							break;
						}
					}
				}
			}
		}
		int maxSquare = maxSide * maxSide;
		return maxSquare;
	}


//	方法二：动态规划
//	方法一虽然直观，但是时间复杂度太高，有没有办法降低时间复杂度呢？
//
//	可以使用动态规划降低时间复杂度。我们用dp(i,j) 表示以(i,j) 为右下角，且只包含 1 的正方形的边长最大值。如果我们能计算出所有dp(i,j) 的值，那么其中的最大值即为矩阵中只包含 1 的正方形的边长最大值，其平方即为最大正方形的面积。
//
//	那么如何计算 dp 中的每个元素值呢？对于每个位置(i,j)，检查在矩阵中该位置的值：
//
//	如果该位置的值是 0，则dp(i,j)=0，因为当前位置不可能在由 1 组成的正方形中；
//
//	如果该位置的值是 1，则 dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 dp 值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1，状态转移方程如下：
//
//	dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
//
//	此外，还需要考虑边界条件。如果 i和 j 中至少有一个为 0，则以位置(i,j) 为右下角的最大正方形的边长只能是 1，因此dp(i,j)=1。
//
//	以下用一个例子具体说明。原始矩阵如下。
//
//			0 1 1 1 0
//			1 1 1 1 0
//			0 1 1 1 1
//			0 1 1 1 1
//			0 0 1 1 1
//	对应的 dpdp 值如下。
//
//			0 1 1 1 0
//			1 1 2 2 0
//			0 1 2 3 1
//			0 1 2 3 2
//			0 0 1 2 3
//
//	作者：LeetCode-Solution
//	链接：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
//	来源：力扣（LeetCode）
//	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

	/**
	 * 动态规划方法
	 * @param matrix
	 * @return
	 */
	public static int dp(char[][] matrix){
		int maxSide = 0;
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return maxSide;
		}
		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] dp = new int[rows][columns];
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				if(matrix[i][j] == 1){
					if(i==0 || j==0){
						dp[i][j] = 1;
					}else{
						dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
					}
					maxSide = Math.max(dp[i][j],maxSide);
				}
			}
		}
		return maxSide*maxSide;
	}
}
