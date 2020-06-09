package com.zxd.test.leetcode;

/**
 * @Title: TranslateNum_46_For_Offer
 * @Description: https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @Author xiaodong.zou
 * @Date 2020/6/9 9:43
 */
//面试题46. 把数字翻译成字符串
//		给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//
//
//
//		示例 1:
//
//		输入: 12258
//		输出: 5
//		解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
//
//
//		提示：
//
//		0 <= num < 2^31
public class TranslateNum_46_For_Offer {

	public static void main(String[] args) {
		System.out.println(translateNum(12258));
		System.out.println(translateNum(18580));
		System.out.println(translateNum(419605557));
		System.out.println(translateNum(1492916348));
	}

	/**
	 * 动态规划:
	 *  dp[i] = dp[i-1]+((numString.charAt(i-1) == '1' || (numString.charAt(i-1) == '2' && numString.charAt(i) <= '5'))?dp[i-2]:0)
	 * @param num
	 * @return
	 */
	public static int translateNum(int num) {
		String numString = num+"";
		int len = numString.length();
		if(len<=1){
			return len;
		}
		int[] dp = new int[len];
		dp[0] = 1;
		if((numString.charAt(0) <= '2' && numString.charAt(0) >= '1' && numString.charAt(1)<='5') || numString.charAt(0) == '1'){
			dp[1] = 2;
		}else{
			dp[1] = 1;
		}
		for(int i=2;i<len;i++){
			dp[i] = dp[i-1]+((numString.charAt(i-1) == '1' || (numString.charAt(i-1) == '2' && numString.charAt(i) <= '5'))?dp[i-2]:0);
		}
		return dp[len-1];
	}

}
