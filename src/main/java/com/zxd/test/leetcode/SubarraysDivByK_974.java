package com.zxd.test.leetcode;

/**
 * @Title: SubarraysDivByK_974
 * @Description: https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * @Author xiaodong.zou
 * @Date 2020/5/27 9:05
 */
//
//974. 和可被 K 整除的子数组
//		给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
//
//
//
//		示例：
//
//		输入：A = [4,5,0,-2,-3,1], K = 5
//		输出：7
//		解释：
//		有 7 个子数组满足其元素之和可被 K = 5 整除：
//		[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
//
//
//		提示：
//
//		1 <= A.length <= 30000
//		-10000 <= A[i] <= 10000
//		2 <= K <= 10000
public class SubarraysDivByK_974 {

	public static void main(String[] args) {
		System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
	}

	/**
	 * 方法一(69 / 73 个通过测试用例,70以后会超时间限制)
	 * @param A
	 * @param K
	 * @return
	 */
	public static int subarraysDivByK(int[] A, int K) {
		int result = 0;
		int len = A.length;
		for(int i=0;i<len;i++){
			int sum = 0;
			for(int j=i;j<len;j++){
				sum+=A[j];
				if(sum%K==0){
					result++;
				}
			}
		}
		return result;
	}
}
