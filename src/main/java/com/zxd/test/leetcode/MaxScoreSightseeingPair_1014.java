package com.zxd.test.leetcode;

/**
 * @Title: MaxScoreSightseeingPair_1014
 * @Description: https://leetcode-cn.com/problems/best-sightseeing-pair/
 * @Author xiaodong.zou
 * @Date 2020/6/17 9:09
 */
//1014. 最佳观光组合
//		给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
//
//		一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
//
//		返回一对观光景点能取得的最高分。
//
//
//
//		示例：
//
//		输入：[8,1,5,2,6]
//		输出：11
//		解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
//
//
//		提示：
//
//		2 <= A.length <= 50000
//		1 <= A[i] <= 1000
public class MaxScoreSightseeingPair_1014 {

	public static void main(String[] args) {
		MaxScoreSightseeingPair_1014 maxScoreSightseeingPair_1014 = new MaxScoreSightseeingPair_1014();
		int maxScore = maxScoreSightseeingPair_1014.maxScoreSightseeingPair_1(new int[]{8,1,5,2,6});
		System.out.println(maxScore);
	}

	/**
	 * 暴力解法：47 / 52 个通过测试用例,48超时
	 * @param A
	 * @return
	 */
	public int maxScoreSightseeingPair(int[] A) {
		int len = A.length;
		if(len <= 1){
			return A[0];
		}
		int maxScore = 0;
		for(int i=0;i<len-1;i++){
			for(int j=i+1;j<len;j++){
				int score = A[i]+A[j]-(j-i);
				if(score>maxScore){
					maxScore = score;
				}
			}
		}
		return maxScore;
	}

	/**
	 * 动态规划(A[i]+A[j]+i-j=A[i]+i+A[j]-j)
	 * @param A
	 * @return
	 */
	public int maxScoreSightseeingPair_1(int[] A) {
		int left = A[0], result = Integer.MIN_VALUE,len=A.length;
		for (int j = 1; j < len; j++) {
			result = Math.max(result, left + A[j]-j);
			left = Math.max(left, A[j] + j);
		}
		return result;
	}
}
