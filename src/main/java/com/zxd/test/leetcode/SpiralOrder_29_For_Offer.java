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
//		spiralOrder(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}});
//		spiralOrder(new int[][]{});
		spiralOrder(new int[][]{{1},{2}});
	}

	public static int[] spiralOrder(int[][] matrix) {
		int rows = matrix.length;
		if(rows == 0){
			return new int[0];
		}
		int cols = matrix[0].length;
		int[] result = new int[rows*cols];
		int[][] indexArray = new int[rows][cols];
		boolean continueFlag = true;
		int startRow = -1;
		int startCol = -1;
		int index = 0;
		while (continueFlag){
			continueFlag = false;
			//向右遍历
			startRow++;
			startCol++;
			while (startCol<cols && indexArray[startRow][startCol] != -1){
				result[index] = matrix[startRow][startCol];
				index++;
				indexArray[startRow][startCol] = -1;
				startCol++;
				continueFlag = true;
			}
			//向下遍历
			startRow++;
			startCol--;
			while (startRow<rows && startCol>=0 && indexArray[startRow][startCol] != -1){
				result[index] = matrix[startRow][startCol];
				index++;
				indexArray[startRow][startCol] = -1;
				startRow++;
				continueFlag = true;
			}
			//向右遍历
			startRow--;
			startCol--;
			while (startCol>=0 && startRow>=0 && indexArray[startRow][startCol] != -1){
				result[index] = matrix[startRow][startCol];
				index++;
				indexArray[startRow][startCol] = -1;
				startCol--;
				continueFlag = true;
			}
			//向上遍历
			startRow--;
			startCol++;
			while (startRow>=0 && startCol >=0 && indexArray[startRow][startCol] != -1){
				result[index] = matrix[startRow][startCol];
				index++;
				indexArray[startRow][startCol] = -1;
				startRow--;
				continueFlag = true;
			}
		}
		System.out.println(result);
		return result;
	}

}
