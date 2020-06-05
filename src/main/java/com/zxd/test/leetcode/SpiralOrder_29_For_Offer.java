package com.zxd.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: SpiralOrder_29_For_Offer
 * @Description: https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * @Author xiaodong.zou
 * @Date 2020/6/5 9:13
 */
//面试题29. 顺时针打印矩阵
//		输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
//		示例 1：
//
//		输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//		输出：[1,2,3,6,9,8,7,4,5]
//		示例 2：
//
//		输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//		输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//		限制：
//
//		0 <= matrix.length <= 100
//		0 <= matrix[i].length <= 100
public class SpiralOrder_29_For_Offer {

	public static void main(String[] args) {
		spiralOrder(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}});
		spiralOrder_1(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}});
		spiralOrder_2(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}});
		spiralOrder(new int[][]{});
		spiralOrder(new int[][]{{1},{2}});
	}

	/**
	 * 顺时针循环遍历：先右→,后下↓，后左←，后上↑顺序进行
	 * @param matrix
	 * @return
	 */
	public static int[] spiralOrder(int[][] matrix) {
		int rows = matrix.length;
		//如果为空，返回空结果
		if(rows == 0){
			return new int[0];
		}
		int cols = matrix[0].length;
		//结果集
		int[] result = new int[rows*cols];
		//遍历过的节点设置为1,便于遍历时寻找结束条件值
		int[][] visited = new int[rows][cols];
		//是否需要继续遍历
		boolean continueFlag = true;
		int startRow = -1;
		int startCol = -1;
		int index = 0;
		while (continueFlag){
			continueFlag = false;
			//向右遍历
			startRow++;
			startCol++;
			while (startCol<cols && visited[startRow][startCol] != 1){
				result[index] = matrix[startRow][startCol];
				index++;
				visited[startRow][startCol] = 1;
				startCol++;
				continueFlag = true;
			}
			//向下遍历
			startRow++;
			startCol--;
			while (startRow<rows && startCol>=0 && visited[startRow][startCol] != 1){
				result[index] = matrix[startRow][startCol];
				index++;
				visited[startRow][startCol] = 1;
				startRow++;
				continueFlag = true;
			}
			//向左遍历
			startRow--;
			startCol--;
			while (startCol>=0 && startRow>=0 && visited[startRow][startCol] != 1){
				result[index] = matrix[startRow][startCol];
				index++;
				visited[startRow][startCol] = 1;
				startCol--;
				continueFlag = true;
			}
			//向上遍历
			startRow--;
			startCol++;
			while (startRow>=0 && startCol >=0 && visited[startRow][startCol] != 1){
				result[index] = matrix[startRow][startCol];
				index++;
				visited[startRow][startCol] = 1;
				startRow--;
				continueFlag = true;
			}
		}
		System.out.println(result);
		return result;
	}

	/**
	 * 官方题解一：模拟
	 * @param matrix
	 * @return
	 */
//	可以模拟打印矩阵的路径。初始位置是矩阵的左上角，初始方向是向右，当路径超出界限或者进入之前访问过的位置时，则顺时针旋转，进入下一个方向。
//
//	判断路径是否进入之前访问过的位置需要使用一个与输入矩阵大小相同的辅助矩阵 visited，其中的每个元素表示该位置是否被访问过。当一个元素被访问时，将 visited 中的对应位置的元素设为已访问。
//
//	如何判断路径是否结束？由于矩阵中的每个元素都被访问一次，因此路径的长度即为矩阵中的元素数量，当路径的长度达到矩阵中的元素数量时即为完整路径，将该路径返回。
	public static int[] spiralOrder_1(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[0];
		}
		int rows = matrix.length, columns = matrix[0].length;
		boolean[][] visited = new boolean[rows][columns];
		int total = rows * columns;
		int[] order = new int[total];
		int row = 0, column = 0;
		int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int directionIndex = 0;
		for (int i = 0; i < total; i++) {
			order[i] = matrix[row][column];
			visited[row][column] = true;
			int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
			if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
				directionIndex = (directionIndex + 1) % 4;
			}
			row += directions[directionIndex][0];
			column += directions[directionIndex][1];
		}
		return order;
	}

	/**
	 * 官方题解二：按层模拟
	 * @param matrix
	 * @return
	 */
//	可以将矩阵看成若干层，首先打印最外层的元素，其次打印次外层的元素，直到打印最内层的元素。
//
//	定义矩阵的第 k 层是到最近边界距离为 k 的所有顶点。例如，下图矩阵最外层元素都是第 1 层，次外层元素都是第 2 层，剩下的元素都是第 3 层。
//
//
//			[[1, 1, 1, 1, 1, 1, 1],
//			[1, 2, 2, 2, 2, 2, 1],
//			[1, 2, 3, 3, 3, 2, 1],
//			[1, 2, 2, 2, 2, 2, 1],
//			[1, 1, 1, 1, 1, 1, 1]]
//	对于每层，从左上方开始以顺时针的顺序遍历所有元素。假设当前层的左上角位于(top,left)，右下角位于(bottom,right)，按照如下顺序遍历当前层的元素。
//
//	1.从左到右遍历上侧元素，依次为 (top,left) 到 (top,right)。
//
//	2.从上到下遍历右侧元素，依次为 (top+1,right) 到(bottom,right)。
//
//	3.如果left<right 且 top<bottom，则从右到左遍历下侧元素，依次为(bottom,right−1)到(bottom,left+1)，以及从下到上遍历左侧元素，依次为(bottom,left)到(top+1,left)。
//
//	遍历完当前层的元素之后，将 left 和top 分别增加 1，将right 和 bottom 分别减少 1，进入下一层继续遍历，直到遍历完所有元素为止。
	public static int[] spiralOrder_2(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[0];
		}
		int rows = matrix.length, columns = matrix[0].length;
		int[] order = new int[rows * columns];
		int index = 0;
		int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
		while (left <= right && top <= bottom) {
			for (int column = left; column <= right; column++) {
				order[index++] = matrix[top][column];
			}
			for (int row = top + 1; row <= bottom; row++) {
				order[index++] = matrix[row][right];
			}
			if (left < right && top < bottom) {
				for (int column = right - 1; column > left; column--) {
					order[index++] = matrix[bottom][column];
				}
				for (int row = bottom; row > top; row--) {
					order[index++] = matrix[row][left];
				}
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		return order;
	}
}
