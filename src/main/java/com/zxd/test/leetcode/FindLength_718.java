package com.zxd.test.leetcode;

/**
 * @Title: FindLength_718
 * @Description: https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * @Author xiaodong.zou
 * @Date 2020/7/1 9:05
 */
//718. 最长重复子数组
//		给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
//		示例 1:
//
//		输入:
//		A: [1,2,3,2,1]
//		B: [4,3,2,1,4,7]
//		输出: 3
//		解释:
//		长度最长的公共子数组是 [3, 2, 1]。
//		说明:
//
//		1 <= len(A), len(B) <= 1000
//		0 <= A[i], B[i] < 100
public class FindLength_718 {

	public static void main(String[] args) {
		FindLength_718 findLength = new FindLength_718();
		System.out.println(findLength.findLength(new int[]{1,2,3,2,1},new int[]{4,3,2,1,4,7}));
		System.out.println(findLength.findLength_1(new int[]{1,2,3,2,1},new int[]{4,3,2,1,4,7}));
	}

	/**
	 * 方法一：动态规划
	 * @param A
	 * @param B
	 * @return
	 */
	public int findLength(int[] A, int[] B) {
		int n = A.length, m = B.length;
		int[][] dp = new int[n + 1][m + 1];
		int ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
				ans = Math.max(ans, dp[i][j]);
			}
		}
		return ans;
	}

	/**
	 * 方法二：滑动窗口
	 * @param A
	 * @param B
	 * @return
	 */
	public int findLength_1(int[] A, int[] B) {
		int n = A.length, m = B.length;
		int ret = 0;
		for (int i = 0; i < n; i++) {
			int len = Math.min(m, n - i);
			int maxlen = maxLength(A, B, i, 0, len);
			ret = Math.max(ret, maxlen);
		}
		for (int i = 0; i < m; i++) {
			int len = Math.min(n, m - i);
			int maxlen = maxLength(A, B, 0, i, len);
			ret = Math.max(ret, maxlen);
		}
		return ret;
	}

	public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
		int ret = 0, k = 0;
		for (int i = 0; i < len; i++) {
			if (A[addA + i] == B[addB + i]) {
				k++;
			} else {
				k = 0;
			}
			ret = Math.max(ret, k);
		}
		return ret;
	}
}
