package com.zxd.test.leetcode;

/**
 * @Title: DailyTemperatures_739
 * @Description: https://leetcode-cn.com/problems/daily-temperatures/
 * @Author xiaodong.zou
 * @Date 2020/6/11 9:20
 */
//739. 每日温度
//		根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
//
//		例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//
//		提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
public class DailyTemperatures_739 {

	public static void main(String[] args) {
		int[] result = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
		System.out.println(result);
	}


	public static int[] dailyTemperatures(int[] T) {
		int len = T.length;
		int[] result = new int[len];
		if(len == 1){
			return result;
		}
		result[len-1] = 0;
		for(int i=0;i<len-1;i++){
			for(int j=i+1;j<len;j++){
				if(T[j]>T[i]){
					result[i] = j-i;
					break;
				}
			}
		}
		return result;
	}
}
